package app.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/deconnexion")
public class DeconnexionServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        // super.init();

    }

    public DeconnexionServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();

        this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(req, resp);
    }


}
