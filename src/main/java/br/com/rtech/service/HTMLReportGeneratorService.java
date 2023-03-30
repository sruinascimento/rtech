package br.com.rtech.service;

import br.com.rtech.model.Category;
import br.com.rtech.model.Course;
import br.com.rtech.model.SubCategory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HTMLReportGeneratorService {

    public static void generateReportPage(List<Category> categories, List<SubCategory> subCategories,
                                          List<Course> courses, List<String> nameOfSubcategoriesHasntDescription) {

        try (FileWriter fw = new FileWriter("report.html")) {
            fw.write(getBeginHTML());
            fw.write(getNameSubcategoriesHasnDescriptionHTML(nameOfSubcategoriesHasntDescription));
            fw.write(getCategoryStringHtml(categories, subCategories, courses));
            fw.write(getFooterHtml());
            fw.write(getEndHTML());
            System.out.println("report.html created. Sucess \u2705");
        } catch (IOException e) {
            System.out.println("report.html was not created. Failed \u274C");
            throw new RuntimeException(e);

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
                    <title> RTech | Report </title>
                </head>
                <body>
                     <header>
                         <h1> RTech </h1>
                     </header>
                    
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

    private static String getCategoryStringHtml(List<Category> categories, List<SubCategory> subcategories, List<Course> courses) {
        String html = "  <main> ";
        for (Category category : categories) {
            html += getHTMLCategoryInfomation(category, subcategories, courses);
        }
        return html;
    }

    private static String getHTMLCategoryInfomation(Category category, List<SubCategory> subCategories, List<Course> courses) {
        return """
                        <section style="background-color: %s;">
                                %s
                            <div class="container-icon-title">
                                <img src="%s">
                                <h2>%s</h2>
                            </div>
                            <p class="element-description-category">%s</p>
                            
                            %s
                            
                        </section>
                """.formatted(category.getHtmlColorCode(), getDivBanner(category.getName()), category.getIconPath(),
                category.getName(), category.getDescription(), getSubcategoryByCategoryHTML(category, subCategories, courses));
    }

    private static String getSubcategoryByCategoryHTML(Category category, List<SubCategory> subCategories, List<Course> courses) {
        String html = "";
        for (SubCategory subCategory : subCategories) {
            if (category.getName().equals(subCategory.getCategory().getName())) {
                html += """
                        <div class="content-category-subcategory">
                            <br>
                            <strong style="font-size:20px;"> Subcategoria </strong> </br></br>
                            <strong>ID =  </strong>%d <br>
                            <strong>Nome = </strong> %s <br>
                            <strong>Código = </strong> %s <br>
                            <strong>Descrição = </strong> %s <br>
                            <strong>Guia de estudos = </strong> %s <br>
                            <strong>Status da subcategoria </strong> = %s <br>
                            <strong>Ordem = </strong>  %d <br>
                            <strong style=" font-size:20px;">Cursos:</strong> <br>
                            %s
                            
                        </div>
                        """.formatted(subCategory.getId(), subCategory.getName(), subCategory.getCode(),
                        subCategory.getDescription(), subCategory.getStudyGuide(), subCategory.getActive().toString(),
                        subCategory.getOrder(), getCourseBySubcategoryHTML(subCategory, courses));
            }
        }

        return html;
    }

    private static String getCourseBySubcategoryHTML(SubCategory subCategory, List<Course> courses) {
        String html = "";
        for (Course course : courses) {
            if (course.getSubCategory() != null && course.getSubCategory().getName().equals(subCategory.getName())) {
                html += """
                        <div>
                            <strong>ID</strong> = %d <br>
                            <strong>Nome</strong> = %s <br>
                            <strong>Código</strong> = %s <br>
                            <strong>Tempo estimado para conclusão</strong> = %d <br>
                            <strong>Nome do Instrutor</strong> = %s <br>
                        </div>
                        """.formatted(course.getId(), course.getName(), course.getCode(),
                        course.getEstimatedTimeCourseCompletion(), course.getInstructor());
            }
        }

        return html;
    }

    private static String getNameSubcategoriesHasnDescriptionHTML(List<String> nameOfSubcategoriesHasntDescription) {
        var categoriesHasNotDescription = new StringBuilder();
        nameOfSubcategoriesHasntDescription.forEach(name -> categoriesHasNotDescription.append("<li>" + name + "</li>\n"));
        return """
                                
                <div style="margin: 20px auto; background-color: white; width: 30%%; text-align:center; border-radius: 4px; padding: 6px 0;">
                    <h3 style="font-weight:bold"> Subacategorias sem Descricção</h3>
                    <ul>
                        %s
                    </ul>
                </div>
                """.formatted(categoriesHasNotDescription);
    }

}
