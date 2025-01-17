package co.gov.dane.uo.endpoint;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.gov.dane.framework.msg.dto.ContextoRespuestaDTO;
import co.gov.dane.framework.msg.dto.MsgFalloDTO;
import co.gov.dane.framework.msg.util.UtilContexto;
import co.gov.dane.framework.util.Constantes;
import co.gov.dane.framework.util.Errores;
import co.gov.dane.md.usuarios.UsuarioDTO;
import co.gov.dane.uo.delegado.DelegadoNegocios;
import co.gov.dane.uo.delegado.IDelegadoNegocios;
import co.gov.dane.uo.dto.MsgGetTodosUsuariosRespDTO;
import co.gov.dane.uo.dto.MsgGetUsuarioPorIdRespDTO;
import co.gov.dane.uo.dto.MsgInsertarUsuarioRespDTO;
import co.gov.dane.uo.dto.MsgInsertarUsuarioSolDTO;

// Se define la URI /srvs/{modulo}-{sistema}-{subsistema}
@Path("/adminuser")
public class UsuarioEndpoint {
		
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/usuarios")
	public Response getTodos() {			
				
		//log.info("Obteniendo todos los usuarios");	

		MsgGetTodosUsuariosRespDTO msgResp = new MsgGetTodosUsuariosRespDTO();

		try {

			ContextoRespuestaDTO contextResponse = UtilContexto
					.getFillContextResponseDTOBasic("",
							Constantes.ESTADO_EXITOSO);
			msgResp.setContextoRespuestaDTO(contextResponse);

			IDelegadoNegocios delegado = new DelegadoNegocios();
			List<UsuarioDTO> lstUsuarioDTO = delegado.getTodosUsuarios();
			msgResp.setUsuariosDTO(lstUsuarioDTO);

			return Response.status(Constantes.ESTADO_HTTP_OK).entity(msgResp)
					.build();

		} catch (Exception e) {			
			
			MsgFalloDTO msgFallo = UtilContexto.getFillContextFalloDTO("", e,
					Errores.ERROR_SERVER);

			return Response.serverError()
					.status(Constantes.ESTADO_HTTP_INTERNAL_SERVER_ERROR)
					.entity(msgFallo).build();
		}

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/usuarios/{id}")
	public Response getPorId(@PathParam("id") int id) {

		MsgGetUsuarioPorIdRespDTO msgResp = new MsgGetUsuarioPorIdRespDTO();

		try {

			ContextoRespuestaDTO contextResponse = UtilContexto
					.getFillContextResponseDTOBasic("",
							Constantes.ESTADO_EXITOSO);
			msgResp.setContextoRespuestaDTO(contextResponse);

			IDelegadoNegocios delegado = new DelegadoNegocios();
			UsuarioDTO usuarioDTO = delegado.getUsuarioPorId(id);
			msgResp.setUsuarioDTO(usuarioDTO);		

			return Response.ok(Constantes.ESTADO_HTTP_OK).entity(msgResp)
					.build();

		} catch (Exception e) {
			MsgFalloDTO msgFallo = UtilContexto.getFillContextFalloDTO("", e,
					Errores.ERROR_SERVER);

			return Response.serverError()
					.status(Constantes.ESTADO_HTTP_INTERNAL_SERVER_ERROR)
					.entity(msgFallo).build();
		}

	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response eliminar(@PathParam("id") int id) {

		MsgGetUsuarioPorIdRespDTO msgResp = new MsgGetUsuarioPorIdRespDTO();
		
		try {
			
			ContextoRespuestaDTO contextResponse = UtilContexto
					.getFillContextResponseDTOBasic("",
							Constantes.ESTADO_EXITOSO);
			msgResp.setContextoRespuestaDTO(contextResponse);

			IDelegadoNegocios delegado = new DelegadoNegocios();
			delegado.eliminarUsuario(id);

			return Response.ok(msgResp).build();

		} catch (Exception e) {
			MsgFalloDTO msgFallo = UtilContexto.getFillContextFalloDTO("", e,
					Errores.ERROR_SERVER);

			return Response.serverError()
					.status(Constantes.ESTADO_HTTP_INTERNAL_SERVER_ERROR)
					.entity(msgFallo).build();
		}

	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/crear")
	public Response insertar(MsgInsertarUsuarioSolDTO msgSol) {

		MsgInsertarUsuarioRespDTO msgResp = new MsgInsertarUsuarioRespDTO();

		try {

			ContextoRespuestaDTO contextResponse = UtilContexto
					.getFillContextResponseDTOBasic("",
							Constantes.ESTADO_EXITOSO);
			msgResp.setContextoRespuestaDTO(contextResponse);

			IDelegadoNegocios delegado = new DelegadoNegocios();
			UsuarioDTO usuarioDTO = msgSol.getUsuarioDTO();
			int id = delegado.insertarUsuario(usuarioDTO.getNombre(),
					usuarioDTO.getApellido(), usuarioDTO.getCelular(),
					usuarioDTO.getDireccion(), "");
			msgResp.setId(id);			

			return Response.status(Constantes.ESTADO_HTTP_OK).entity(msgResp)
					.build();

		} catch (Exception e) {
			MsgFalloDTO msgFallo = UtilContexto.getFillContextFalloDTO("", e,
					Errores.ERROR_SERVER);			

			return Response.serverError()
					.status(Constantes.ESTADO_HTTP_INTERNAL_SERVER_ERROR)
					.entity(msgFallo).build();
		}

	}

}
