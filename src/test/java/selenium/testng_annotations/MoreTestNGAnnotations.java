package selenium.testng_annotations;

import org.testng.annotations.*;

public class MoreTestNGAnnotations {

    @BeforeSuite
    public void beforeSuite(){
        // delete cookies
        System.out.println("Before Suite");

    }

    @BeforeTest
    public void beforeTest(){
        // database connections
        // only one time per test annotation
        System.out.println("Before Test");
    }

    @BeforeClass
    public void beforeClass(){
        // navigate to webpage not limited to this only
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @Test
    public void test(){
        System.out.println("test method");
    }

    @Test
    public void test2(){
        System.out.println("test method 2");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }

}
