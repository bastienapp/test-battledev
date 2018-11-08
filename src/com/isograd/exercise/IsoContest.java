/*******
 * Read input from System.in
 * Use: System.out.println to ouput your result to STDOUT.
 * Use: System.err.println to ouput debugging information to STDERR.
 * ***/
package com.isograd.exercise;

import java.util.Scanner;

public class IsoContest {
    public static void main(String[] argv) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[] crepes = new int[6];
        for (int i = 0; i < 6; i++) {
            crepes[i] = sc.nextInt();
        }

        int minRound = spatula(0, crepes, 0);
        System.out.print(minRound);
    }

    private static int spatula(int position, int[] crepes, int round) {
        if (isSorted(crepes) || round > 7) {
            return Math.max(round - 1, 0);
        }
        crepes = turn(position, crepes);
        int minRound = 7;
        for (int i = 0; i < 6; i++) {
            int currentRound = spatula(i, crepes, round + 1);
            minRound = Math.min(currentRound, minRound);
        }
        return minRound;
    }

    private static int[] turn(int position, int[] crepes) {
        int[] returned = new int[6];
        for (int i = position, j = 0; i >= 0; i--, j++) {
            returned[j] = crepes[i];
        }
        for (int i = position + 1; i < crepes.length; i++) {
            returned[i] = crepes[i];
        }
        return returned;
    }

    private static boolean isSorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }
}