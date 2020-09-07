package com.company;

import java.util.ArrayList;

public class Lab {
    int[] hor = new int[13];
    int[] ver = new int[13];

    ArrayList<Wall> wall = new ArrayList<>();

    /*public Lab(int[] hor, int[] ver) {
        this.hor = hor;
        this.ver = ver;
    }*/

    public void initiateGrid() {
        for(int i = 0; i<=12; i++){
            hor[i] = i;
            ver[i] = i;
        }
    }

    public void initiateWall(){
        for(int i = 0; i<=11; i++){wall.add(new Wall(0,i)); wall.add(new Wall(12,i));} //The sides
        for(int j = 0; j<=12; j++){wall.add(new Wall(j,0)); wall.add(new Wall(j,12));} //The bottom and top
        wall.remove()

        wall.add(new Wall(0,0));
        wall.add(new Wall(0,1));
        wall.add(new Wall(0,2));
        wall.add(new Wall(0,3));
        wall.add(new Wall(0,4));
        wall.add(new Wall(0,5));
        wall.add(new Wall(0,6));
        wall.add(new Wall(0,7));
        wall.add(new Wall(0,8));
        wall.add(new Wall(0,9));
        wall.add(new Wall(0,10));
        wall.add(new Wall(0,11));
        wall.add(new Wall(0,12));
    }
}
