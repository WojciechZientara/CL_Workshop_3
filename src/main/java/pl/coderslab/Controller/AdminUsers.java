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
import java.util.Arrays;

@WebServlet("/adminUsers")
public class AdminUsers extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        User[] users = userDao.findAll();

        UserGroupDao userGroupDao = new UserGroupDao();
        UserGroup[] groups = new UserGroup[0];

        for (User user : users) {
            groups = Arrays.copyOf(groups, groups.length + 1);
            groups[groups.length -1] = userGroupDao.read(user.getGroupId());
        }

        request.setAttribute("users", users);
        request.setAttribute("groups", groups);
        request.getServletContext().getRequestDispatcher("/adminUsers.jsp").forward(request, response);

    }
}
