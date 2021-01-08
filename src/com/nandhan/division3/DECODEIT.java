package com.nandhan.division3;

import java.util.Scanner;

/*
Sample Input:
--------------
3
4
0000
8
00001111
4
1001

Sample Output:
--------------
a
ap
j
*/

public class DECODEIT {
    private static final char[] LETTERS = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p' };
    private static final int SIZE = 16;

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int numberOfTestCases = sc.nextInt();
        for (int testCaseIndex = 0; testCaseIndex < numberOfTestCases; ++testCaseIndex) {
            int lengthOfString = sc.nextInt();
            String encodedString = sc.next();
            String decodedString = decodeString(encodedString, lengthOfString);
            System.out.println(decodedString);
        }
        sc.close();
    }

    private static String decodeString(String encodedString, int lengthOfString) {
        StringBuffer decodedString = new StringBuffer();

        int iteration = lengthOfString / 4;
        for (int iterationIndex = 0; iterationIndex < iteration; ++iterationIndex) {
            int factor = 8;
            int start = 1;
            int end = SIZE;
            int letterIndex = 0;
            for (int index = 0; index < 4; ++index) {
                letterIndex = (iterationIndex * 4) + index;
                if (encodedString.charAt(letterIndex) == '0') {
                    end = end - factor;
                } else {
                    start = start + factor;
                }
                factor = factor / 2;
            }
            if (start == end) {
                decodedString.append(LETTERS[start - 1]);
            } else {
                System.err.println("This shouldn't have happened. start: " + start + " end: " + end + " factor: " + factor);
            }
        }

        return decodedString.toString();
    }
}
