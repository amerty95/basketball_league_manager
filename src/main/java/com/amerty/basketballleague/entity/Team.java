package com.amerty.basketballleague.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="teams")
public class Team {
    @Id
    @Column(name="team_id")
    private int teamId;
    @Column(name="team_name")
    private String teamName;
    @Column(name="win_count")
    private int winCount;
    @Column(name="loss_count")
    private int lossCount;
    @Column(name="draw_count")
    private int drawCount;
    @Column(name="point_count")
    private int pointCount;
    @Column(name="scored")
    private int scoredCount;
    @Column(name="conceded")
    private int concededCount;

    public Team() {
    }

    public int getTeamId() {
        return teamId;
    }


    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getWinCount() {
        return winCount;
    }

    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }

    public int getLossCount() {
        return lossCount;
    }

    public void setLossCount(int lossCount) {
        this.lossCount = lossCount;
    }

    public int getDrawCount() {
        return drawCount;
    }

    public void setDrawCount(int drawCount) {
        this.drawCount = drawCount;
    }

    public int getPointCount() {
        return pointCount;
    }

    public void setPointCount(int pointCount) {
        this.pointCount = pointCount;
    }

    public int getScoredCount() {
        return scoredCount;
    }

    public void setScoredCount(int scoredCount) {
        this.scoredCount = scoredCount;
    }

    public int getConcededCount() {
        return concededCount;
    }

    public void setConcededCount(int concededCount) {
        this.concededCount = concededCount;
    }
}
