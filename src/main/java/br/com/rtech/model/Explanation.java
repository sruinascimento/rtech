package br.com.rtech.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "explanation")
public class Explanation extends ActivityType {

    public Explanation(String text) {
        super(text);
    }

    public Explanation() {}

    @Override
    public String toString() {
        return "Explanation=" + super.getText() + '\'' + "}";
    }

}
