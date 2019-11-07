package pl.coderslab.Controller;

import pl.coderslab.Dao.UserGroupDao;
import pl.coderslab.Model.UserGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminGroupsAdd")
public class AdminGroupsAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String groupName = request.getParameter("groupName");
        UserGroupDao userGroupDao = new UserGroupDao();
        UserGroup userGroup = new UserGroup();
        userGroup.setName(groupName);
        userGroupDao.create(userGroup);
        response.sendRedirect("adminGroups");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.getServletContext().getRequestDispatcher("/adminGroupsAdd.jsp").forward(request, response);

    }
}
