package com.nandhan.division3;

import java.util.Arrays;
import java.util.Scanner;

/*
Example Input
--------------
2
2 3
2 2
5 5 5
4 3
1 3 2 4
6 7 8


Example Output
----------------
2
1
*/
public class FAIRELCT {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int numberOfTestCases = sc.nextInt();
        for (int testCaseIndex = 0; testCaseIndex < numberOfTestCases; ++testCaseIndex) {
            int johnVoteBags = sc.nextInt();
            int jackVoteBags = sc.nextInt();

            int[] johnVoteBagsContents = new int[johnVoteBags];
            for (int index = 0; index < johnVoteBags; ++index) {
                johnVoteBagsContents[index] = sc.nextInt();
            }

            int[] jackVoteBagsContents = new int[jackVoteBags];
            for (int index = 0; index < jackVoteBags; ++index) {
                jackVoteBagsContents[index] = sc.nextInt();
            }

            int minSwaps = minSwaps(johnVoteBags, johnVoteBagsContents, jackVoteBags, jackVoteBagsContents);
            System.out.println(minSwaps);
        }
        sc.close();
    }

    private static int minSwaps(int johnVoteBags, int[] johnVoteBagsContents, int jackVoteBags, int[] jackVoteBagsContents) {
        int minSwaps = 0;

        int johnVotes = total(johnVoteBags, johnVoteBagsContents);
        int jackVotes = total(jackVoteBags, jackVoteBagsContents);
        if (johnVotes > jackVotes) {
            return 0;
        }

        Arrays.sort(johnVoteBagsContents);
        Arrays.sort(jackVoteBagsContents);

        int johnIndex = 0;
        int jackIndex = jackVoteBags - 1;
        int holder = 0;

        while (johnIndex < johnVoteBags && jackIndex >= 0) {
            // If different then alone swap
            if (johnVoteBagsContents[johnIndex] != jackVoteBagsContents[jackIndex]) {
                holder = johnVoteBagsContents[johnIndex];
                johnVoteBagsContents[johnIndex] = jackVoteBagsContents[jackIndex];
                jackVoteBagsContents[jackIndex] = holder;
            }
            ++minSwaps;
            ++johnIndex;
            --jackIndex;

            johnVotes = total(johnVoteBags, johnVoteBagsContents);
            jackVotes = total(jackVoteBags, jackVoteBagsContents);
            if (johnVotes > jackVotes) {
                return minSwaps;
            }
        }
        // If it comes to this area that means both votes are identical and swapping any number of times will make no sense
        return -1;
    }

    private static int total(int voteBags, int[] voteBagsContents) {
        int total = 0;
        for (int index = 0; index < voteBags; ++index) {
            total = total + voteBagsContents[index];
        }
        return total;
    }

}
