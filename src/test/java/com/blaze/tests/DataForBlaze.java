package com.blaze.tests;

import org.testng.annotations.DataProvider;

public class DataForBlaze {

    @DataProvider(name = "mockData")
    public Object[][]getData(){

        return new Object[][]{

                {"Nurzhol", "USA", "Silicon Valley", "123456789", "12", "2023", "Thank you for your purchase!", "MacBook Pro"},
                {"Joshue", "Canada", "Ottawa", "123456789", "12", "2023", "Thank you for your purchase!", "MacBook Pro"},
                {"Atai", "UK", "London", "32323323232", "12", "2023", "Thank you for your purchase!", "MacBook Pro"},
                {"John Wick", "Mexico", "Mexico City", "32323323232", "12", "2023", "Thank you for your purchase!", "MacBook Pro"},

        };

    }

}
