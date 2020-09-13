package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Bug {
    private int horizontal, vertical;
    HashMap<Point, Integer> mapmap = new HashMap<>();

    public Bug(int horizontal, int vertical) {
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

    public Bug start(Bug bug) {
        if (bug == null) {
            bug = new Bug();
        }
        return bug;
    }

    public void wayCheck(ArrayList<Point> wallList, Bug bug) {

        boolean flagL = true;
        boolean flagR = true;
        boolean flagU = true;
        boolean flagD = true;
        Point left = new Point(bug.getHorizontal() - 1, bug.getVertical());
        Point right = new Point(bug.getHorizontal() + 1, bug.getVertical());
        Point up = new Point(bug.getHorizontal(), bug.getVertical() + 1);
        Point down = new Point(bug.getHorizontal(), bug.getVertical() - 1);
        ArrayList<Point> waysToGo = new ArrayList<>();

        for (Point s : wallList) {
            if (s.getH() == left.getH() && s.getV() == left.getV()) {
                flagL = false;
            }
            if (s.getH() == right.getH() && s.getV() == right.getV()) {
                flagR = false;
            }
            if (s.getH() == up.getH() && s.getV() == up.getV()) {
                flagU = false;
            }
            if (s.getH() == down.getH() && s.getV() == down.getV()) {
                flagD = false;
            }
        }
        if (flagL) {
            left.setH(left.getH() - 1);
            waysToGo.add(left);
        }
        if (flagR) {
            right.setH(right.getH() + 1);
            waysToGo.add(right);
        }
        if (flagU) {
            up.setV(up.getV() + 1);
            waysToGo.add(up);
        }
        if (flagD) {
            down.setV(down.getV() - 1);
            waysToGo.add(down);
        }
        System.out.println(waysToGo.size());

        move(waysToGo, bug);
    }

    public void move(ArrayList<Point> position, Bug bug) {

        for (int i=0; i < position.size();i++) {
            boolean addFlag=false;
            int addInt;
           if (mapmap.containsKey(position.get(i))) {
               continue;
           }
            else {
                addFlag = true;
                addInt = i;
               if (addFlag){ mapmap.put(position.get(addInt),0 );}
           }


        }


        switch (position.size()) {
            case 1:
                move1(position, bug);
                break;
            case 2:
                move2(position, bug);
                break;
            case 3:
                move3(position, bug);
                break;
        }
    }

    public Bug move1(ArrayList<Point> position, Bug bug) {
        changePosition(bug);
        bug.setVertical(position.get(0).getV());
        bug.setHorizontal(position.get(0).getH());

        return bug;
    }

    public Bug move2(ArrayList<Point> position, Bug bug) {
        int move1 = 0;
        int move2 = 0;
        for (Point s : mapmap.keySet()) {
            if (s == position.get(0)) {
                move1 = mapmap.get(s);
                System.out.println(move1 + "Move 1");
            }
            if (s == position.get(1)) {
                move2 = mapmap.get(s);
                System.out.println(move2+ "Move 2");
            }
        }
        if (move1 <= move2) {
            changePosition(bug);
            bug.setVertical(position.get(0).getV());
            bug.setHorizontal(position.get(0).getH());

            return bug;
        } else {
            changePosition(bug);
            bug.setVertical(position.get(1).getV());
            bug.setHorizontal(position.get(1).getH());

            return bug;
        }
    }

    public Bug move3(ArrayList<Point> position, Bug bug) {
        int move1 = 0;
        int move2 = 0;
        int move3 = 0;
        for (Point s : mapmap.keySet()) {
            if (s == position.get(0)) {
                move1 = mapmap.get(s);


            }
            if (s == position.get(1)) {
                move2 = mapmap.get(s);

            }
            if (s == position.get(3)) {
                move3 = mapmap.get(s);

            }
        }

        if (move1 <= move2 && move1 <= move3) {
            changePosition(bug);
            bug.setVertical(position.get(0).getV());
            bug.setHorizontal(position.get(0).getH());

            return bug;
        } else if (move2 <= move3) {
            changePosition(bug);
            bug.setVertical(position.get(1).getV());
            bug.setHorizontal(position.get(1).getH());
            return bug;
        } else {
            changePosition(bug);
            bug.setVertical(position.get(2).getV());
            bug.setHorizontal(position.get(2).getH());

            return bug;
        }

    }

    public void changePosition(Bug bug) {
        Point temp = new Point(bug.getHorizontal(), bug.getVertical());
        System.out.println(mapmap.size());



        mapmap.merge(temp, 1, Integer::sum);


    }
}
