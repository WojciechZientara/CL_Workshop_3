package pl.coderslab.Controller;

import pl.coderslab.Dao.UserGroupDao;
import pl.coderslab.Model.UserGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminGroupsDelete")
public class AdminGroupsDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int groupId = Integer.parseInt(request.getParameter("id"));
        UserGroupDao userGroupDao = new UserGroupDao();
        userGroupDao.delete(groupId);
        request.getServletContext().getRequestDispatcher("/adminGroups").forward(request, response);
    }
}
