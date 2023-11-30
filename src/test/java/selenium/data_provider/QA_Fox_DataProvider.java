package selenium.data_provider;

import org.testng.annotations.DataProvider;

public class QA_Fox_DataProvider {

    @DataProvider(name = "records")
    public Object[][] getInfo(){

        return new Object[][]{
// In real work, instead of this work manually written test data, you will have a special method
                // from APACHE POI that reads test data or any data from excel
                {"tester@work.io", "1234","Warning: No match for E-Mail Address and/or Password."},
                {"werer@wewe.com", "43212","Warning: No match for E-Mail Address and/or Password."},
                {"xmcnvmxcb@gmail.com","xnbvmnc","Warning: No match for E-Mail Address and/or Password."},
                {"test@com.com", "43857843","Warning: No match for E-Mail Address and/or Password."},


        };

    }
}
