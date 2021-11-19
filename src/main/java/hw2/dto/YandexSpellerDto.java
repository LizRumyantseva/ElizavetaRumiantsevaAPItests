package hw2.dto;

import lombok.*;

import java.util.List;

@Getter
public class YandexSpellerDto {
    private int code;
    private int pos;
    private int row;
    private int col;
    private int len;
    private String word;
    private List<String> s;
}
