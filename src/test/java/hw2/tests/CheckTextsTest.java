package hw2.tests;

import hw2.dataProviders.DataProviderForGetTexts;
import hw2.enums.YaSpellerErrorCodes;
import hw2.enums.YaSpellerLanguages;
import hw2.enums.YaSpellerOptions;
import io.restassured.response.Response;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import hw2.service.ActionSteps;
import hw2.service.AssertionSteps;
import hw2.service.URIEndPoints;

import java.util.List;

public class CheckTextsTest {
    private Response YANDEX_RESPONSE;

    @BeforeTest
    public void setup() {
    }

    @AfterTest
    public void teardown() {
    }

    @Test(description = "Check texts", dataProviderClass = DataProviderForGetTexts.class,
            dataProvider = "wrongSentenceDataProvider")
    void sentenceCheck(YaSpellerLanguages language, YaSpellerOptions option, String sentence, List<String> expectedWords) {
        YANDEX_RESPONSE = ActionSteps.getCheck(URIEndPoints.CHECK_TEXTS, language, option, sentence);

        new AssertionSteps(YANDEX_RESPONSE)
                .makeDtoList()
                .verifyCorrectSentence(expectedWords);
    }

    @Test(dataProviderClass = DataProviderForGetTexts.class, dataProvider = "sentenceForErrorCodeDataProvider")
    public void errorCodeCheck(YaSpellerLanguages language, YaSpellerOptions option, String sentence, YaSpellerErrorCodes error) {
        YANDEX_RESPONSE = ActionSteps.getCheck(URIEndPoints.CHECK_TEXTS, language, option, sentence);

        new AssertionSteps(YANDEX_RESPONSE)
                .makeDtoList()
                .verifyErrorCodesForSentence(error);
    }
}
