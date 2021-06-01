package com.company;

import jdk.nashorn.internal.objects.annotations.Function;

import javax.xml.ws.Action;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalc {
    @Function
    private String[] textSplit(String text) {
//        return text.trim().split("[;:,]");
            Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
            if (m.find()) {
                String customDelimeter = m.group(1);
                return m.group(2).split(customDelimeter);
            }

            return text.split(",|:");
    }

    @Function
    private String[] textParse(String[] textArray) {
        Pattern pattern = Pattern.compile("[/n|\\\\]");
        for (String text: textArray) {
            Matcher m = pattern.matcher(text);
            System.out.println(m.matches());
        }
        return textArray;
    }

    @Action
    public int add(String text) {
        // 1. 구분자로 스플릿하기 : function textSplit
        // 2. 토큰별 값 파싱 : function textParse
        // 3. 값 예외처리 하기 : function textExcept
        // 4. 문자배열 값 더하기 : function textAdd

        if (text == null) {
            return 0;
        }
        if (text.isEmpty()) {
            return 0;
        }
//        String text_arrange = text.trim().replaceAll("[/n|/|\\\\]", ""); // !!삭제

//        String[] split = text_arrange.split("[;/,]"); //!!삭제
//        String[] split = this.textSplit(text_arrange); //!!삭제
        String[] split = this.textSplit(text);
        split = this.textParse(split);

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