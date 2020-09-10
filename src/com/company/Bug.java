package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bug {
    private Lab lab;

    int horizontal, vertical;
    HashMap<Point, Integer> mapmap = new HashMap<>();

    public Bug (int horizontal, int vertical){
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    public Bug() {
    }

    public Bug start(Bug bug){
        if(bug == null){
            bug = new Bug();
        }
        return bug;
    }

    //check for væg, hvor mange veje kan gås
    //hvis 1 vej, gå vej
    //hvis 2 veje,
    public ArrayList wayCheck(int hPos, int vPos){
        Wall temp = new Wall(hPos, vPos);
        ArrayList<Bug> waysToGo = new ArrayList<>();
        for(Wall s:lab.wall){
            if(s == temp){
            } else {

            }
        }
    }
}
