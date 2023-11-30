package selenium.soft_assert;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTechniques {

    public int sum(int num1, int num2){

        return num1 + num2;
    }

    @Test
    public void HardAssert(){

        Assert.assertEquals(sum(1,2), 3);
        System.out.println("This will be going ok");

        Assert.assertEquals(sum(1,1),2);
        System.out.println("This will also be ok");

        Assert.assertEquals(sum(1,1), 5);
        System.out.println("This should not be printed");
    }


    @Test
    public void checkSoftAssert(){

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(sum(1,1), 2);
        System.out.println("This will be printed");

        softAssert.assertEquals(sum(1,2), 6);
        System.out.println("This should not be printed but it will be printed");

        softAssert.assertEquals(sum(4,4), 16);
        System.out.println("This should not be printed but well.....");
        softAssert.assertAll("Run all code errors must be populated in the console");



    }
}
