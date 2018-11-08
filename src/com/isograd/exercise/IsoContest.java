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
        ArrayList<Integer> agenda = new ArrayList<>();
        int result = schedule(h1, h2, agenda);
        System.out.print(result);
    }

    public static int schedule(ArrayList<Integer> h1, ArrayList<Integer> h2, ArrayList<Integer> agenda) {

        if (h1.size() == 0 || h2.size() == 0) {
            return agenda.size();
        }

        int maxStudents = 0;
        for (int i = 0; i < h1.size(); i++) {
            int h = h1.get(i);
            if (!overlap(h, agenda)) {
                agenda.add(h);
            }
            ArrayList<Integer> ch1 = clone(h1);
            ArrayList<Integer> ch2 = clone(h2);
            ch1.remove(i);
            ch2.remove(i);
            maxStudents = Math.max(maxStudents, schedule(ch1, ch2, agenda));
        }
        for (int i = 0; i < h2.size(); i++) {
            int h = h2.get(i);
            if (!overlap(h, agenda)) {
                agenda.add(h);
            }
            ArrayList<Integer> ch1 = clone(h1);
            ArrayList<Integer> ch2 = clone(h2);
            ch1.remove(i);
            ch2.remove(i);
            maxStudents = Math.max(maxStudents, schedule(ch1, ch2, agenda));
        }
        return maxStudents;
    }

    public static boolean overlap(int h, ArrayList<Integer> agenda) {
        int hMin = h - 60;
        int hMax = h + 60;
        for (int slot : agenda) {
            if (slot >= hMin && slot <= hMax) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Integer> clone(List<Integer> list) {
        ArrayList<Integer> clone = new ArrayList<>();
        clone.addAll(list);
        return clone;
    }
}