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
        int n = sc.nextInt();

        char[][] field = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            field[i] = line.toCharArray();
        }

        int cultivable = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (field[x][y] == 'X') {
                    for (int i = Math.max(x - 1, 0); i <= Math.min(x + 1, n - 1); i++) {
                        for (int j = Math.max(y - 1, 0); j <= Math.min(y + 1, n - 1); j++) {
                            if (field[i][j] == '.') {
                                field[i][j] = '#';
                                cultivable++;
                            }
                        }
                    }
                }
            }
        }
        System.out.print(cultivable);
    }
}