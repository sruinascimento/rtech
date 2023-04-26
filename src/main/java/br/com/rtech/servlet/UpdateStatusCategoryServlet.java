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
import java.io.PrintWriter;

@WebServlet("/alteraStatusCategoria")
public class UpdateStatusCategoryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
          try {
            Long id = Long.valueOf(req.getParameter("id"));
            String status = req.getParameter("status").toUpperCase().trim();
            EntityManager entityManager = JPAUtil.getEntityManager();
            CategoryDao categoryDao = new CategoryDao(entityManager);
            Category category = categoryDao.getCategoryById(id);
            if (category != null) {
                category.toggleCategoryStatus(status);
                entityManager.getTransaction().begin();
                categoryDao.update(category);
                entityManager.getTransaction().commit();
                entityManager.close();
            } else {
                PrintWriter out = resp.getWriter();
                out.println("Categoria Inválida");
            }

        } catch (NumberFormatException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}
