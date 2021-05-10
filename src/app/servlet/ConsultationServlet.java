package app.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/consultation")
public class ConsultationServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        // super.init();

    }

    public ConsultationServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher("/WEB-INF/consultation.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //HttpSession session = req.getSession();
        //        session.setAttribute("no_utilisateur", );
        //this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(req, resp);
    }
}