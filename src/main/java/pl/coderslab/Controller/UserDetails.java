package pl.coderslab.Controller;

import pl.coderslab.Dao.ExerciseDao;
import pl.coderslab.Dao.SolutionDao;
import pl.coderslab.Dao.UserDao;
import pl.coderslab.Dao.UserGroupDao;
import pl.coderslab.Model.Exercise;
import pl.coderslab.Model.Solution;
import pl.coderslab.Model.User;
import pl.coderslab.Model.UserGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/userDetails")
public class UserDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userId = Integer.parseInt(request.getParameter("id"));
        UserDao userDao = new UserDao();
        User user = userDao.read(userId);

        SolutionDao solutionDao = new SolutionDao();
        Solution[] solutions = solutionDao.findAllByUserId(user.getId());

        Exercise[] exercises = new Exercise[0];
        ExerciseDao exerciseDao = new ExerciseDao();

        for (Solution solution : solutions) {
            exercises = Arrays.copyOf(exercises, exercises.length + 1);
            exercises[exercises.length-1] = exerciseDao.read(solution.getExercise_id());
        }

        request.setAttribute("user", user);
        request.setAttribute("solutions", solutions);
        request.setAttribute("exercises", exercises);
        request.getServletContext().getRequestDispatcher("/userDetails.jsp").forward(request, response);

    }
}
