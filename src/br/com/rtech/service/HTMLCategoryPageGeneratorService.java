package br.com.rtech.service;

import br.com.rtech.model.Category;
import br.com.rtech.model.Course;
import br.com.rtech.model.SubCategory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HTMLCategoryPageGeneratorService {

    public static void generateCategoryPage(List<Category> categories, List<Course> courses, List<SubCategory> subCategories) {

        try (FileWriter fw = new FileWriter("index.html")) {
            fw.write(getBeginHTML());
            for (Category category: categories) {
                fw.write(getHTMLCategoryInfomation(category));
                int totalCoursesByCategory =  getTotalCoursesByCategory(courses, category);
                fw.write(getHTmlTotalCoursesByCategory(totalCoursesByCategory));
                int totalHoursCourseByCategory = getTotalHoursCourseByCategory(courses, category);
                fw.write(getHTmlTotalHourCoursesByCategory(totalHoursCourseByCategory));
                fw.write(getHtmlSubCategory(subCategories, category, courses));

            }
            fw.write(getEndHTML());
            System.out.println("index.html created sucess");
        }catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static String getBeginHTML() {
        return """
               <!DOCTYPE html>
               <html lang="en>
               <head>
                   <meta charset="UTF-8">
                   <link rel="stylesheet" href="reset.css">
                   <link rel="stylesheet" href="style.css">
                   <link rel="preconnect" href="https://fonts.googleapis.com">                   
                   <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
                   <link href="https://fonts.googleapis.com/css2?family=Orbitron:wght@700&display=swap" rel="stylesheet">
                   <script src="https://kit.fontawesome.com/34289682d8.js" crossorigin="anonymous"></script>
                   <title> RTech | Categoria </title>
               </head>
               <body>
                    <header>
                        <h1 style="text-align:center; font-family: 'Orbitron', sans-serif;"> RTech </h1>
                    </header>
                    <main>
                """;
    }

    private static String getEndHTML() {
        return """
                    </main>
                </body>
                </html>
                """;
    }

    private static String getHTMLCategoryInfomation(Category category) {
        return """
                        <section style="background-color: %s;">
                            <div class="container-icon-title">
                                <img src="%s">
                                <h2>%s</h2>
                            </div>
                            <p class="element-description-category">%s</p>
                            <div class="content-category-subcategory">
                """.formatted(category.getHtmlColorCode(), category.getIconPath(), category.getName(), category.getDescription());
    }

    private static int getTotalCoursesByCategory(List<Course> courses, Category category) {
        int total = 0;
        for (Course course: courses) {
            if ( course.getSubCategory().getCategory().equals(category.getCode()) ) total++;
        }
        return total;
    }

    private static String getHTmlTotalCoursesByCategory(int total) {
        return """         
                            <div class="content-hour-and-course-quantity">
                              <p>
                                    <i class="fa-solid fa-book"></i> %d Cursos </br>
                              </p>
                """.formatted(total);
    }

    private static int getTotalHoursCourseByCategory(List<Course> courses, Category category) {
        int total = 0;
        for (Course course: courses) {
            if ( course.getSubCategory().getCategory().equals(category.getCode())) total += course.getEstimatedTimeCourseCompletion();
        }
        return total;
    }

    private static String getHTmlTotalHourCoursesByCategory(int total) {
        return """          
                                <p>                
                                    <i class="fa-solid fa-hourglass-half"></i> %dh para conclusão
                                </p>
                            </div>
                """.formatted(total);
    }

    private static String getHtmlSubCategory(List<SubCategory> subCategories, Category category, List<Course> courses) {
        String subCategoriesHTML = "";
        for (SubCategory subCategory: subCategories) {
            if (subCategory.isActive() && subCategory.getCategory().equals(category.getCode())) {
                subCategoriesHTML += """
                                <h3> Subcategoria %s </h3>
                                <p> Descrição </p>
                                <p> %s </p>
                                <h4> Cursos </h4>
                                <p> %s </p>
                        """.formatted(subCategory.getName(), subCategory.getDescription(), getCourseByCategory(subCategory, courses));
            }
        }
        subCategoriesHTML += """
                            </div>
                        </section>
                """;
        return subCategoriesHTML;

    }

    private static String getCourseByCategory(SubCategory subCategory, List<Course> courses) {
        String coursesByCategory = "";
        for (Course course: courses) {
            if (course.getSubCategory().getCode().equals(subCategory.getCode())) {
                coursesByCategory += " %s, ".formatted(course.getName());
            }
        }
        return coursesByCategory;
    }

}
