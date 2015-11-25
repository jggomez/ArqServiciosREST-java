package co.gov.dane.uo.dto;

import co.gov.dane.framework.msg.dto.ContextoRespuestaDTO;
import co.gov.dane.md.usuarios.UsuarioDTO;

public class MsgGetUsuarioPorIdRespDTO {

	private ContextoRespuestaDTO contextoRespuestaDTO;
	private UsuarioDTO usuarioDTO;

	public ContextoRespuestaDTO getContextoRespuestaDTO() {
		return contextoRespuestaDTO;
	}

	public void setContextoRespuestaDTO(
			ContextoRespuestaDTO contextoRespuestaDTO) {
		this.contextoRespuestaDTO = contextoRespuestaDTO;
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}	

}
