package com.example.exceldemo;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ExcelVO {
    private String title;
    private String author;
    private String company;
    private String isbn;
    private String imagUrl;

    public ExcelVO(String title, String author, String company) {
        this(title, author, company, null, null);
    }
}
