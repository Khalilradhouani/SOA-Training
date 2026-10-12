package webservices;

import entities.UniteEnseignement;
import metiers.UniteEnseignementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/ue")

public class UniteEnsRestApi {
    //helper:instance that will help this class to manipulate data : crud
    static UniteEnseignementBusiness helper= new UniteEnseignementBusiness();
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
    @Path("/new")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createUe(UniteEnseignement unite){
        if ( helper.addUniteEnseignement(unite)){
            return Response.status(201).entity("ok").build();
        }
        else {
            return Response.status(400).entity("error").build();
        }

    }
    @Path("/{inputCode}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getUeByCode(@PathParam("inputCode") int code){
        return Response.ok(helper.getUEByCode(code)).build();
    }
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getUeBySemestre(@QueryParam("semestre") int semestre){
        return Response.ok(helper.getUEBySemestre(semestre)).build();
    }
    @Path("/delete")
    @DELETE
    public Response deleteByCode(@QueryParam("code") int code){
        if(helper.deleteUniteEnseignement(code)){
            return Response.status(200).entity("ok").build();
        }
        else return Response.status(400).entity("error").build();
    }

}
