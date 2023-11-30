package selenium.parameters;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterShowCase {




    @Parameters({"firstName","lastName", "country", "city"})

    @Test(priority = 1)
    public void validateParameter(String firstName, String lastName, String country, String city){

        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(country);
        System.out.println(city);
    }


    @Parameters("str")
    @Test(priority = 2)
    public void test(String str){
        System.out.println(str);


    }

}
