package hw2.tests;

import hw2.dataProviders.DataProvidersForGetText;
import hw2.enums.YaSpellerLanguages;
import hw2.enums.YaSpellerOptions;
import hw2.service.AssertionSteps;
import hw2.service.URIEndPoints;
import io.restassured.response.Response;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import hw2.service.ActionSteps;

public class CheckTextTest {
    private Response YANDEX_RESPONSE;

    @BeforeTest
    public void setup() {
    }

    @AfterTest
    public void teardown() {
    }

    @Test(dataProviderClass = DataProvidersForGetText.class, dataProvider = "wordDataProvider")
    public void oneWordCheck(YaSpellerLanguages language, YaSpellerOptions option, String wordToCheck, String expectedWord) {
        YANDEX_RESPONSE = ActionSteps.getCheck(URIEndPoints.CHECK_TEXT, language, option, wordToCheck);

        new AssertionSteps(YANDEX_RESPONSE)
                .makeDto()
                .verifyCorrectWord(expectedWord);
    }

}
