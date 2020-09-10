package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab {
    int[] hor = new int[13];
    int[] ver = new int[13];

    ArrayList<Wall> wall = new ArrayList<>();

    public void initiateGrid() {
        for(int i = 0; i<=12; i++){
            hor[i] = i;
            ver[i] = i;
        }
    }

    public void initiateWall(int ind,int ud){
        for(int i = 0; i<=11; i++){ wall.add(new Wall(0,i)); wall.add(new Wall(12,i));} //The sides

        for(int j = 0; j<=12; j++){
            if (j== ind || j== ud) {continue;}
            else
            wall.add(new Wall(j,0)); wall.add(new Wall(j,12));} //The bottom and top

        Scanner sc = new Scanner( "lab.txt");
         while (sc.hasNextLine())
         {
             wall.add(new Wall(sc.nextInt(),sc.nextInt()));
         }
    }
}
