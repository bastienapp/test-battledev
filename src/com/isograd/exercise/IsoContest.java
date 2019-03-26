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
        SortedSet<String> result = new TreeSet<>();
        while(sc.hasNextLine()) {
            String word = sc.nextLine();
            SortedSet<String> subWords = allStuff(word, "");
            if (result.size() == 0) {
                result = subWords;
            } else {
                Iterator<String> it = result.iterator();
                SortedSet<String> newResult = new TreeSet<>();
                for (String c : result) {
                    if (subWords.contains(c)) {
                        newResult.add(c);
                    }
                }
                result = newResult;
            }
        }
        ArrayList<String> trueResult = new ArrayList<>(result);
        Collections.sort(trueResult, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return (o1.length() > o2.length() ? -1 : 1);
            }
        });
        System.out.print(trueResult.size() > 0 ? trueResult.get(0) : "KO");
    }

    public static SortedSet<String> allStuff(String word, String current) {
        SortedSet<String> result = new TreeSet<>();
        if (word.length() == 0) {
            if (current.length() > 0) {
                result.add(current);
            }
        } else {
            String next = current + word.charAt(0);
            word = word.substring(1);

            result.addAll(allStuff(word, current));
            result.addAll(allStuff(word, next));
        }

        return result;
    }
}