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
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/listaCategorias")
public class CategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        CategoryDao categoryDao = new CategoryDao(JPAUtil.getEntityManager());
        List<Category> categories = categoryDao.getCategories();
        try {
            req.setAttribute("categories", categories);
            req.getRequestDispatcher("/categorias.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
