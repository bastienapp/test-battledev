/*******
 * Read input from System.in
 * Use: System.out.println to ouput your result to STDOUT.
 * Use: System.err.println to ouput debugging information to STDERR.
 * ***/
package com.isograd.exercise;
import java.util.*;

public class IsoContest {
    public static void main( String[] argv ) throws Exception {
        String n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextLine();
        String line = sc.nextLine();

        doStuff(line, "", 0);
    }

    public static String doStuff(String line, String current, int score) {
        if ((!line.contains("o") && !line.contains("*"))) {
            return current;
        }

        int s = 0;
        int closest = line.length();
        int pos = line.indexOf("X");
        char search = line.contains("o") ? 'o' : '*';
        StringBuilder newLine = new StringBuilder(line);
        newLine.setCharAt(pos, '.');
        line = newLine.toString();
        while (line.substring(s).indexOf(search) != -1) {
            int n = line.substring(s).indexOf(search);
            if (Math.abs(pos - n) < closest) {
                closest = n;
            }
            s = n;
        }
        String result = "";
        if (closest < pos) {
            // go left
            current += "<";
            int newPos = pos - 1;
            int newScore = score;
            if (line.charAt(newPos) == 'o') {
                newScore++;
                current += "x";
            } else if (line.charAt(newPos) == '*') {
                newScore *= 2;
                current += "x";
            }
            newLine = new StringBuilder(line);
            newLine.setCharAt(newPos, 'X');
            result = doStuff(newLine.toString(), current, newScore);
        } else {
            // go right
            current += ">";
            int newPos = pos + 1;
            int newScore = score;
            if (line.charAt(newPos) == 'o') {
                newScore++;
                current += "x";
            } else if (line.charAt(newPos) == '*') {
                newScore *= 2;
                current += "x";
            }
            newLine = new StringBuilder(line);
            newLine.setCharAt(newPos, 'X');
            result = doStuff(newLine.toString(), current, newScore);
        }
        return result;
    }
}