package br.com.rtech.main;

import br.com.rtech.model.Course;
import br.com.rtech.model.Instructor;

public class TestMudarVisibilidadeCurso {
    public static void main(String[] args) {
        Course course = new Course("Java", "java-oo", 10, new Instructor("Killua"));
        System.out.println(course);
        course.setVisibility("PÚBLICA");
        System.out.println(course);
    }
}
