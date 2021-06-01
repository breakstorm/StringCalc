package com.company;

import java.util.Scanner;

public class StringCalc {
    public int add(String text) {
        if (text == null) {
            return 0;
        }
        if (text.isEmpty()) {
            return 0;
        }
        String text_arrange = text.trim().replaceAll("[/n|/|\\\\]", "");

        String[] split = text_arrange.split("[;/,]");

        int add_result = 0;
        for (String s : split) {
            try {
                if (s.isEmpty()) {
                    continue;
                }
                add_result += Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.err.println("error : " + e);
            }
        }

        return add_result;
    }
}