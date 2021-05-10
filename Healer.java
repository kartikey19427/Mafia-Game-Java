package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Healer extends Player {

    public Healer() {
        super();
        this.setHp(800);
        this.setStatus("Healer");
    }


    public Healer(String name) {
        super(name);
        this.setHp(800);
        this.setStatus("Healer");
    }

    public void heal(Player player, ArrayList<Healer> healersarr) {
        int count = 0;
        for (int i = 0; i < healersarr.size(); i++) {
            if (healersarr.get(i).Isout()) {
                continue;
            }
            count++;
        }

        if (count >= 1) {
            if (!player.Isout()) {

                player.setHp(player.getHp() + 500);
                player.setIsdead(false);
            }
        }
    }
    public int vote(ArrayList<Player> playersarr){
        System.out.print("Choose a person to vote: ");
        Scanner sc=new Scanner(System.in);

        int s=sc.nextInt();
        while(getClass()==playersarr.get(s-1).getClass() || playersarr.get(s-1).Isout()){
            System.out.println("Cannot vote out another Healer.");
            s=sc.nextInt();

        }
        playersarr.get(s).addvote();

        return 1;
    }


    @Override
    public int voterandom(ArrayList<Player> playersarr, int N){
        Random rand = new Random();
        int random=rand.nextInt(N);
        while(getClass()==playersarr.get(random).getClass() || playersarr.get(random).Isout()){
            random=rand.nextInt(N);

        }
        playersarr.get(random).addvote();
        return 1;
    }


}
