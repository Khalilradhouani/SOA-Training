package webservices;

import metiers.UniteEnseignementBusiness;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/ue")

public class UniteEnsRestApi {
    //heper:instance that will help this class to manipulate data : crud
    UniteEnseignementBusiness helper= new UniteEnseignementBusiness();
    //get List UEs
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListUE(){

        return Response
                .status(200)
                .entity(helper.getListeUE())
                .build();
    }
}
