package hw2.service;

import hw2.enums.YaSpellerLanguages;
import hw2.enums.YaSpellerOptions;
import io.restassured.response.Response;

public class ActionSteps {

    public static Response getCheck(String URI, YaSpellerLanguages language, YaSpellerOptions option, String textToCheck) {
        return YandexSpellerRestService
                .makeRequest()
                .putLanguage(language)
                .putOptions(option)
                .putText(textToCheck)
                .returnServiceWithSetData()
                .sendRequestTo(URI);
    }
}
