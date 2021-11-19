package hw2.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hw2.dto.YandexSpellerDto;
import io.restassured.response.Response;

import java.util.List;

public class ResponseJsonParser {

    public YandexSpellerDto getResponseForWordFromJson(Response response) {
        return ((List<YandexSpellerDto>) new Gson()
                .fromJson(response.asString(), new TypeToken<List<YandexSpellerDto>>() {
                }.getType())).get(0);
    }

    public List<YandexSpellerDto> getResponseForSentenceFromJson(Response response) {
        return ((List<List<YandexSpellerDto>>) new Gson()
                .fromJson(response.asString(), new TypeToken<List<List<YandexSpellerDto>>>() {
                }.getType())).get(0);
    }


}
