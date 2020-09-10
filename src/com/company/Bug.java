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
        Boolean flagL = true;
        Boolean flagR = true;
        Boolean flagU = true;
        Boolean flagD = true;
        Wall left = new Wall(hPos-1, vPos);
        Wall right = new Wall(hPos+1, vPos);
        Wall up = new Wall(hPos, vPos+1);
        Wall down = new Wall(hPos, vPos-1);
        ArrayList<Wall> waysToGo = new ArrayList<>();
        for(Wall s:lab.wall){
            if(s == left){
                flagL = false;
            }
            if(s == right){
                flagR = false;
            }
            if(s == up){
                flagU = false;
            }
            if(s == down){
                flagD = false;
            }
        }
        if(flagL){
            waysToGo.add(left);
        }
        if(flagR){
            waysToGo.add(right);
        }
        if(flagU){
            waysToGo.add(up);
        }
        if(flagD){
            waysToGo.add(down);
        }
        return waysToGo;
    }
}
