package org.puclab.controllers;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.puclab.models.dtos.UsuarioDTO;
import org.puclab.services.SecretariaService;
import org.puclab.services.UsuarioService;

@Path("/usuario")

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioController {

    private final UsuarioService usuarioService;

    private final SecretariaService secretariaService;

    public UsuarioController(UsuarioService usuarioService, SecretariaService secretariaService) {
        this.usuarioService = usuarioService;
        this.secretariaService = secretariaService;
    }

    @GET
    public Response findAll(@QueryParam("page") @DefaultValue("0") Integer page,
                            @QueryParam("pageSize") @DefaultValue("10") Integer pageSize) {
        var usuarios = secretariaService.findAll(page, pageSize);
        return Response.ok().entity(usuarios).build();
    }

    @POST
    @Transactional
    public Response criarUsuario(UsuarioDTO usuarioDTO) {
        return Response.ok().entity(secretariaService.criarUsuario(usuarioDTO)).build();
    }

    @GET
    @Path("/{id}/tipo")
    public Response getTipoUsuario(@PathParam("id") long id) {
        return Response.ok().entity(usuarioService.getTipoUsuario(id)).build();
    }
}
