package webservices;

import entities.Module;
import metiers.ModuleBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/module")

public class ModuleRestApi{
    static ModuleBusiness helper= new ModuleBusiness();
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListModule() {
        return Response
                .status(200)
                .entity(helper.getAllModules())
                .build();
    }
    @Path("/new")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createModule(Module module) {
        if (helper.addModule(module)) {
            return Response.status(201).entity("ok").build();}
        else {
            return Response.status(400).entity("error").build();
            }
        }
    @Path("/{inputMatricule}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getModuleByMatricule(@PathParam("inputMatricule") String matricule){
        return Response.ok(helper.getModuleByMatricule(matricule)).build();
    }
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getModulesByType(@QueryParam("type") Module.TypeModule type){
        return Response.ok(helper.getModulesByType(type)).build();
    }
}
