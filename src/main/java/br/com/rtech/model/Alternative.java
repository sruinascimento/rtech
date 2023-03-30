package br.com.rtech.model;

import br.com.rtech.validation.Validate;

import javax.persistence.*;

@Entity
@Table(name = "alternative")
public class Alternative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text_alternative", columnDefinition = "TEXT")
    private String text;
    @Column(name = "order_alternative")
    private int order;
    @Column(name = "is_correct", columnDefinition = "TINYINT")
    private boolean correct;
    @Column(name = "justification", columnDefinition = "TEXT")
    private String justification;
    @ManyToOne
    @JoinColumn(name = "id_question")
    private Question question;

    public Alternative(String text, boolean correct, Question question) {
        Validate.validateText(text, "[a-zA-Zç\\sáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ:]{3,}", ErrorMessage.ALTERNATIVE_TEXT.getMessage());
        this.text = text;
        this.correct = correct;
        this.question = question;
    }

    public Alternative() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
