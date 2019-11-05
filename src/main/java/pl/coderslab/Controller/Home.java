package pl.coderslab.Controller;

import pl.coderslab.Dao.ExerciseDao;
import pl.coderslab.Dao.SolutionDao;
import pl.coderslab.Dao.UserDao;
import pl.coderslab.Model.Exercise;
import pl.coderslab.Model.Solution;
import pl.coderslab.Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class Home extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SolutionDao solutionDao = new SolutionDao();
        UserDao userDao = new UserDao();
        ExerciseDao exerciseDao = new ExerciseDao();
        int noOfrecentSolutions = Integer.parseInt(getServletContext().getInitParameter("numberOfRecentSolutions"));
        Solution[] recentSolutions = solutionDao.findRecent(noOfrecentSolutions);
        User[] solutionsUsers = new User[noOfrecentSolutions];
        Exercise[] solutionsExercises = new Exercise[noOfrecentSolutions];

        for (int i = 0; i < noOfrecentSolutions; i++) {
            solutionsUsers[i] = userDao.read(recentSolutions[i].getUsers_id());
            solutionsExercises[i] = exerciseDao.read(recentSolutions[i].getExercise_id());
        }

        request.setAttribute("recentSolutions", recentSolutions);
        request.setAttribute("solutionsUsers", solutionsUsers);
        request.setAttribute("solutionsExercises", solutionsExercises);
        request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

    }
}
