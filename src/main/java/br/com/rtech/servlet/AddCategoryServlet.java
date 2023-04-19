package br.com.rtech.servlet;

import br.com.rtech.dao.CategoryDao;
import br.com.rtech.model.Category;
import br.com.rtech.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/cadastraCategoria")
public class AddCategoryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        CategoryDao categoryDao = new CategoryDao(entityManager);

        String name = req.getParameter("name");
        String code = req.getParameter("code");
        String htmlColorCode = req.getParameter("color");
        String urlIcon = req.getParameter("icon");
        String description = req.getParameter("description");

        Category category = new Category(name, code);
        category.setHtmlColorCode(htmlColorCode);
        category.setIconPath(urlIcon);
        category.setDescription(description);

        entityManager.getTransaction().begin();
        categoryDao.insert(category);
        entityManager.getTransaction().commit();

        try {
            resp.sendRedirect("/listaCategorias");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
