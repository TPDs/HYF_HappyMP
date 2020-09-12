package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab {
    int[] hor = new int[13];
    int[] ver = new int[13];

    ArrayList<Point> wallList = new ArrayList<>();

    public void initiateGrid() {
        for (int i = 0; i <= 12; i++) {
            hor[i] = i;
            ver[i] = i;
        }
    }

    public void initiateWall(int ind, int ud) {
        for (int i = 0; i <= 11; i++) {
            wallList.add(new Point(0, i));
            wallList.add(new Point(12, i));
        } //The sides

        for (int j = 0; j <= 12; j++) {
            if (j == ind || j == ud) {
                continue;
            } else
                wallList.add(new Point(j, 0));
            wallList.add(new Point(j, 12));
        } //The bottom and top
        try {
            File file = new File("src\\labData.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                wallList.add(new Point(sc.nextInt(), sc.nextInt()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(wallList.get(53).getH() +" " + wallList.get(53).getV());
    }
}