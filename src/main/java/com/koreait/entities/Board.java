package com.koreait.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private Long id;
    private String subject;
    private String content;
    private LocalDateTime regDt;
}
