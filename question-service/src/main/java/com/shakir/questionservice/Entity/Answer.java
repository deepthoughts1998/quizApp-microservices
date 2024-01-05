package com.shakir.questionservice.Entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Answer {

    private int id;
    private String answer;
}
