package com.company;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {



    public static void main(String[] args) throws InterruptedException {
        Lab start = new Lab();
        Bug bug = new Bug();
        bug.setHorizontal(3);
        bug.setVertical(1);
        bug.start(bug);
        String maze = null;
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_RESET = "\u001B[0m";

        System.out.println( ANSI_GREEN +" _    _                               ____                \n" +
                "| |  | |                             |  _ \\               \n" +
                "| |__| |  __ _  _ __   _ __   _   _  | |_) | _   _   __ _ \n" +
                "|  __  | / _` || '_ \\ | '_ \\ | | | | |  _ < | | | | / _` |\n" +
                "| |  | || (_| || |_) || |_) || |_| | | |_) || |_| || (_| |\n" +
                "|_|  |_| \\__,_|| .__/ | .__/  \\__, | |____/  \\__,_| \\__, |\n" +
                "               | |    | |      __/ |                 __/ |\n" +
                "               |_|    |_|     |___/                 |___/ \n");

        System.out.println(ANSI_YELLOW +"By Michael Petersen" + "," +  "Christian Haugaard og Mikkel Strand \n\n "+ANSI_RESET);



        System.out.println("Pick a maze:");
        System.out.println("Base maze from the assignment: 1");
        System.out.println("Michael's maze: 2");
        System.out.println("Christian's maze: 3");
        System.out.println("Mikkel's maze: 4");
        Scanner sc = new Scanner(System.in);
        int pick = sc.nextInt();
        switch (pick){
            case 1:
                maze = "LabData";
                break;
            case 2:
                maze = "labMP";
                break;
            case 3:
                maze = "lab3";
                break;
            case 4:
                maze = "labStrand";
                break;
            default:
                maze = "LabData";
                break;
        }
        start.initiateWall(3, 5, maze);
        Printout print = new Printout();
        int y = bug.getHorizontal();
        int x = bug.getVertical();

        System.out.println("1: For Manuel control");
        System.out.println("2: For semi-auto control");
        System.out.println("3: For full-auto bug AI");
        System.out.println("4: For timed full-auto");
        pick = sc.nextInt();
        print.printMaze(start.wallList, bug);
        switch (pick){

            case 1:
                manuelControl(sc,bug,print,start);
                break;
            case 2:
                autoControl(bug, start, print, sc);
                break;
            case 3:
                fullAutoBug(bug, start, print, sc);
                break;
            case 4:
                timedAutoBug(bug, start, print, sc);
                break;
        }




    }

    public static void fullAutoBug(Bug bug, Lab start, Printout print, Scanner sc) throws InterruptedException {
        Point winner = new Point(11,5);
        boolean flag = true;
        int steps = 0;
        while (flag){
            int y = bug.getHorizontal();
            int x = bug.getVertical();
            System.out.println("\n\n");
            bug.wayCheck(start.wallList, bug);
            print.printMaze(start.wallList, bug);
            if(bug.getHorizontal() == winner.getY() && bug.getVertical() == winner.getX()){
                System.out.println();
                System.out.println("The Maze was completed. Steps: " + steps);
                System.out.println();
                flag = false;
            } else {
                System.out.println("\n\n");
                steps++;
            }
            TimeUnit.MILLISECONDS.sleep(750);
        }
        String lock = sc.next();
    }

    public static void timedAutoBug(Bug bug, Lab start, Printout print, Scanner sc) throws InterruptedException {
        Point winner = new Point(11,5);
        boolean flag = true;
        int steps = 0;
        double timer = System.currentTimeMillis();
        while (flag){
            int y = bug.getHorizontal();
            int x = bug.getVertical();
            System.out.println("\n\n");
            bug.wayCheck(start.wallList, bug);
            print.printMaze(start.wallList, bug);
            if(bug.getHorizontal() == winner.getY() && bug.getVertical() == winner.getX()){
                System.out.println();
                double elapsedTime = System.currentTimeMillis() - timer;
                double elapsedTimeSec = elapsedTime/1000;
                System.out.println("The Maze was completed.");
                System.out.println("Time: " + elapsedTimeSec + " sec / " + elapsedTime + " ms");
                System.out.println();
                flag = false;
            } else {
                System.out.println("\n\n");
                steps++;
            }

        }
        String lock = sc.next();
    }

    public static void autoControl(Bug bug,Lab start,Printout print, Scanner sc){
        Point winner = new Point(9, 5);

        while (sc.hasNext()) {
            int y = bug.getHorizontal();
            int x = bug.getVertical();
            String key = sc.nextLine();
            System.out.println(bug.getHorizontal() + " " + bug.getVertical());
            if (bug.getHorizontal() == winner.getY() && bug.getVertical() == winner.getX()) {
                System.out.println("WINNNNNERRR!!!!!!");
            }

            switch (key) {
                case "a" :
                    bug.wayCheck(start.wallList, bug);
                    System.out.println(bug.mapmap.keySet() + " Fra main call" );

                    System.out.println(bug.mapmap.get(0) + " Fra main2 call" );
                    print.printMaze(start.wallList, bug);
                    break;

                case "q":
                    System.out.println("stop");
                    break;
            }

        }

    }
        public static void manuelControl(Scanner sc,Bug bug,Printout print,Lab start) {
            Point winner = new Point(9, 5);

            while (sc.hasNext()) {
                int y = bug.getHorizontal();
                int x = bug.getVertical();
                String key = sc.nextLine();
                System.out.println(bug.getVertical()+ " "+ bug.getHorizontal());
                if(bug.getHorizontal()==winner.getY()&& bug.getVertical()== winner.getX()) {
                    System.out.println("WINNNNNERRR!!!!!!");
                }
                switch (key) {

                    case "q":
                        return;

                    case "w":

                        bug.setHorizontal(y);
                        bug.setVertical(x+2);
                        System.out.println("\n\n\n\n");
                        print.printMaze(start.wallList, bug);

                        break;
                    case "s":
                        bug.setHorizontal(y);
                        bug.setVertical(x-2);
                        System.out.println("\n\n\n\n");
                        print.printMaze(start.wallList, bug);

                        break;
                    case "a":
                        bug.setVertical(x);
                        bug.setHorizontal(y-2);
                        System.out.println("\n\n\n\n");
                        print.printMaze(start.wallList, bug);

                        break;
                    case "d":
                        bug.setVertical(x);
                        bug.setHorizontal(y+2);
                        System.out.println("\n\n\n\n");
                        print.printMaze(start.wallList, bug);

                        break;

                }
            }




    }
}