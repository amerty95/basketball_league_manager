package com.amerty.basketballleague.utility;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class Exceptions
{

    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Team not found")
    public static class TeamNotFoundException extends RuntimeException {
    }

    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Invalid score(s)")
    public static class InvalidScoreException extends RuntimeException {
    }

    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Invalid team name(s)")
    public static class InvalidTeamNameException extends RuntimeException {
    }

    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Same team names")
    public static class SameTeamNameException extends RuntimeException {
    }

}
