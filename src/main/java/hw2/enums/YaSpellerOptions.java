package hw2.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum YaSpellerOptions {
    DEFAULT("0"),
    IGNORE_DIGITS("2"),
    IGNORE_URLS("4"),
    FIND_REPEAT_WORDS("8"),
    IGNORE_CAPITALIZATION("512");

    private String optionCode;
}

