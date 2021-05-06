package app.filter;

import app.bo.Utilisateurs;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/api/utilisateur/suppression/*")
public class ApiFilter  implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try{
          int id =   isCorrectPath(((HttpServletRequest)servletRequest).getRequestURL().toString());
            HttpServletResponse resp = (HttpServletResponse)servletResponse;
            HttpServletRequest req = (HttpServletRequest) servletRequest;

            Utilisateurs user  = (Utilisateurs) req.getSession().getAttribute("connectedUser");

            if( user.getNo_utilisateur() == id || user.isAdministrateur()){ /// Si l'utilisateur connecté est celui supprimé ou si l'utilisateur connecté est administrateur
               filterChain.doFilter(servletRequest, servletResponse);
               if(user.getNo_utilisateur() == id){
                   req.getSession().invalidate();
               }
            }


        }
        catch (Exception e){

        }

       }

    int isCorrectPath(String url){
        String path = "suppression/";
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
