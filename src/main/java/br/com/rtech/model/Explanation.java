package br.com.rsoft.rtech.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

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
