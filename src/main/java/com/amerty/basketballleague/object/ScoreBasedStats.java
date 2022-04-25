package com.amerty.basketballleague.object;

public class ScoreBasedStats {
    private int wins;
    private int losses;

    private int draws;
    private int points;

    public ScoreBasedStats(int wins, int losses, int draws, int points) {
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.points = points;
    }

    public void AddWin() {
        this.wins++;
        this.points+=3;
    }

    public void AddLoss(){
        this.losses++;
    }

    public void AddDraw(){
        this.draws++;
        this.points++;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getDraws() {
        return draws;
    }

    public int getPoints() {
        return points;
    }
}
