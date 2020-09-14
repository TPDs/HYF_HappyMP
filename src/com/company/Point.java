package com.company;

import java.util.Objects;

public class Point {
    private int h, v;

    public Point(int h, int v) {
        this.h = h;
        this.v = v;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return h == point.h &&
                v == point.v;
    }

    @Override
    public int hashCode() {
        return Objects.hash(h, v);
    }
}
