package pl.coderslab.Controller;

import pl.coderslab.Dao.ExerciseDao;
import pl.coderslab.Model.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminExercisesEdit")
public class AdminExercisesEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int exerciseId = Integer.parseInt(request.getParameter("exerciseId"));
        String exerciseTitle = request.getParameter("exerciseTitle");
        String exerciseDescription = request.getParameter("exerciseDescription");

        ExerciseDao exerciseDao = new ExerciseDao();
        Exercise exercise = new Exercise();
        exercise.setId(exerciseId);
        exercise.setTitle(exerciseTitle);
        exercise.setDescription(exerciseDescription);
        exerciseDao.update(exercise);
        response.sendRedirect("adminExercises");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int exerciseId = Integer.parseInt(request.getParameter("id"));
        ExerciseDao exerciseDao = new ExerciseDao();
        Exercise exercise = exerciseDao.read(exerciseId);
        request.setAttribute("exercise", exercise);
        request.getServletContext().getRequestDispatcher("/adminExercisesEdit.jsp").forward(request, response);

    }
}
