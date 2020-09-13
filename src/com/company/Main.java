package com.company;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Lab start = new Lab();
        Bug bug = new Bug();
        bug.setHorizontal(3);
        bug.setVertical(1);
        bug.start(bug);
        start.initiateWall(3, 5);
        Printout print = new Printout();
        int y = bug.getHorizontal();
        int x = bug.getVertical();


        System.out.println("1: For Manuel control");
        System.out.println("2: For auto control");
        Scanner sc = new Scanner(System.in);
        int pick = sc.nextInt();
        print.printMaze(start.wallList, bug);
        switch (pick){

            case 1:
                manuelControl(sc,bug,print,start);
            case 2:
               // bug.wayCheck(start.wallList, bug);
              //  print.printMaze(start.wallList, bug);
                autoControl(bug, start, print, sc);
        }




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