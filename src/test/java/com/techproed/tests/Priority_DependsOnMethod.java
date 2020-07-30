package com.techproed.tests;

import org.testng.annotations.Test;

public class Priority_DependsOnMethod {
   // @Ignore //ignore yaparsak   home page metodiu calsimadigi icin hata mesaji verir
    @Test(priority = 1)
    public void login(){
        System.out.println("Bu metod login metodu");
    }
    @Test(priority = 2, dependsOnMethods = "login")
    public void homePage(){
        System.out.println("Bu metod homepage metodu");
    }
    @Test(priority = 7)
    public void search(){
        System.out.println("Bu metod search metodu");
    }
    @Test(priority = 9, dependsOnMethods = "search")
    public void result(){
        System.out.println("Bu metod result metodu");
    }
}




