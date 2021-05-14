package app.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/article/*")
public class ArticleServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        // super.init();

    }

    int isCorrectPath(String url){
        String path = "article/";
        String idText= url.substring(url.lastIndexOf(path) + path.length());
        try{
            int id = Integer.parseInt(idText);
            return id;
        }
        catch (Exception e){
            throw e;
        }


    }

    public ArticleServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = isCorrectPath(((HttpServletRequest) req).getRequestURL().toString());
            req.setAttribute("id", id);
            this.getServletContext().getRequestDispatcher("/WEB-INF/consultation-article.jsp").forward(req, resp);
        }
        catch (Exception e){
            resp.sendError(404);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        this.getServletContext().getRequestDispatcher("/WEB-INF/consultation-article.jsp").forward(req, resp);
    }
}
