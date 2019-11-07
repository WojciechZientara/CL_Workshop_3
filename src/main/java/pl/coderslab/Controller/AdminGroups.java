package pl.coderslab.Controller;

import pl.coderslab.Dao.UserGroupDao;
import pl.coderslab.Model.UserGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminGroups")
public class AdminGroups extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserGroupDao userGroupDao = new UserGroupDao();
        UserGroup[] userGroups = userGroupDao.findAll();

        request.setAttribute("userGroups", userGroups);
        request.getServletContext().getRequestDispatcher("/adminGroups.jsp").forward(request, response);

    }
}
