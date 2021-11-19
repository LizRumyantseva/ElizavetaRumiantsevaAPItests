package hw2.service;

import hw2.dto.YandexSpellerDto;
import hw2.enums.YaSpellerErrorCodes;
import io.restassured.response.Response;

import java.util.List;
import static org.testng.Assert.*;

public class AssertionSteps {

    private YandexSpellerDto yandexSpellerDto;
    private List<YandexSpellerDto> yandexSpellerDtoList;
    private Response response;

    public AssertionSteps(Response response) {
        this.response = response;
    }

    public AssertionSteps makeDtoList(){
        yandexSpellerDtoList = new ResponseJsonParser()           // for checkTexts - sentence
                .getResponseForSentenceFromJson(response);
        return this;
    }

    public AssertionSteps makeDto(){
        yandexSpellerDto = new ResponseJsonParser()               // for checkText - word
                .getResponseForWordFromJson(response);
        return this;
    }

    public void verifyCorrectWord(String expectedWord) {
        assertTrue(yandexSpellerDto.getS().contains(expectedWord));
    }

    public void verifyCorrectSentence(List<String> expectedWords) {
        int i = 0;
        for (String word : expectedWords) {
            assertTrue(yandexSpellerDtoList.get(i).getS().contains(word));
            i++;
        }
    }

    public void verifyErrorCodesForSentence(YaSpellerErrorCodes error) {
        for (int i = 0; i < yandexSpellerDtoList.size(); i++) {
            assertEquals(String.valueOf(yandexSpellerDtoList.get(i).getCode()), error.getErrorCode().toString());
        }
    }
}
