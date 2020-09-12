package com.company;

public class Main {

    public static void main(String[] args) {

        Lab start = new  Lab();
        Bug bug = new Bug();

        bug.setHorizontal(3);
        bug.setVertical(1);

        bug.start(bug);
        start.initiateWall(3,5);
        Printout print = new Printout();
        print.printMaze(start.wallList,bug);


    }
}
