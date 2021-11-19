package hw2.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum YaSpellerRequestParameters {
    TEXT("text"),
    OPTIONS("options"),
    LANGUAGE("lang");

    private String parameters;
}