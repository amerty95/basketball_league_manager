package com.amerty.basketballleague.service;

import com.amerty.basketballleague.entity.Team;
import com.amerty.basketballleague.object.MatchScoreInput;
import com.amerty.basketballleague.object.MatchScoreOutput;
import com.amerty.basketballleague.object.TeamInfo;

import java.util.List;

public interface ILeagueService {
    List<Team> getAll();
    MatchScoreOutput AddMatchScore(MatchScoreInput input);
    TeamInfo getTeam(String teamName);
    String getTeamStandings();
    void update(Team team);
}
