/*******
 * Read input from System.in
 * Use: System.out.println to ouput your result to STDOUT.
 * Use: System.err.println to ouput debugging information to STDERR.
 * ***/
package com.isograd.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IsoContest {
    public static void main(String[] argv) throws Exception {
        Scanner sc = new Scanner(System.in);
        int nbstudents = sc.nextInt();
        ArrayList<Integer> h1 = new ArrayList<>();
        ArrayList<Integer> h2 = new ArrayList<>();
        for (int i = 0; i < nbstudents; i++) {
            h1.add(sc.nextInt());
            h2.add(sc.nextInt());
        }
        ArrayList<Integer> sch = new ArrayList<>();
        int result = schedule(h1, h2, sch);
        System.out.print(result);
    }

    public static int schedule(ArrayList<Integer> h1, ArrayList<Integer> h2, ArrayList<Integer> sch) {

        if (h1.size() == 0 && h2.size() == 0) {
            return sch.size();
        }

        int maxStudents = 0;
        for (int i = 0; i < h1.size(); i++) {
            int h = h1.get(i);
            if (!overlap(h, sch)) {
                sch.add(h);
            }
            ArrayList<Integer> ch1 = cloneH(h1);
            ArrayList<Integer> ch2 = cloneH(h2);
            ch1.remove(i);
            ch2.remove(i);
            maxStudents = Math.max(maxStudents, schedule(ch1, ch2, sch));
        }
        for (int i = 0; i < h2.size(); i++) {
            int h = h2.get(i);
            if (!overlap(h, sch)) {
                sch.add(h);
            }
            ArrayList<Integer> ch1 = cloneH(h1);
            ArrayList<Integer> ch2 = cloneH(h2);
            ch1.remove(i);
            ch2.remove(i);
            maxStudents = Math.max(maxStudents, schedule(ch1, ch2, sch));
        }
        return maxStudents;
    }

    public static boolean overlap(int h, ArrayList<Integer> sch) {
        int hMin = h - 60;
        int hMax = h + 60;
        for (int s : sch) {
            if (s >= hMin && s <= hMax) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Integer> cloneH(List<Integer> list) {
        ArrayList<Integer> clone = new ArrayList<>(list.size());
        clone.addAll(list);
        return clone;
    }
}