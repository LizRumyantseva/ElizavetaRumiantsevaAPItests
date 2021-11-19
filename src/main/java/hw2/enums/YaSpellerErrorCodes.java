package hw2.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum YaSpellerErrorCodes {
    ERROR_UNKNOWN_WORD("1"),
    ERROR_REPEAT_WORD("2"),
    ERROR_CAPITALIZATION("3"),
    ERROR_TOO_MANY_ERRORS("4");

    private String errorCode;
}
