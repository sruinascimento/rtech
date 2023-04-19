package br.com.rtech.servlet;

import br.com.rtech.dao.CategoryDao;
import br.com.rtech.model.Category;
import br.com.rtech.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/listaCategoria")
public class ShowCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        CategoryDao categoryDao = new CategoryDao(entityManager);
        try {
            Long id = Long.valueOf(req.getParameter("id"));
            Category category = categoryDao.getCategoryById(id);
            req.setAttribute("category", category);
            req.getRequestDispatcher("/altera-categoria.jsp")
                    .forward(req, resp);
        } catch (NumberFormatException | IOException | ServletException e) {
            throw new RuntimeException(e);
        }
    }
}
