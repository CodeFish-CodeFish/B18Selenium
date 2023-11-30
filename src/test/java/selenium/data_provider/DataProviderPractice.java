package selenium.data_provider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

//    @DataProvider(name = "myData")
//    public Object[][] getData(){
//
//
//        return new Object[][]{
//
//
//                {"Nurzhol", "Iadgar"},
//                {"Azamat", "Maria"},
//                {"Atai", "Kuba"},
//                {"Olena", "Valentyna"},
//
//        };
//    }


    @Test(dataProvider = "testData", dataProviderClass = DataProviderRecords.class)
    public void testDataProvider(String name1, String name2){
        System.out.println(name1 + " " + name2);
    }







}
