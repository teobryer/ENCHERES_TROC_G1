package app.service;

import app.bll.BusinessException;
import app.bll.ManagerFactory;
import app.bo.Categories;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/categories")
public class GestionCategorieService {

    @GET
    public Response getCategories() throws Exception {

        Response response;
        try {
            List<Categories> categories = ManagerFactory.categoriesManager().recupererCategories();
            response= Response.ok().entity(categories).build();
        }catch (BusinessException e) {
            response=Response.status(404).entity(e).build();
            return response;
            }
        return response;
    }
}
