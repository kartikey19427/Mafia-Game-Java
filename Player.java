package com.company;

import java.util.ArrayList;

public abstract class Player {

    private String name;
    private int hp;
    private boolean isdead;
    private boolean isout;
    private String status;
    private int votes=0;
    private int id;




    public Player() {
        this.isdead=false;
        this.isout=false;

    }

    public Player(String name) {
        this.name = name;
        this.isdead=false;
        this.isout=false;

    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public boolean Isdead() {
        return isdead;
    }
    public void setIsdead(boolean isdead) {
        this.isdead = isdead;
    }
    public boolean Isout() {
        return isout;
    }
    public void setIsout(boolean isout) {
        this.isout = isout;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void addvote(){
        votes=votes+1;
    }

    public abstract int vote(ArrayList<Player> playersarr);

    public abstract int voterandom(ArrayList<Player> playersarr, int N);

}
