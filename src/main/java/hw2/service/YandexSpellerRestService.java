package hw2.service;

import hw2.enums.YaSpellerLanguages;
import hw2.enums.YaSpellerOptions;
import hw2.enums.YaSpellerRequestParameters;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class YandexSpellerRestService extends CommonService {

    private YandexSpellerRestService restService;
    private Map<String, String> serviceRequestData = new HashMap<>();

    public YandexSpellerRestService getInstance() {
        if (restService == null)
            restService = new YandexSpellerRestService();

        return restService;
    }

    public static class RequestBuilder {

        private Map<String, String> requestOptions = new HashMap<>();

        private RequestBuilder() {
        }

        public RequestBuilder putLanguage(YaSpellerLanguages language) {
            requestOptions.put(YaSpellerRequestParameters.LANGUAGE.getParameters(), language.getLanguage());
            return this;
        }

        public RequestBuilder putOptions(YaSpellerOptions options) {
            requestOptions.put(YaSpellerRequestParameters.OPTIONS.getParameters(), options.getOptionCode());
            return this;
        }

        public RequestBuilder putText(String text) {
            requestOptions.put(YaSpellerRequestParameters.TEXT.getParameters(), text);
            return this;
        }

        public YandexSpellerRestService returnServiceWithSetData() {
            YandexSpellerRestService serviceRequestData = new YandexSpellerRestService();
            serviceRequestData.serviceRequestData = requestOptions;
            return serviceRequestData;
        }
    }

    public static RequestBuilder makeRequest() {
        return new RequestBuilder();    // put parameters to request
    }

    public Response sendRequestTo(String uri) {
        RequestSpecification specification = given(REQUEST_SPECIFICATION);
        specification.queryParams(serviceRequestData);
        return specification.get(uri);
    }

}
