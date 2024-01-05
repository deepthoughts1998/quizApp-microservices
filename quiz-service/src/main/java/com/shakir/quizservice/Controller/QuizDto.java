package com.shakir.quizservice.Controller;


public class QuizDto {
    private String title;
    private Integer qNo;
    private String category;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getqNo() {
        return qNo;
    }

    public void setqNo(Integer qNo) {
        this.qNo = qNo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
