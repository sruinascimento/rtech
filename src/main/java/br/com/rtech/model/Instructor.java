package br.com.rtech.model;

import br.com.rtech.validation.Validate;
import jakarta.persistence.*;

@Entity
@Table(name = "instructor")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_instructor")
    private String name;

    public Instructor(String name) {
        Validate.validateText(name, "[a-zA-Zç\\sáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ:]{3,}", ErrorMessage.INSTRUCTORS_NAME.getMessage());
        this.name = name;
    }

    public Instructor() {

    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  "Instructor{ \n" +
                "name= '" + this.name + "\'\n";
    }
}
