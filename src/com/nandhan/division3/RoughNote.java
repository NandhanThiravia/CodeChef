package com.nandhan.division3;

import java.util.Random;

public class RoughNote {

    public static void main(String[] args) {
        int targetStringLength = 100000;
        Random random = new Random();
        int bound = 1;

        StringBuffer sb = new StringBuffer(targetStringLength);
        for (int index = 0; index < targetStringLength; ++index) {
            int randomValue = random.nextInt(bound + 1);
            sb.append(randomValue);
        }
        System.out.println(sb.toString());
        System.out.println(sb.toString().length());
    }

}
