package com.amerty.basketballleague.object;

public class MatchScoreInput {
    public String home;
    public String guest;
    public int hScore;
    public int gScore;

    public MatchScoreInput(String home, String guest, int hScore, int gScore) {
        this.home = home;
        this.guest = guest;
        this.hScore = hScore;
        this.gScore = gScore;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    public int gethScore() {
        return hScore;
    }

    public void sethScore(int hScore) {
        this.hScore = hScore;
    }

    public int getgScore() {
        return gScore;
    }

    public void setgScore(int gScore) {
        this.gScore = gScore;
    }
}
