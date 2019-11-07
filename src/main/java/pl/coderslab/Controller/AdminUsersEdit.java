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

@WebServlet("/adminUsersEdit")
public class AdminUsersEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int userId =  Integer.parseInt(request.getParameter("userId"));
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int groupId =  Integer.parseInt(request.getParameter("group"));
        
        UserDao userDao = new UserDao();
        User user = new User();

        user.setId(userId);
        user.setUsername(userName);
        user.setEmail(email);
        user.setPassword(password);
        if (groupId != 0) {
            user.setGroupId(groupId);
        }

        userDao.update(user);
        response.sendRedirect("adminUsers");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int userId = Integer.parseInt(request.getParameter("id"));

        UserDao userDao = new UserDao();
        UserGroupDao userGroupDao = new UserGroupDao();
        User user = userDao.read(userId);
        UserGroup currentGroup = userGroupDao.read(user.getGroupId());
        UserGroup[] groups = userGroupDao.findAll();

        request.setAttribute("user", user);
        request.setAttribute("currentGroup", currentGroup);
        request.setAttribute("groups", groups);
        request.getServletContext().getRequestDispatcher("/adminUsersEdit.jsp").forward(request, response);

    }
}
