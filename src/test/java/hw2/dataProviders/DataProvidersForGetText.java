package hw2.dataProviders;

import org.testng.annotations.DataProvider;

import static hw2.enums.YaSpellerLanguages.*;
import static hw2.enums.YaSpellerOptions.DEFAULT;


public class DataProvidersForGetText {

    @DataProvider()
    public Object[][] wordDataProvider() {
        return new Object[][]{
                {EN, DEFAULT, "helo", "hello"},
                {EN, DEFAULT, "muther", "mother"},
                {EN, DEFAULT, "windaw", "window"},
                {EN, DEFAULT, "laptap", "laptop"},
                {EN, DEFAULT, "wintir", "winter"}
        };
    }
}