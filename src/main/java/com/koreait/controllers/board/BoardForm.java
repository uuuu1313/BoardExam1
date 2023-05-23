package com.koreait.controllers.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardForm {

    private Long id;
    private String subject;
    private String content;
    private LocalDateTime regDt;

}
