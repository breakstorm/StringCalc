package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalcTest {

    @Test
    void add() {
        StringCalc calc = new StringCalc();

        String str1 = " "; // 0
        assertEquals(0, calc.add(str1));
        
        String str2 = "1,2";   // 3
        String str3 = "1,2,3"; // 6
        String str4 = "1,2;3"; // 6
        String str5 = "\\;/n1;2;3"; // 6
        String str6 = " ";

    }
}