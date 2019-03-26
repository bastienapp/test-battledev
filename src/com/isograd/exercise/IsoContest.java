/*******
 * Read input from System.in
 * Use: System.out.println to ouput your result to STDOUT.
 * Use: System.err.println to ouput debugging information to STDERR.
 * ***/
package com.isograd.exercise;
import java.util.*;

public class IsoContest {
    public static void main( String[] argv ) throws Exception {
        int n;
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        n = Integer.parseInt(line);
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            line = sc.nextLine();
            grid[i] = line.toCharArray();
        }
        String result = "";
        int direction = 0;
        for (int i = 0; i < n; i++) {
            if (direction == 0) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 'o') {
                        result += 'x';
                        grid[i][j] = '.';
                    }
                    if (j + 1 < n) {
                        result += ">";
                    }
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    if (grid[i][j] == 'o') {
                        result += 'x';
                        grid[i][j] = '.';
                    }
                    if (j - 1 >= 0) {
                        result += "<";
                    }
                }
            }
            direction = direction == 0 ? 1 : 0;
            if (i + 1 < n) {
                result += "v";
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (direction == 0) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '*') {
                        result += 'x';
                    }
                    if (j + 1 < n) {
                        result += ">";
                    }
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    if (grid[i][j] == '*') {
                        result += 'x';
                    }
                    if (j - 1 >= 0) {
                        result += "<";
                    }
                }
            }
            direction = direction == 0 ? 1 : 0;
            if (i - 1 >= 0) {
                result += "^";
            }
        }
        System.out.println(result);
    }
}