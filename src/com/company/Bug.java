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

    public int getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(int horizontal) {
        this.horizontal = horizontal;
    }

    public int getVertical() {
        return vertical;
    }

    public void setVertical(int vertical) {
        this.vertical = vertical;
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
    public ArrayList wayCheck(Bug bug){
        boolean flagL = true;
        boolean flagR = true;
        boolean flagU = true;
        boolean flagD = true;
        Point left = new Point(bug.getHorizontal()-1, bug.getVertical());
        Point right = new Point(bug.getHorizontal()+1, bug.getVertical());
        Point up = new Point(bug.getHorizontal(), bug.getVertical()+1);
        Point down = new Point(bug.getHorizontal(), bug.getVertical()-1);
        ArrayList<Point> waysToGo = new ArrayList<>();
        for(Point s:lab.wallList){
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

    public Bug move(ArrayList<Point> position, Bug bug){
       for(int i = 0; i< position.size(); i++){
           if(!mapmap.containsKey(position.get(i))){
               mapmap.put(position.get(i), 0);
           }
       }

        switch (position.size()){
            case 1:
                mapmap.get(position.get(0)).



                break;
            case 2:

                break;
            case 3:

                break;
        }

       Point temp = new Point(bug.getHorizontal(), bug.getVertical());
       mapmap.merge(temp,1,Integer::sum);
       bug.setHorizontal();
       bug.setVertical();
       return bug;
    }
}
