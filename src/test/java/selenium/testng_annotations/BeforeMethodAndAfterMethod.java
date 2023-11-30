package selenium.testng_annotations;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeMethodAndAfterMethod {

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am @BeforeMethod");
    }

    @Test
    public void test1(){
        System.out.println("I am Test 1");
    }

    @Test
    public void test2(){
        System.out.println("I am Test 2");
    }

    @Test
    public void test3(){
        System.out.println("I am Test 3");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("I have just ripped something");
    }



}
