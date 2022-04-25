package com.amerty.basketballleague.utility;

import com.amerty.basketballleague.entity.Team;
import com.amerty.basketballleague.object.ScoreBasedStats;

public class Utility {

    public static int AddToDraws(Team team){
        return team.getDrawCount() + 1;
    }

    public static int AddToWins(Team team){
        return team.getWinCount() + 1;
    }

    public static int AddToLosses(Team team){
        return team.getLossCount() + 1;
    }

    public static int AddToScored(Team team, int score){
        return team.getScoredCount() + score;
    }

    public static int AddToConceded(Team team, int score){
        return team.getConcededCount() + score;
    }

    public static int[] AddToPoints(Team homeTeam, Team guestTeam, int homeScore, int guestScore){
        int homeTeamPoint = homeTeam.getPointCount();
        int guestTeamPoint = guestTeam.getPointCount();
        if(homeScore>guestScore){
            homeTeamPoint += 3;
        }
        else if(guestScore>homeScore) {
            guestTeamPoint += 3;
        }
        else{
            homeTeamPoint ++;
            guestTeamPoint ++;
        }

        return new int[]{homeTeamPoint, guestTeamPoint};
    }

    public static int[] AddToWins(Team homeTeam, Team guestTeam, int homeScore, int guestScore){
        int homeTeamWins = homeTeam.getWinCount();
        int guestTeamWins = guestTeam.getWinCount();
        if(homeScore>guestScore){
            homeTeamWins += 3;
        }
        else if(guestScore>homeScore) {
            guestTeamWins += 3;
        }
        else{
            homeTeamWins ++;
            guestTeamWins ++;
        }

        return new int[]{homeTeamWins, guestTeamWins};
    }

    public static ScoreBasedStats[] GetScoreBasedStats(Team home, Team guest, int homeScore, int guestScore) {
        ScoreBasedStats homeStats = new ScoreBasedStats(home.getWinCount(), home.getLossCount(), home.getDrawCount(), home.getPointCount());
        ScoreBasedStats guestStats = new ScoreBasedStats(guest.getWinCount(), guest.getLossCount(), guest.getDrawCount(), guest.getPointCount());

        if(homeScore>guestScore){
            homeStats.AddWin();
            guestStats.AddLoss();
        }
        else if(guestScore>homeScore) {
            guestStats.AddWin();
            homeStats.AddLoss();
        }
        else{
            homeStats.AddDraw();
            guestStats.AddDraw();
        }

        return new ScoreBasedStats[]{homeStats, guestStats};
    }



}
