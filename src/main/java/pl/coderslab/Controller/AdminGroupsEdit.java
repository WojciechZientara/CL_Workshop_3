package pl.coderslab.Controller;

import pl.coderslab.Dao.UserGroupDao;
import pl.coderslab.Model.UserGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminGroupsEdit")
public class AdminGroupsEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String groupName = request.getParameter("groupName");
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        UserGroupDao userGroupDao = new UserGroupDao();
        UserGroup userGroup = new UserGroup();
        userGroup.setId(groupId);
        userGroup.setName(groupName);
        userGroupDao.update(userGroup);
        response.sendRedirect("adminGroups");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int groupId = Integer.parseInt(request.getParameter("id"));
        UserGroupDao userGroupDao = new UserGroupDao();
        UserGroup group = userGroupDao.read(groupId);
        request.setAttribute("group", group);
        request.getServletContext().getRequestDispatcher("/adminGroupsEdit.jsp").forward(request, response);

    }
}
