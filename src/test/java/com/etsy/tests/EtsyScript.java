package com.etsy.tests;

import com.etsy.pages.EtsyMain;
import com.etsy.pages.ProductListPage;
import org.testng.annotations.Test;

public class EtsyScript extends TestBaseEtsy{

    @Test
    public void validateSearchBar(){

        EtsyMain main = new EtsyMain(driver);
        main.sendKeysToSearchBar("iPhone 15 Pro Max Case");

        ProductListPage listPage = new ProductListPage(driver);

        listPage.getAlliPhones("iPhone");

    }

    @Test
    public void testEtsy1(){
        System.out.println("some text");
    }

    @Test
    public void testEtsy2(){
        System.out.println("another text");
    }

    @Test
    public void testEtsy3(){
        System.out.println("another new text");
    }

}
