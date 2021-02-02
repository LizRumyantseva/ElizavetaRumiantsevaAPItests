package hw2.dataProviders;

import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.List;

import static hw2.enums.YaSpellerErrorCodes.*;
import static hw2.enums.YaSpellerLanguages.*;
import static hw2.enums.YaSpellerOptions.DEFAULT;

public class DataProviderForGetTexts {

    @DataProvider
    public Object[][] sentenceForErrorCodeDataProvider() {
        return new Object[][]{
                {RU, DEFAULT, "магозин подарков", ERROR_UNKNOWN_WORD},
                {EN, DEFAULT, "hello world world world", ERROR_REPEAT_WORD}
        };
    }

    @DataProvider
    public Object[][] wrongSentenceDataProvider() {
        List<String> rusExpectedWords = Arrays.asList("спокойной", "доброй", "ночи");
        List<String> enExpectedWords = Arrays.asList("hello", "world");
        return new Object[][]{
                {RU, DEFAULT, "спакойной добрай ночш", rusExpectedWords},
                {EN, DEFAULT, "helo worllld", enExpectedWords}
        };
    }

}
