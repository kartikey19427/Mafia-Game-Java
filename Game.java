package com.company;

import java.util.*;

public class Game {
    private ArrayList<Player> playersarr;
    private ArrayList<Mafia> mafiasarr;
    private ArrayList<Healer> healersarr;
    private ArrayList<Detective> detectivesarr;
    private ArrayList<Commoner> commonersarr;



    public Game() {

        boolean complete=false;
        int N=0;
        while(!complete){

            try {
                Scanner sc=new Scanner(System.in);
                System.out.println("Welcome to Mafia");
                System.out.print("Enter Number of players: ");
                N=sc.nextInt();
                if(N<6){
                    continue;
                }
                complete=true;
            }
            catch (InputMismatchException e){
                System.out.println("Wrong input");
            }

        }


        Random rand=new Random();
        System.out.println("Choose a Character");
        System.out.println("1) Mafia");
        System.out.println("2) Detective");
        System.out.println("3) Healer");
        System.out.println("4) Commoner");
        System.out.println("5) Assign Randomly");
        playersarr=new ArrayList<>();
        detectivesarr=new ArrayList<>();
        mafiasarr=new ArrayList<>();
        commonersarr=new ArrayList<>();
        healersarr=new ArrayList<>();


        Scanner sc=new Scanner(System.in);
        int query=sc.nextInt();
        playercreation(playersarr,N);


        if(query==1){
            Mafia user=mafiasarr.get(0);
            System.out.println("You are " + user.getName()+ ".");
            System.out.print("You are a mafia. Other Mafias are: [");
            for(int i=1;i<mafiasarr.size();i++){
                if(i==mafiasarr.size()-1){
                    System.out.print(mafiasarr.get(i).getName());
                    continue;
                }
                System.out.print(mafiasarr.get(i).getName()+", ");
            }
            System.out.print("]");
            System.out.println("");

            Mafiaround(user,N);



        }
        else if(query==2) {
            Detective user=detectivesarr.get(0);
            System.out.println("You are " + user.getName()+ ".");
            System.out.print("You are a detective. Other Detectives are: [");
            for(int i=1;i<detectivesarr.size();i++){
                if(i==detectivesarr.size()-1){
                    System.out.print(detectivesarr.get(i).getName());
                    continue;
                }
                System.out.print(detectivesarr.get(i).getName()+", ");
            }
            System.out.println("]");
            detectiveround(user,N);

        }
        else if(query==3){
            Healer user=healersarr.get(0);
            System.out.println("You are " + user.getName()+ ".");
            System.out.print("You are a healer. Other healers are: [");
            for(int i=1;i<healersarr.size();i++){
                if(i==healersarr.size()-1){
                    System.out.print(healersarr.get(i).getName());
                    continue;
                }
                System.out.print(healersarr.get(i).getName()+", ");
            }
            System.out.println("]");
            healerround(user,N);

        }
        else if(query==4){
            Commoner user=commonersarr.get(0);
            System.out.println("You are " + user.getName()+ ".");
            System.out.print("You are a commoner. Other commoners are: [");
            for(int i=1;i<commonersarr.size();i++){
                if(i==commonersarr.size()-1){
                    System.out.print(commonersarr.get(i).getName());
                    continue;
                }
                System.out.print(commonersarr.get(i).getName()+", ");
            }
            System.out.println("]");
            commoneround(user, N);

        }
        else if(query==5){
            int userNo=rand.nextInt(4)+1;
            Player user=assignRandomly(userNo, N);


        }












    }
    public Integer randomperfectmaf(int max)
    {
        Random rand = new Random();
        int randomNum=rand.nextInt(max);
        while (checkarrmaf(randomNum)){
            randomNum=rand.nextInt(max);

        }



        return randomNum;
    }
    public Integer randomperfectdet(int max)
    {
        Random rand = new Random();
        int randomNum=rand.nextInt(max);
        while (checkarrdet(randomNum)){
            randomNum=rand.nextInt(max);

        }



        return randomNum;
    }
    public Integer randomperfectheal(int max)
    {
        Random rand = new Random();
        int randomNum=rand.nextInt(max);
        while (checkarrheal(randomNum)){
            randomNum=rand.nextInt(max);

        }



        return randomNum;
    }

    public boolean checkarrmaf(int N){
        for(int i=0;i<mafiasarr.size();i++){
            if(mafiasarr.get(i).getId()==N){
                return true;


            }

        }
        return playersarr.get(N).Isout();

    }
    public boolean checkarrdet(int N){
        for(int i=0;i<detectivesarr.size();i++){
            if(detectivesarr.get(i).getId()==N){
                    return true;


            }
        }

        return playersarr.get(N).Isout();

    }
    public boolean checkarrheal(int N){
        for(int i=0;i<healersarr.size();i++){
            if(healersarr.get(i).getId()==N){
                    return true;

            }
        }
        return playersarr.get(N).Isout();

    }

    public void playercreation(ArrayList<Player> playersarr, int N){
        int b=N/5;
        for(int i=0; i<b;i++){
            playersarr.add(new Mafia());
            playersarr.add(new Detective());
        }

        int a=N/10;
        for(int i=0;i<a;i++){
            playersarr.add(new Healer());

        }
        int c=N-(2*b+a);
        for(int i=0;i<c;i++){
            playersarr.add(new Commoner());

        }
        Collections.shuffle(playersarr);
        for(int i=0;i<playersarr.size();i++){
            if(playersarr.get(i).getStatus().equals("Mafia")){
                playersarr.get(i).setName("Player"+(i+1));
                playersarr.get(i).setId(i+1);
                mafiasarr.add((Mafia) playersarr.get(i));



            }
            if(playersarr.get(i).getStatus().equals("Healer")){
                playersarr.get(i).setName("Player"+(i+1));
                playersarr.get(i).setId(i+1);
                healersarr.add((Healer) playersarr.get(i));

            }
            if(playersarr.get(i).getStatus().equals("Detective")){
                playersarr.get(i).setName("Player"+(i+1));
                playersarr.get(i).setId(i+1);
                detectivesarr.add((Detective) playersarr.get(i));

            }
            if(playersarr.get(i).getStatus().equals("Commoner")){
                playersarr.get(i).setName("Player"+(i+1));
                playersarr.get(i).setId(i+1);
                commonersarr.add((Commoner) playersarr.get(i));

            }
        }

    }
    public Player assignRandomly(int userNo, int N){
        if(userNo==1){
            Mafia user=mafiasarr.get(0);
            System.out.print("You are a mafia. Other Mafias are: [");
            for(int i=1;i<mafiasarr.size();i++){
                if(i==mafiasarr.size()-1){
                    System.out.print(mafiasarr.get(i).getName());
                    continue;
                }
                System.out.print(mafiasarr.get(i).getName()+", ");
            }
            System.out.println("]");
            Mafiaround(user, N);
            return user;

        }
        else if(userNo==2){
            Detective user=detectivesarr.get(0);
            System.out.print("You are a detective. Other Detectives are: [");
            for(int i=1;i<detectivesarr.size();i++){
                if(i==detectivesarr.size()-1){
                    System.out.print(detectivesarr.get(i).getName());
                    continue;
                }
                System.out.print(detectivesarr.get(i).getName()+", ");
            }
            System.out.println("]");
            detectiveround(user, N);
            return user;

        }
        else if(userNo==3){
            Healer user=healersarr.get(0);
            System.out.print("You are a healer. Other Healers are: [");
            for(int i=1;i<healersarr.size();i++){
                if(i==healersarr.size()-1){
                    System.out.print(healersarr.get(i).getName());
                    continue;
                }
                System.out.print(healersarr.get(i).getName()+", ");
            }
            System.out.println("]");
            healerround(user, N);
            return user;

        }
        else if(userNo==4){
            Commoner user=commonersarr.get(0);
            System.out.print("You are a commoner. Other Commoners are: [");
            for(int i=1;i<commonersarr.size();i++){
                if(i==commonersarr.size()-1){
                    System.out.print(commonersarr.get(i).getName());
                    continue;
                }
                System.out.print(commonersarr.get(i).getName()+", ");
            }
            System.out.println("]");
            commoneround(user, N);
            return user;

        }
        return new Mafia();



    }


    public void Mafiaround(Mafia user, int N){
        Scanner sc=new Scanner(System.in);
        int x=0;

        while (x < 1) {
            int numbermaf = 0;
            int numberelse = 0;


            for (int i = 0; i < playersarr.size(); i++) {
                if (playersarr.get(i).getStatus().equals("Mafia")) {
                    if (!playersarr.get(i).Isout()) {
                        numbermaf++;

                    }

                }
                else
                    if (!playersarr.get(i).Isout()) {
                    numberelse++;
                }

            }
            if(numberelse<=numbermaf){
                System.out.println("Game Over");
                System.out.println("Mafias won.");
                displayplayers();
                x++;


            }
            if(numbermaf==0){
                System.out.println("Game Over");
                System.out.println("Mafias lost.");
                displayplayers();
                x++;


            }

            if (numberelse >= numbermaf) {


                int playersleft = sortplayers(playersarr);
                if (user.Isout() || user.Isdead()) {
                    int ke = 0;
                    Random rand = new Random();
                    int rander = randomperfectmaf(N);
                    mafiasarr.get(0).killbyUser(playersarr.get(rander), mafiasarr);


                } else {
                    System.out.print("Choose a target: ");
                    int q = sc.nextInt();
                    int y=0;
                    while (y < 1) {
                        int ce = mafiasarr.get(0).Choosekill(playersarr.get(q - 1), mafiasarr);

                        if (ce == -1) {
                            q=sc.nextInt();
                            continue;
                        }
                        y++;
                    }
                    mafiasarr.get(0).killbyUser(playersarr.get(q - 1), mafiasarr);


                }
                System.out.println("Detectives have chosen a player to test.");
                int count = 0;
                for (int i = 0; i < detectivesarr.size(); i++) {
                    if (detectivesarr.get(i).Isout()) {
                        count++;
                    }

                }


                int random = 10000;
                if (count == detectivesarr.size()) {
                    int feg = 0;
                }
                else {
                    random = randomperfectdet(N);
                    String tester = detectivesarr.get(0).Test(playersarr.get(random));

                    if (tester.equals("Mafia")) {
                        playersarr.get(random).setIsout(true);
                        healerandaction(N);
                        System.out.println(playersarr.get(random).getName() + " is a mafia.");
                        for (int i = 0; i < playersarr.size(); i++) {
                            if (playersarr.get(i).Isdead() && !playersarr.get(i).Isout()) {
                                System.out.println(playersarr.get(i).getName() + " has died.");
                                playersarr.get(i).setIsout(true);
                            }

                        }
                        System.out.println(playersarr.get(random).getName() + " has been voted out.");
                        continue;


                    }
                }
                healerandaction(N);
                endofactions(user, N);


            }

        }


    }

    public void detectiveround(Detective user, int N){
        Scanner sc=new Scanner(System.in);
        int x=0;

        while (x < 1) {
            int numbermaf = 0;
            int numberelse = 0;


            for (int i = 0; i < playersarr.size(); i++) {
                if (playersarr.get(i).getStatus().equals("Mafia")) {
                    if (!playersarr.get(i).Isout()) {
                        numbermaf++;

                    }

                }
                else
                if (!playersarr.get(i).Isout()) {
                    numberelse++;
                }

            }
            if(numberelse<=numbermaf){
                System.out.println("Game Over");
                System.out.println("Mafias won.");
                displayplayers();
                break;


            }
            if(numbermaf==0){
                System.out.println("Game Over");
                System.out.println("Mafias lost.");
                displayplayers();
                break;


            }

            if (numberelse >= numbermaf) {


                int playersleft = sortplayers(playersarr);

                    int ke = 0;
                    Random rand = new Random();
                    int rander = randomperfectmaf(N);
                    mafiasarr.get(0).killbyUser(playersarr.get(rander), mafiasarr);
                    System.out.println("Mafias have chosen a target.");



                int count = 0;
                for (int i = 0; i < detectivesarr.size(); i++) {
                    if (detectivesarr.get(i).Isout()) {
                        count++;
                    }

                }


                int random = 10000;
                if (count == detectivesarr.size()) {
                    int feg = 0;
                }
                else {
                    System.out.println("Detectives have chosen a player to test.");
                    if (user.Isout()) {

                        random = randomperfectdet(N);
                        String tester = detectivesarr.get(0).Test(playersarr.get(random));

                        if (tester.equals("Mafia")) {
                            playersarr.get(random).setIsout(true);
                            healerandaction(N);
                            System.out.println(playersarr.get(random).getName() + " is a mafia.");
                            for (int i = 0; i < playersarr.size(); i++) {
                                if (playersarr.get(i).Isdead() && !playersarr.get(i).Isout()) {
                                    System.out.println(playersarr.get(i).getName() + "has died.");
                                    playersarr.get(i).setIsout(true);
                                }

                            }
                            System.out.println(playersarr.get(random).getName() + " has been voted out.");
                            continue;


                        }

                    }
                    else {
                        System.out.println("Choose a player to test:");
                        int q = choosetest();

                        String tester = detectivesarr.get(0).Test(playersarr.get(q - 1));

                        if (tester.equals("Mafia")) {
                            playersarr.get(q - 1).setIsout(true);
                            healerandaction(N);
                            System.out.println(playersarr.get(q - 1).getName() + " is a mafia.");
                            for (int i = 0; i < playersarr.size(); i++) {
                                if (playersarr.get(i).Isdead() && !playersarr.get(i).Isout()) {
                                    System.out.println(playersarr.get(i).getName() + " has died.");
                                    playersarr.get(i).setIsout(true);
                                }

                            }
                            System.out.println(playersarr.get(q - 1).getName() + " has been voted out.");
                            continue;


                        }
                        System.out.println(playersarr.get(q - 1).getName() + " is not a mafia.");
                    }
                }

                healerandaction(N);
                endofactions(user, N);


            }

        }


    }


    public void commoneround(Commoner user, int N){
        Scanner sc=new Scanner(System.in);
        int x=0;

        while (x < 1) {
            int numbermaf = 0;
            int numberelse = 0;


            for (int i = 0; i < playersarr.size(); i++) {
                if (playersarr.get(i).getStatus().equals("Mafia")) {
                    if (!playersarr.get(i).Isout()) {
                        numbermaf++;

                    }

                }
                else
                if (!playersarr.get(i).Isout()) {
                    numberelse++;
                }

            }
            if(numberelse<=numbermaf){
                System.out.println("Game Over");
                System.out.println("Mafias won.");
                displayplayers();
                break;


            }
            if(numbermaf==0){
                System.out.println("Game Over");
                System.out.println("Mafias lost.");
                displayplayers();
                break;


            }

            if (numberelse >= numbermaf) {


                int playersleft = sortplayers(playersarr);

                int ke = 0;
                Random rand = new Random();
                int rander = randomperfectmaf(N);
                mafiasarr.get(0).killbyUser(playersarr.get(rander), mafiasarr);
                System.out.println("Mafias have chosen a target.");



                int count = 0;
                for (int i = 0; i < detectivesarr.size(); i++) {
                    if (detectivesarr.get(i).Isout()) {
                        count++;
                    }

                }


                int random = 10000;
                System.out.println("Detectives have chosen a player to test.");
                if (count == detectivesarr.size()) {
                    int feg = 0;
                }
                else {

                    random = randomperfectdet(N);
                    String tester = detectivesarr.get(0).Test(playersarr.get(random));

                    if (tester.equals("Mafia")) {
                        playersarr.get(random).setIsout(true);
                        healerandaction(N);
                        System.out.println(playersarr.get(random).getName() + " is a mafia.");
                        for (int i = 0; i < playersarr.size(); i++) {
                            if (playersarr.get(i).Isdead() && !playersarr.get(i).Isout()) {
                                System.out.println(playersarr.get(i).getName() + " has died.");
                                playersarr.get(i).setIsout(true);
                            }

                        }
                        System.out.println(playersarr.get(random).getName() + " has been voted out.");
                        continue;


                    }
                }



                healerandaction(N);
                endofactions(user, N);


            }

        }


    }


    public void healerround(Healer user, int N){
        Scanner sc=new Scanner(System.in);
        int x=0;

        while (x < 1) {
            int numbermaf = 0;
            int numberelse = 0;


            for (int i = 0; i < playersarr.size(); i++) {
                if (playersarr.get(i).getStatus().equals("Mafia")) {
                    if (!playersarr.get(i).Isout()) {
                        numbermaf++;

                    }

                }
                else
                if (!playersarr.get(i).Isout()) {
                    numberelse++;
                }

            }
            if(numberelse<=numbermaf){
                System.out.println("Game Over");
                System.out.println("Mafias won.");
                displayplayers();
                break;


            }
            if(numbermaf==0){
                System.out.println("Game Over");
                System.out.println("Mafias lost.");
                displayplayers();
                break;


            }

            if (numberelse >= numbermaf) {


                int playersleft = sortplayers(playersarr);

                int ke = 0;
                Random rand = new Random();
                int rander = randomperfectmaf(N);
                mafiasarr.get(0).killbyUser(playersarr.get(rander), mafiasarr);
                System.out.println("Mafias have chosen a target.");



                int count = 0;
                for (int i = 0; i < detectivesarr.size(); i++) {
                    if (detectivesarr.get(i).Isout()) {
                        count++;
                    }

                }


                int random = 10000;
                System.out.println("Detectives have chosen a player to test.");
                if (count == detectivesarr.size()) {
                    int feg = 0;
                }
                else {
                    random = randomperfectdet(N);
                    String tester = detectivesarr.get(0).Test(playersarr.get(random));

                    if (tester.equals("Mafia")) {
                        playersarr.get(random).setIsout(true);
                        healerandaction(N);
                        System.out.println(playersarr.get(random).getName() + " is a mafia.");
                        for (int i = 0; i < playersarr.size(); i++) {
                            if (playersarr.get(i).Isdead() && !playersarr.get(i).Isout()) {
                                System.out.println(playersarr.get(i).getName() + " has died.");
                                playersarr.get(i).setIsout(true);
                            }

                        }
                        System.out.println(playersarr.get(random).getName() + " has been voted out.");
                        continue;


                    }
                }

                if(user.Isout()){
                    healerandaction(N);
                    endofactions(user, N);
                    continue;

                }

                healeruseraction(N);
                endofactions(user, N);


            }

        }


    }




    public void endofactions(Player user, int N){
        Scanner sc=new Scanner(System.in);
        int count=0;
        for(int i=0;i<playersarr.size();i++){
            if(playersarr.get(i).Isdead() && !playersarr.get(i).Isout()){
                System.out.println(playersarr.get(i).getName() + " has died.");
                playersarr.get(i).setIsout(true);
            }

        }
        if(user.Isout()){
            for(int i=0;i<playersarr.size();i++){
                if(playersarr.get(i).Isout()){
                    continue;
                }
                playersarr.get(i).voterandom(playersarr, N);

            }
            int indexToKicked=votecalculator();
            playersarr.get(indexToKicked).setIsout(true);
            System.out.println(playersarr.get(indexToKicked).getName()+" has been voted out.");
        }
        else {
            user.vote(playersarr);
            for(int i=0;i<playersarr.size();i++){
                if(playersarr.get(i).getId()==user.getId()){
                    continue;
                }
                else
                if(playersarr.get(i).Isout()){
                    continue;
                }
                playersarr.get(i).voterandom(playersarr, N);

            }
            int indexToKicked=votecalculator();
            playersarr.get(indexToKicked).setIsout(true);
            System.out.println(playersarr.get(indexToKicked).getName()+" has been voted out.");


        }
    }
    public int votecalculator(){
        int max=0;
        for(int i=0;i<playersarr.size();i++){
            if(!playersarr.get(i).Isout()) {
                if (playersarr.get(max).getVotes() < playersarr.get(i).getVotes()) {
                    max = i;
                }
            }

        }
        return max;

    }



    public void healerandaction(int N){
        int rand=randomperfectheal(N);
        healersarr.get(0).heal(playersarr.get(rand),healersarr);
        System.out.println("Healers have chosen a player to heal.");
        System.out.println("--End of actions--");


    }
    public void healeruseraction(int N){
        System.out.println("Choose a player to heal:");
        int q=chooseheal();
        healersarr.get(0).heal(playersarr.get(q-1),healersarr);
        System.out.println("Healers have chosen a player to heal.");
        System.out.println("--End of actions--");


    }


    public int sortplayers(ArrayList<? extends Player> playersarr){
        Collections.sort(playersarr,new PlayerOrderCalculator());
        int a=0;
        for(int i=0;i<playersarr.size();i++) {
            if (playersarr.get(i).Isdead() || playersarr.get(i).Isout()) {
                continue;
            }
            a++;
        }

        System.out.print(a+" players are remaining: ");
        for(int i=0;i<playersarr.size();i++){
            if(playersarr.get(i).Isout()){
                continue;
            }
            if(i==playersarr.size()-1){
                System.out.print(playersarr.get(i).getName());
                continue;
            }
            System.out.print(playersarr.get(i).getName()+", ");
        }
        System.out.print(" are alive.");
        System.out.println("");
        return a;
    }
    public void displayplayers(){
        for(int i=0;i<mafiasarr.size();i++){
            if(i==mafiasarr.size()-1){
                System.out.print(mafiasarr.get(i).getName());
                continue;
            }
            System.out.print(mafiasarr.get(i).getName()+", ");

        }
        System.out.println(" are mafia.");

        for(int i=0;i<detectivesarr.size();i++){
            if(i==detectivesarr.size()-1){
                System.out.print(detectivesarr.get(i).getName());
                continue;
            }
            System.out.print(detectivesarr.get(i).getName()+", ");

        }
        System.out.println(" are detectives.");

        for(int i=0;i<healersarr.size();i++){
            if(i==healersarr.size()-1){
                System.out.print(healersarr.get(i).getName());
                continue;
            }
            System.out.print(healersarr.get(i).getName()+", ");

        }
        System.out.println(" are healers.");

        for(int i=0;i<commonersarr.size();i++){
            if(i==commonersarr.size()-1){
                System.out.print(commonersarr.get(i).getName());
                continue;
            }
            System.out.print(commonersarr.get(i).getName()+", ");

        }
        System.out.println(" are commoners.");


    }

    public int choosetest(){
        Scanner sc=new Scanner(System.in);
        int q=sc.nextInt();
        while(playersarr.get(q-1).getStatus().equals("Detective") || playersarr.get(q-1).Isout()){
            if(playersarr.get(q-1).Isout()){
                System.out.println("Cannot test already voted out players.");
                q=sc.nextInt();
                continue;

            }
            System.out.println("Cannot test another detective.");
            q=sc.nextInt();
        }
        return q;
    }

    public int chooseheal(){
        Scanner sc=new Scanner(System.in);
        int q=sc.nextInt();
        while(playersarr.get(q-1).Isout()){

                System.out.println("Cannot heal already voted out players.");
                q=sc.nextInt();




        }
        return q;
    }




}
