package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Mafia extends Player{

    public Mafia() {
        super();
        this.setHp(2500);
        this.setStatus("Mafia");
    }


    public Mafia(String name) {
        super(name);
        this.setHp(2500);
        this.setStatus("Mafia");

    }
    public int Choosekill(Player player,ArrayList<Mafia> mafiasarr){
        if(player.getStatus().equals("Mafia")){
            System.out.println("You cannot kill a mafia. Choose another target: ");
            return -1;
        }
        else
        if(player.getHp()<=0 || player.Isout()){
            System.out.println("player selected is not one of remaining players.");
            return -1;



            }




            return 0;
        }


    public void killbyUser(Player player,ArrayList<Mafia> mafiasarr) {

        while (player.getHp() > 0) {
            int a = player.getHp();
            int count = 0;

            for (int i = 0; i < mafiasarr.size(); i++) {
                if (mafiasarr.get(i).getHp() == 0 || mafiasarr.get(i).Isout()) {
                    continue;
                }
                count++;
            }
            if (count == 0) {
                int ggg = 0;
                break;

            } else {
                int deductamount = a / count;
                for (int i = 0; i < mafiasarr.size(); i++) {
                    if (deductamount > this.getHp()) {
                        player.setHp(player.getHp() - this.getHp());
                        mafiasarr.get(i).setHp(0);

                    } else {
                        mafiasarr.get(i).setHp(this.getHp() - deductamount);
                        player.setHp(player.getHp() - deductamount);

                    }

                }

            }
        }
        if(player.getHp()<=0) {
            player.setIsdead(true);
        }
    }
    public int Choosekillai(Player player,ArrayList<Mafia> mafiasarr){
        if(player.getStatus().equals("Mafia")){

            return -1;
        }
        else {
            if(player.Isdead() || player.Isout()){
                return -1;



            }

            return 0;
        }

    }
    @Override
    public int vote(ArrayList<Player> playersarr){
        System.out.print("Choose a person to vote: ");
        Scanner sc=new Scanner(System.in);
        System.out.println("");

        int s=sc.nextInt();
        while(getClass()==playersarr.get(s-1).getClass() || playersarr.get(s-1).Isout()){
            if(playersarr.get(s-1).Isout()){
                System.out.println("Cannot vote out already kicked players.");
                s=sc.nextInt();
                continue;

            }
            System.out.println("Cannot vote out another mafia.");
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
