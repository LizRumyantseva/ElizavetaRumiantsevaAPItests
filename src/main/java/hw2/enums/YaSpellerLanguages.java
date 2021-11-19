package hw2.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum YaSpellerLanguages {
    EN("en"),
    RU("ru");

    private String language;
}
