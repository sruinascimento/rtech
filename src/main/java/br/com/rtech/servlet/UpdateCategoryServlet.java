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

@WebServlet(urlPatterns = "/alteraCategoria")
public class UpdateCategoryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {

        try {
            Long id = Long.valueOf(req.getParameter("code"));
            EntityManager entityManager = JPAUtil.getEntityManager();
            CategoryDao categoryDao = new CategoryDao(entityManager);
            Category category = categoryDao.getCategoryById(id);

            if (category != null) {
                category.setName(req.getParameter("name"));
                category.setCode(req.getParameter("code"));
                category.setHtmlColorCode(req.getParameter("color"));
                category.setDescription(req.getParameter("description"));
                entityManager.getTransaction().begin();
                categoryDao.update(category);
                entityManager.getTransaction().commit();
                entityManager.close();
                resp.sendRedirect("/listaCategorias");
            }
        } catch (NumberFormatException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
