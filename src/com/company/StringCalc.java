package com.company;

import java.util.Scanner;

public class StringCalc {
    public static void main(String[] args) {
        String str1 = " "; // 0
        String str2 = "1,2";   // 3
        String str3 = "1,2,3"; // 6
        String str4 = "1,2;3"; // 6
        String str5 = "\\;/n1;2;3"; // 6
        String str6 = "\\;/n1;2;3"; // 6
//        String[] str6 = {"a", "b", "c"};

        StringCalc calc = new StringCalc();
        System.out.println(calc.add(str2));
        System.out.println(calc.add(str3));
        System.out.println(calc.add(str4));
        System.out.println(calc.add(str5));

//        Scanner sc = new Scanner(System.in);
//        String test = sc.nextLine();
//        System.out.printf(sc.nextLine());
    }

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