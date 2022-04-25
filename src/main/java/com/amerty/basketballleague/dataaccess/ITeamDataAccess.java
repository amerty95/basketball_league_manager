package com.amerty.basketballleague.dataaccess;

import com.amerty.basketballleague.entity.Team;

import java.util.List;

public interface ITeamDataAccess {
    List<Team> getAll();
    Team getTeam(String teamName);
    List<Team> getTeams();
    void update(Team team);
}
