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
            for (Category category : categories) {
                fw.write(getHTMLCategoryInfomation(category));
                int totalCoursesByCategory = getTotalCoursesByCategory(courses, category);
                fw.write(getHTmlTotalCoursesByCategory(totalCoursesByCategory));
                int totalHoursCourseByCategory = getTotalHoursCourseByCategory(courses, category);
                fw.write(getHTmlTotalHourCoursesByCategory(totalHoursCourseByCategory));
                fw.write(getHtmlSubCategory(subCategories, category, courses));

            }
            fw.write(getFooterHtml());
            fw.write(getEndHTML());
            System.out.println("index.html created. Sucess \u2705");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println("index.html was not created. Failed \u274C");
        }
    }

    private static String getBeginHTML() {
        return """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <link rel="stylesheet" href="reset.css">
                    <link rel="stylesheet" href="style.css">
                    <link rel="preconnect" href="https://fonts.googleapis.com">                   
                    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
                    <link href="https://fonts.googleapis.com/css2?family=Orbitron:wght@700&display=swap" rel="stylesheet">
                    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
                    <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@700&display=swap" rel="stylesheet">
                    <script src="https://kit.fontawesome.com/34289682d8.js" crossorigin="anonymous"></script>
                    <title> RTech | Categoria </title>
                </head>
                <body>
                     <header>
                         <h1> RTech </h1>
                     </header>
                     <main>
                 """;
    }

    private static String getEndHTML() {
        return """
                </body>
                </html>
                """;
    }

    private static String getDivBanner(String categoryName) {
        String bannerProgramming = "https://i.imgur.com/TGd1LCW.png";
        String bannerDevOps = "https://i.imgur.com/VaUu6hI.png";
        String bannerBusiness = "https://i.imgur.com/ZLPSIjs.png";
        String categoryNameSelected = "";
        if (categoryName.equals("Programação")) categoryNameSelected = bannerProgramming;
        if (categoryName.equals("DevOps")) categoryNameSelected = bannerDevOps;
        if (categoryName.equals("Business")) categoryNameSelected = bannerBusiness;
        return """
                <div class="content-banner">
                    <img src="%s">
                </div>
                """.formatted(categoryNameSelected);
    }

    private static String getHTMLCategoryInfomation(Category category) {
        return """
                        <section style="background-color: %s;">
                                %s
                            <div class="container-icon-title">
                                <img src="%s">
                                <h2>%s</h2>
                            </div>
                            <p class="element-description-category">%s</p>
                            <div class="content-category-subcategory">
                """.formatted(category.getHtmlColorCode(), getDivBanner(category.getName()), category.getIconPath(), category.getName(), category.getDescription());
    }

    private static int getTotalCoursesByCategory(List<Course> courses, Category category) {
        int total = 0;
        for (Course course : courses) {
            if (course.getSubCategory().getCategory().getCode().equals(category.getCode())) total++;
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
        for (Course course : courses) {
            if (course.getSubCategory().getCategory().getCode().equals(category.getCode()))
                total += course.getEstimatedTimeCourseCompletion();
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
        for (SubCategory subCategory : subCategories) {
            if (subCategory.isActive() && subCategory.getCategory().getCode().equals(category.getCode())) {
                subCategoriesHTML += """
                                    <h3> Subcategoria %s </h3>
                                    <p class="style-subtitle"> Descrição </p>
                                    <p class="content-justify"> %s </p>
                                    <h4 class="style-subtitle"> Cursos </h4>
                                    <p class="content-justify"> %s </p>
                        """.formatted(subCategory.getName(), (subCategory.getDescription().equals("") ? "Sem descrição" : subCategory.getDescription()), getCourseByCategory(subCategory, courses));
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
        for (Course course : courses) {
            if (course.getSubCategory().getCode().equals(subCategory.getCode())) {
                coursesByCategory += " %s, ".formatted(course.getName());
            }
        }
        if (coursesByCategory.equals("")) return "Sem curso";
        return coursesByCategory;
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

}
