package com.company;

public class Main {

    public static void main(String[] args) {

        Lab start = new  Lab();
        Bug bug = new Bug();

        bug.setHorizontal(3);
        bug.setVertical(5);

        bug.start(bug);
        start.initiateGrid();
        start.initiateWall(3,5);
        System.out.println("test");
        System.out.println(start.wallList.size());
        Printout print = new Printout();
        print.printMaze(start.wallList,bug);


    }
}
