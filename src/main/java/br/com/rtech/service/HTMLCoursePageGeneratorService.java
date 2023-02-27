package br.com.rtech.service;


import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HTMLCoursePageGeneratorService {
    public static void generateCoursePage(List<String[]> courses) {
        try (FileWriter fileWriter = new FileWriter("course.html")) {
            fileWriter.write(getBeginHTML());
            for (String[] course : courses) {
                String idCourse = course[0];
                String courseName = course[1];
                String estimatedTimeCourseCompletion = course[2];
                String idSubcategory = course[3];
                String subcategoryName = course[4];
                fileWriter.write(getDivContetCourse(idCourse, courseName, estimatedTimeCourseCompletion, idSubcategory, subcategoryName));
//                fileWriter.write("<p>" + course[0] +"</p>");
//                fileWriter.write("\n");
//                fileWriter.write("<p>" + course[1] +"</p>");
//                fileWriter.write("\n");
//
//                fileWriter.write("<p>" + course[2] +"</p>");
//                fileWriter.write("\n");
//
//                fileWriter.write("<p>" + course[3] +"</p>");
//                fileWriter.write("\n");
//
//                fileWriter.write("<p>" + course[4] +"</p>");
                fileWriter.write("\n");

            }
            fileWriter.write(getFooterHtml());
            fileWriter.write(getEndHTML());
            System.out.println("course.html created. Sucess \u2705");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("course.html was not created. Failed \u274C");
        }
    }
    private static String getBeginHTML() {
        return """
               <!DOCTYPE html>
               <html lang="en">
               <head>
                   <meta charset="UTF-8">
                   <link rel="stylesheet" href="reset.css">
                   <link rel="stylesheet" href="course.css">
                   <link rel="preconnect" href="https://fonts.googleapis.com">                   
                   <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
                   <link href="https://fonts.googleapis.com/css2?family=Orbitron:wght@700&display=swap" rel="stylesheet">
                   <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
                   <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@700&display=swap" rel="stylesheet">
                   <script src="https://kit.fontawesome.com/34289682d8.js" crossorigin="anonymous"></script>
                   <title> RTech | Course </title>
               </head>
               <body>
                    <header>
                        <h1> RTech </h1>
                    </header>
                    <main>
                """;
    }
    private static String getFooterHtml() {
        return """
                    </main>
                    <footer>
                        <p> Rui Nascimento</p>
                        <div class="content-contact">
                            <a href="https://github.com/sruinascimento" target="_blank">
                                <i class="fa-brands fa-square-github"></i> Github
                            </a>
                            <a href="https://www.linkedin.com/in/sruinascimento/"  target="_blank">
                                <i class="fa-brands fa-linkedin"></i> Linkedin
                            </a>
                        </div>
                    </footer>
                """;
    }
    private static String getEndHTML() {
        return """
                </body>
                </html>
                """;
    }

    private static String getDivContetCourse(String idCourse, String courseName, String estimatedTimeCourseCompletion, String subcategoryId, String subcategoryName) {
        return """
                        <div class="content-course">
                            <h2 style="text-align: center"> Course </h2>
                            <p> Id do curso = %s </p>
                            <h3> Nome do curso = %s </h3>
                            <p>  <i class="fa-solid fa-hourglass-half"></i> %s horas para conclusão </p>
                            <p> Id da subcategoria = %s </>
                            <h4> Nome da subcategoria = %s </h4>
                        </div>
                """.formatted(idCourse, courseName, estimatedTimeCourseCompletion, subcategoryId, subcategoryName);
    }
}
