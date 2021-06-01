package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalcTest {
    private StringCalc calc;

    @BeforeEach
    void setup () {
        calc = new StringCalc();
        System.out.println("BeforeEach");
    }

    @Test
    void addCase1() {
        String str1 = " "; // 0
        assertEquals(0, calc.add(str1));
    }

    @Test
    void addCase2() {
        String str2 = "1,2";   // 3
        assertEquals(3, calc.add(str2));
    }

    @Test
    void addCase3() {
        String str3 = "1,2,3"; // 6
        assertEquals(6, calc.add(str3));
    }

    @Test
    void addCase4() {
        String str4 = "1,2;3"; // 6
        assertEquals(6, calc.add(str4));
    }

    @Test
    void addCase5() {
        String str5 = "\\;/n1;2;3"; // 6
        assertEquals(6, calc.add(str5));
    }

    @Test
    void addCase6() {
        String str6 = "\\;/n1;2;3"; // 6
        assertEquals(6, calc.add(str6));
    }
}