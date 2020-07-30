package com.techproed.tests;

import org.testng.annotations.*;

public class TestNGAnnotations {
@Ignore   // before methodu engellemez. before methodu sadece test annotions'da  calisir
    @BeforeMethod    // en uste yazmak sart degildir ama guzeldir
    public void beforeMethod() {
        System.out.println("====befeore methodu");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("++++++++befeore Class");
    }

    @Test
    public void test1() {
        System.out.println("Bu test1 metodudr");
    }

    @Test
    public void test2() {
        System.out.println("Bu test2 metodudur");
    }

    @Ignore  // test3u calistirmaz
    @Test
    public void test3() {
        System.out.println("Bu test3 metodudur");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("after methodumuz========");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("after classimiz +++++++");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("=+=+=+ after testimiz");
    }

    @BeforeTest
    public void befureTest() {
        System.out.println("-=-=-=-=-=-=-befere Testimiz");
    }
}

