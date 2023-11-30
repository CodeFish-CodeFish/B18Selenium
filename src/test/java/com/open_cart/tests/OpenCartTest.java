package com.open_cart.tests;

import com.open_cart.pages.CustomersPage;
import com.open_cart.pages.DashBoardPage;
import com.open_cart.pages.LoginPageOpen;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class OpenCartTest extends TestBaseOpenCart{

    @Test
    public void TC_02() throws InterruptedException {

        LoginPageOpen lp = new LoginPageOpen(driver);
        lp.login(ConfigReader.readProperty("userName"), ConfigReader.readProperty("passwordForMe"));

        DashBoardPage page = new DashBoardPage(driver);
        page.closePop();
        page.validateStatistics();

        CustomersPage customersPage = new CustomersPage(driver);
        customersPage.getNames();
    }

    @Test
    public void avoidMe(){
        System.out.println("This should not be printed");
    }

}
