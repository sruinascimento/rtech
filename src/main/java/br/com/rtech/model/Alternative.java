package br.com.rtech.model;

import br.com.rtech.validation.Validate;

public class Alternative {
    
    private String text;
    private int order;
    private boolean correct;
    private String justification;
    private Question question;

    public Alternative(String text, boolean correct, Question question) {
        Validate.validateText(text, "[a-zA-Zç\\s^~´]{3,}", ErrorMessage.ALTERNATIVE_TEXT.getMessage());

//        Validate.validateWord(text, ErrorMessage.ALTERNATIVE_TEXT);
        this.text = text;
        this.correct = correct;
        this.question = question;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "br.com.rtech.model.Alternative{" +
                "text='" + text + '\'' +
                ", order=" + order +
                ", correct=" + correct +
                ", justification='" + justification + '\'' +
                ", question=" + question +
                '}';
    }
}
