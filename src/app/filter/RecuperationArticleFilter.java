package app.filter;

import app.bo.Utilisateurs;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter("/api/articles/*")
public class RecuperationArticleFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try{
            int id =   isCorrectPath(((HttpServletRequest)servletRequest).getRequestURL().toString());
            HttpServletResponse resp = (HttpServletResponse)servletResponse;
            HttpServletRequest req = (HttpServletRequest) servletRequest;
            HttpSession session =  req.getSession(false);
            Utilisateurs user  = (Utilisateurs) session.getAttribute("connectedUser");

            if( user.getNo_utilisateur() == id || user.isAdministrateur()){ /// Si l'utilisateur connecté est celui supprimé ou si l'utilisateur connecté est administrateur
                filterChain.doFilter(servletRequest, servletResponse);
                if(user.getNo_utilisateur() == id){
                    req.getSession().invalidate();
                }
            }


        }
        catch (Exception e){
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    int isCorrectPath(String url){
        String path = "/api/articles/";
        String idText= url.substring(url.lastIndexOf(path) + path.length());
        try{
            int id = Integer.parseInt(idText);
            return id;
        }
        catch (Exception e){
            throw e;
        }


    }

    @Override
    public void destroy() {
    }
}
