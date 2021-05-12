package app.servlet;

import app.bo.Utilisateurs;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        // super.init();

    }

    public ConnexionServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var v = req.getParameter("utilisateur");
        ObjectMapper mapper = new ObjectMapper();
        Utilisateurs user = mapper.readValue(v, Utilisateurs.class);

        HttpSession session = req.getSession();
        session.setAttribute("connectedUser", user);
    }
}
