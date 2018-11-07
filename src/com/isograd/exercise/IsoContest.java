/*******
 * Read input from System.in
 * Use: System.out.println to ouput your result to STDOUT.
 * Use: System.err.println to ouput debugging information to STDERR.
 * ***/
package com.isograd.exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class IsoContest {
    public static void main(String[] argv) throws Exception {

        Scanner sc = new Scanner(System.in);
        int myScores[] = new int[5];
        for (int i = 0; i < 5; i++) {
            myScores[i] = sc.nextInt();
        }
        int nbFriends = sc.nextInt();
        int nbBesties = sc.nextInt();
        TreeMap<Integer, Integer> scores = new TreeMap<>();
        for (int i = 0; i < nbFriends; i++) {
            int friendScores[] = new int[5];
            for (int j = 0; j < 5; j++) {
                friendScores[j] = sc.nextInt();
            }

            int distance = 0;
            for (int j = 0; j < 5; j++) {
                distance += Math.abs(myScores[j] - friendScores[j]);
            }

            int score = sc.nextInt();
            scores.put(distance, score);
        }
        int total = 0;
        for (int i = 0; i < nbBesties; i++) {
            Map.Entry<Integer, Integer> score = scores.firstEntry();
            total += score.getValue();
            scores.remove(score.getKey());
        }
        System.out.print(total / nbBesties);
    }
}