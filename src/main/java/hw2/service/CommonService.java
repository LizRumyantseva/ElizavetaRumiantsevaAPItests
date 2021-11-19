package hw2.service;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;
import java.util.Properties;

public class CommonService {
    public RequestSpecification REQUEST_SPECIFICATION;

    private ProjectProperties props = new ProjectProperties();

    public CommonService() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setAccept(ContentType.JSON)
                .setBaseUri(props.getProperties().get("service").toString())  //base uri
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }
}
