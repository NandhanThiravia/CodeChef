package com.nandhan.division3;

import java.util.ArrayList;
import java.util.Scanner;

/*
Sample Input:
---------------
2
5 5 4 4
5 2 3 1

Sample Output:
---------------
5 5
3 5
*/

public class BILLRD {
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int numberOfTestCases = sc.nextInt();
        for (int testCaseIndex = 0; testCaseIndex < numberOfTestCases; ++testCaseIndex) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            try {
                Pair p = findKthPoint(N, K, x, y);
                System.out.println(p.x + " " + p.y);
            } catch (Exception e) {
                System.err.println("-1 -1");
            }
        }
        sc.close();
    }

    private static Pair findKthPoint(int N, int K, int x, int y) {
        Pair p = null;
        if (x == y) {
            p = new Pair(N, N);
        } else {
            ArrayList<Pair> points = new ArrayList<Pair>(4);
            if (x > y) {
                if (x != N) {
                    y = y + (N - x);
                    x = N;
                }
                points.add(0, new Pair(x, y));

                int holder = x;
                x = y;
                y = holder;
                points.add(1, new Pair(x, y));

                y = y - x;
                x = 0;
                points.add(2, new Pair(x, y));

                holder = x;
                x = y;
                y = holder;
                points.add(3, new Pair(x, y));

            } else if (y > x) {
                if (y != N) {
                    x = x + (N - y);
                    y = N;
                }
                points.add(0, new Pair(x, y));

                int holder = x;
                x = y;
                y = holder;
                points.add(1, new Pair(x, y));

                x = x - y;
                y = 0;
                points.add(2, new Pair(x, y));

                holder = x;
                x = y;
                y = holder;
                points.add(3, new Pair(x, y));
            }

            K = (K - 1) % 4;
            p = points.get(K);
        }

        return p;
    }

}
