package br.com.rtech.model;
public class Instructor {

    private String name;

    public Instructor(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return  "Instructor{ \n" +
                "name= '" + this.name + "\'\n";
    }
}
