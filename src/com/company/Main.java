package com.company;

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
        print.printMaze(start.wallList, bug);
        int y = bug.getHorizontal();
        int x = bug.getVertical();
        boolean test = true;
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();

        while (test) {

            switch (key) {

                case 1:
                    bug.setHorizontal(y + 2);
                    bug.setVertical(x);
                    System.out.println(bug.getVertical() + " " + bug.getHorizontal());
                    print.printMaze(start.wallList, bug);
                    key = 0;
                    break;
                case 2:
                    bug.setHorizontal(y - 2);
                    bug.setVertical(x);
                    System.out.println(bug.getVertical() + " " + bug.getHorizontal());
                    print.printMaze(start.wallList, bug);
                    key = 0;
                    break;
                case 3:
                    bug.setVertical(x - 2);
                    bug.setHorizontal(y);
                    System.out.println(bug.getVertical() + " " + bug.getHorizontal());
                    print.printMaze(start.wallList, bug);
                    key = 0;
                    break;
                case 4:
                    bug.setVertical(x + 2);
                    bug.setHorizontal(y);
                    System.out.println(bug.getVertical() + " " + bug.getHorizontal());
                    print.printMaze(start.wallList, bug);
                    key = 0;
                    break;

            }
        }

    }
}