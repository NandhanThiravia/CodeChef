package com.nandhan.division3;

import java.util.Scanner;

/**
Sample Input:
---------------
5
1 5 31
4
1 10 3
23
2 5 7
20 36
2 5 10
19 2
3 3 300
1 1 1


Sample Output:
---------------
0
2
7
4
1
*/

public class DIVTHREE {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfTestCases = sc.nextInt();

        int N = 0; // Number of Setters
        int K = 0; // Problems per Contest required
        int D = 0; // Number of Days the contest would run
        for (int testCaseIndex = 0; testCaseIndex < numberOfTestCases; ++testCaseIndex) {
            N = sc.nextInt();
            K = sc.nextInt();
            D = sc.nextInt();

            int totalProblems = 0;
            for (int setterIndex = 0; setterIndex < N; ++setterIndex) {
                totalProblems += sc.nextInt();
            }
            int DInterim = 0;
            if (totalProblems >= K) {
                DInterim = totalProblems / K;
            }

            System.out.println(Math.min(D, DInterim));
        }
        sc.close();
    }

}
