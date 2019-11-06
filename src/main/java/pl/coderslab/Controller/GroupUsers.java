package pl.coderslab.Controller;

import pl.coderslab.Dao.UserDao;
import pl.coderslab.Dao.UserGroupDao;
import pl.coderslab.Model.User;
import pl.coderslab.Model.UserGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/groupUsers")
public class GroupUsers extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int groupId = Integer.parseInt(request.getParameter("id"));
        UserGroupDao userGroupDao = new UserGroupDao();
        UserGroup group = userGroupDao.read(groupId);
        UserDao userDao = new UserDao();
        User[] users = userDao.findAllByGroupId(groupId);

        request.setAttribute("group", group);
        request.setAttribute("users", users);
        request.getServletContext().getRequestDispatcher("/groupUsers.jsp").forward(request, response);

    }
}
