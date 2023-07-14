package com.example.QuoraUserProfile.dto;




public class QuestionDto {
    private String questionId;
    private String userId;
    private String question;
    private String catogoryName;
    private String date;




    public QuestionDto(){}


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCatogoryName() {
        return catogoryName;
    }

    public void setCatogoryName(String catogoryName) {
        this.catogoryName = catogoryName;
    }

    public QuestionDto(String questionId, String userId, String question, String catogoryName,String date) {
        this.questionId = questionId;
        this.userId = userId;
        this.question = question;
        this.catogoryName = catogoryName;
        this.date=date;
    }
}