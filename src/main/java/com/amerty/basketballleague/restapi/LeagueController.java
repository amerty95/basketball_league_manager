package com.amerty.basketballleague.restapi;

import com.amerty.basketballleague.object.MatchScoreInput;
import com.amerty.basketballleague.object.MatchScoreOutput;
import com.amerty.basketballleague.object.TeamInfo;
import com.amerty.basketballleague.service.ILeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class LeagueController {

    private ILeagueService leagueService;

    @Autowired
    public LeagueController(ILeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @GetMapping("/hello")
    public String HelloWorld(){
        return "Hello World";
    }

    @PostMapping("/v1/match-score")
    public MatchScoreOutput AddMatchScore(@RequestBody MatchScoreInput input){
        return leagueService.AddMatchScore(input);
    }

    @GetMapping("/v1/team/{teamName}")
    public TeamInfo GetTeamInfo(@PathVariable("teamName") String teamName){
        return leagueService.getTeam(teamName);
    }

    @GetMapping("/v1/team-standings")
    public String GetTeamStandings(){
        return leagueService.getTeamStandings();
    }


}
