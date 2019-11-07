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

@WebServlet("/adminUsersAdd")
public class AdminUsersAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int groupId =  Integer.parseInt(request.getParameter("group"));
        
        UserDao userDao = new UserDao();
        User user = new User();

        user.setUsername(userName);
        user.setEmail(email);
        user.setPassword(password);
        if (groupId != 0) {
            user.setGroupId(groupId);
        }

        userDao.create(user);
        response.sendRedirect("adminUsers");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        UserGroupDao userGroupDao = new UserGroupDao();
        UserGroup[] groups = userGroupDao.findAll();
        request.setAttribute("groups", groups);
        request.getServletContext().getRequestDispatcher("/adminUsersAdd.jsp").forward(request, response);

    }
}
