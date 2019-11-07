package pl.coderslab.Controller;

import pl.coderslab.Dao.ExerciseDao;
import pl.coderslab.Dao.UserGroupDao;
import pl.coderslab.Model.Exercise;
import pl.coderslab.Model.UserGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminExercisesAdd")
public class AdminExercisesAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String exerciseTitle = request.getParameter("exerciseTitle");
        String exerciseDescription = request.getParameter("exerciseDescription");

        ExerciseDao exerciseDao = new ExerciseDao();
        Exercise exercise = new Exercise();
        exercise.setTitle(exerciseTitle);
        exercise.setDescription(exerciseDescription);
        exerciseDao.create(exercise);
        response.sendRedirect("adminExercises");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.getServletContext().getRequestDispatcher("/adminExercisesAdd.jsp").forward(request, response);

    }
}
