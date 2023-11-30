package selenium.data_provider;

import org.testng.annotations.DataProvider;

public class DataProviderRecords {

    @DataProvider(name = "testData")
    public Object[][] getData(){

        return new Object[][]{

                {"Nurzhol", "Iadgar"},
                {"Azamat", "Maria"},
                {"Atai", "Kuba"},
                {"Olena", "Valentyna"},


        };

    }


}
