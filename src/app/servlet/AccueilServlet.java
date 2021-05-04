package app.servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class AccueilServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        // super.init();




    }

    public AccueilServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(req, resp);
    }
}
