package com.amerty.basketballleague.service;

import com.amerty.basketballleague.dataaccess.ITeamDataAccess;
import com.amerty.basketballleague.entity.Team;
import com.amerty.basketballleague.object.MatchScoreInput;
import com.amerty.basketballleague.object.MatchScoreOutput;
import com.amerty.basketballleague.object.ScoreBasedStats;
import com.amerty.basketballleague.object.TeamInfo;
import com.amerty.basketballleague.utility.Exceptions;
import com.amerty.basketballleague.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class LeagueService implements ILeagueService {

    private final ITeamDataAccess teamDataAccess;

    @Autowired
    public LeagueService(ITeamDataAccess teamDataAccess) {
        this.teamDataAccess = teamDataAccess;
    }


    @Override
    @Transactional
    public List<Team> getAll() {
        return teamDataAccess.getAll();
    }

    @Override
    @Transactional
    public MatchScoreOutput AddMatchScore(MatchScoreInput input) {
        if(input.gScore<0 || input.hScore<0){
            throw new Exceptions.InvalidScoreException();
        }

        Team homeTeam = teamDataAccess.getTeam(input.getHome());
        Team guestTeam = teamDataAccess.getTeam(input.getGuest());

        if(homeTeam == null || guestTeam == null){
            throw new Exceptions.InvalidTeamNameException();
        }
        else if(input.home.equals(input.guest)){
            throw  new Exceptions.SameTeamNameException();
        }

        homeTeam.setScoredCount(Utility.AddToScored(homeTeam, input.gethScore()));
        homeTeam.setConcededCount(Utility.AddToConceded(homeTeam, input.getgScore()));
        guestTeam.setScoredCount(Utility.AddToScored(guestTeam, input.getgScore()));
        guestTeam.setConcededCount(Utility.AddToConceded(guestTeam, input.gethScore()));

        ScoreBasedStats[] teamPoints = Utility.GetScoreBasedStats(homeTeam, guestTeam, input.gethScore(), input.getgScore());
        homeTeam.setWinCount(teamPoints[0].getWins());
        homeTeam.setPointCount(teamPoints[0].getPoints());
        homeTeam.setDrawCount(teamPoints[0].getDraws());
        homeTeam.setLossCount(teamPoints[0].getLosses());

        guestTeam.setWinCount(teamPoints[1].getWins());
        guestTeam.setPointCount(teamPoints[1].getPoints());
        guestTeam.setDrawCount(teamPoints[1].getDraws());
        guestTeam.setLossCount(teamPoints[1].getLosses());

        teamDataAccess.update(homeTeam);
        teamDataAccess.update(guestTeam);

        return new MatchScoreOutput(0,"Giris basarili bir sekilde yapilmistir");
    }

    @Override
    public TeamInfo getTeam(String teamName) {
        List<Team> teams = teamDataAccess.getTeams();
        Collections.sort(teams, Comparator.comparingInt(Team::getPointCount));
        Collections.reverse(teams);

        Team selectedTeam = teams.stream()
                .filter(i -> teamName.equals(i.getTeamName()))
                .findAny()
                .orElse(null);
        TeamInfo info = new TeamInfo();

        if(selectedTeam != null) {
            info.setWins(selectedTeam.getWinCount());
            info.setLosses(selectedTeam.getLossCount());
            info.setDraws(selectedTeam.getDrawCount());
            info.setPoints(selectedTeam.getPointCount());
            info.setScored(selectedTeam.getScoredCount());
            info.setConceded(selectedTeam.getConcededCount());

            int order = teams.indexOf(selectedTeam);
            info.setRanking(order+1);
        }
        else{
            throw new Exceptions.TeamNotFoundException();
        }

        return info;
    }

    @Override
    public String getTeamStandings() {
        List<Team> teams = teamDataAccess.getTeams();
        Collections.sort(teams, Comparator.comparingInt(Team::getPointCount));
        Collections.reverse(teams);

        StringBuilder  pointTable = new StringBuilder ();
        pointTable.append("team,wins,losses,draws,points,scored,conceded,ranking");

        for(int i=0; i<teams.size(); i++){
            pointTable.append("\n");
            pointTable.append(teams.get(i).getTeamName());
            pointTable.append(",");
            pointTable.append(teams.get(i).getWinCount());
            pointTable.append(",");
            pointTable.append(teams.get(i).getLossCount());
            pointTable.append(",");
            pointTable.append(teams.get(i).getDrawCount());
            pointTable.append(",");
            pointTable.append(teams.get(i).getPointCount());
            pointTable.append(",");
            pointTable.append(teams.get(i).getScoredCount());
            pointTable.append(",");
            pointTable.append(teams.get(i).getConcededCount());
            pointTable.append(",");
            pointTable.append(i+1);
        }
        return pointTable.toString();
    }


    @Override
    @Transactional
    public void update(Team team) {

    }
}
