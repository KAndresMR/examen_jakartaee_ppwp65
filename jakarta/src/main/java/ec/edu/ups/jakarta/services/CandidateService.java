package ec.edu.ups.jakarta.services;


import ec.edu.ups.jakarta.dao.CandidateDAO;
import ec.edu.ups.jakarta.models.Candidate;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Stateless
@Path("/candidates")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CandidateService {

    @Inject
    private CandidateDAO candidateDAO;

    @POST
    public Response createCandidato(Candidate candidate) {
        candidateDAO.save(candidate);
        return Response.status(Response.Status.CREATED).entity("Candidato creado correctamente").build();
        
    }

    @GET
    @Path("/{cedula}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("cedula") String cedula) {
        try {
            Candidate candidate = candidateDAO.findByCedula(cedula);
            if (candidate == null) {
                return Response.status(Response.Status.NOT_FOUND).entity("{\"error\": \"Usuario no encontrado\"}").build();
            }
            return Response.ok(candidate).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("{\"error\": \"Error interno en el servidor: " + e.getMessage() + "\"}").build();
        }
    }
    
}
