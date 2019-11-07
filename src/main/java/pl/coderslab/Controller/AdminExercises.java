package pl.coderslab.Controller;

import pl.coderslab.Dao.ExerciseDao;
import pl.coderslab.Model.Exercise;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminExercises")
public class AdminExercises extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ExerciseDao exerciseDao = new ExerciseDao();
        Exercise[] exercises = exerciseDao.findAll();

        request.setAttribute("exercises", exercises);
        request.getServletContext().getRequestDispatcher("/adminExercises.jsp").forward(request, response);

    }
}
