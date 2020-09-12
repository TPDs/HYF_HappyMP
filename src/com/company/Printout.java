package com.company;

import java.util.ArrayList;

public class Printout{
      public void printMaze (ArrayList<Point> wallList, Bug bug){
          System.out.println(wallList.get(28).getH());
        boolean flag;
        for(int i = 12; i >= 0; i--){
            if(i % 2 == 0) {
                for (int j = 1; j < 12; j = j + 2) {
                    System.out.print("+");
                    Point temp = new Point(j, i);
                    flag = false;
                    for(Point s: wallList){
                        if (s.equals(temp)) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        System.out.print("---");
                    } else {
                        System.out.print("   ");
                    }
                }
                System.out.println("+");
            } else {
                for (int k = 0; k < 12; k = k + 2) {
                    Point temp1 = new Point(k, i);
                    flag = false;
                    for(Point s : wallList){
                        if (s.equals(temp1)) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        System.out.print("|");
                    } else {
                        System.out.print(" ");
                    }
                    Point temp2 = new Point(k + 1, i);
                    Point temp3 = new Point(bug.getHorizontal(), bug.getVertical());
                    if (temp2 == temp3) {
                        System.out.print(" X ");
                    } else {
                        System.out.print("   ");
                    }
                }
                System.out.println("|");
            }
        }

    }
}
