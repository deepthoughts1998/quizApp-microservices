package com.shakir.quizservice.Entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Answer {

    private int id;
    private String answer;
}
