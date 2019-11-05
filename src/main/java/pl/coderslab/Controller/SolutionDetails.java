package pl.coderslab.Controller;

import pl.coderslab.Dao.SolutionDao;
import pl.coderslab.Model.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/solution")
public class SolutionDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int solutionId = Integer.parseInt(request.getParameter("id"));
        SolutionDao solutionDao = new SolutionDao();
        Solution solution = solutionDao.read(solutionId);

        request.setAttribute("solution", solution);
        request.getServletContext().getRequestDispatcher("/solutionDetails.jsp").forward(request, response);

    }
}
