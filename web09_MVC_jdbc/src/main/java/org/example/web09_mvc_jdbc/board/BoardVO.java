package org.example.web09_mvc_jdbc.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {
    private int num;
    private String title;
    private String content;
    private String writer;
    private String wdate;
}
