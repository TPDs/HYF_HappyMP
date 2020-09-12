package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Bug {
    private Lab lab;

    int horizontal, vertical;
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

    public void wayCheck(Bug bug) {
        boolean flagL = true;
        boolean flagR = true;
        boolean flagU = true;
        boolean flagD = true;
        Point left = new Point(bug.getHorizontal() - 1, bug.getVertical());
        Point right = new Point(bug.getHorizontal() + 1, bug.getVertical());
        Point up = new Point(bug.getHorizontal(), bug.getVertical() + 1);
        Point down = new Point(bug.getHorizontal(), bug.getVertical() - 1);
        ArrayList<Point> waysToGo = new ArrayList<>();
        for (Point s : lab.wallList) {
            if (s == left) {
                flagL = false;
            }
            if (s == right) {
                flagR = false;
            }
            if (s == up) {
                flagU = false;
            }
            if (s == down) {
                flagD = false;
            }
        }
        if (flagL) {
            waysToGo.add(left);
        }
        if (flagR) {
            waysToGo.add(right);
        }
        if (flagU) {
            waysToGo.add(up);
        }
        if (flagD) {
            waysToGo.add(down);
        }
        move(waysToGo,bug);
    }

    public Bug move(ArrayList<Point> position, Bug bug) {
        for (int i = 0; i < position.size(); i++) {
            if (!mapmap.containsKey(position.get(i))) {
                mapmap.put(position.get(i), 0);
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

        Point temp = new Point(bug.getHorizontal(), bug.getVertical());
        mapmap.merge(temp, 1, Integer::sum);
        return bug;
    }

    public Bug move1(ArrayList<Point> position, Bug bug) {
        bug.setVertical(position.get(0).getV());
        bug.setHorizontal(position.get(0).getH());
        changePosition(bug);
        return bug;
    }

    public Bug move2(ArrayList<Point> position, Bug bug) {
        int move1 = 0;
        int move2 = 0;
        for (Point s : mapmap.keySet()) {
            if (s == position.get(0)) {
                move1 = mapmap.get(s);
            }
            if (s == position.get(1)) {
                move2 = mapmap.get(s);
            }
        }
        if (move1 < move2) {
            bug.setVertical(position.get(0).getV());
            bug.setHorizontal(position.get(0).getH());
            changePosition(bug);
            return bug;
        } else {
            bug.setVertical(position.get(1).getV());
            bug.setHorizontal(position.get(1).getH());
            changePosition(bug);
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
            bug.setVertical(position.get(0).getV());
            bug.setHorizontal(position.get(0).getH());
            changePosition(bug);
            return bug;
        } else if (move2 <= move3) {
            bug.setVertical(position.get(1).getV());
            bug.setHorizontal(position.get(1).getH());
            changePosition(bug);
            return bug;
        } else {
            bug.setVertical(position.get(2).getV());
            bug.setHorizontal(position.get(2).getH());
            changePosition(bug);
            return bug;
        }

    }

    public void changePosition(Bug bug){
    Point temp = new Point(bug.getHorizontal(), bug.getVertical());
        mapmap.merge(temp, 1, Integer::sum); }
}
