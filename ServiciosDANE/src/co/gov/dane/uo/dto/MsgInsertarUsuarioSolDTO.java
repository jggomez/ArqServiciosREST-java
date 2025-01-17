package co.gov.dane.uo.dto;

import co.gov.dane.framework.msg.dto.ContextoSolicitudDTO;
import co.gov.dane.md.usuarios.UsuarioDTO;

public class MsgInsertarUsuarioSolDTO {

	private ContextoSolicitudDTO contextoSolicitudDTO;
	private UsuarioDTO usuarioDTO;

	public ContextoSolicitudDTO getContextoSolicitudDTO() {
		return contextoSolicitudDTO;
	}

	public void setContextoSolicitudDTO(
			ContextoSolicitudDTO contextoSolicitudDTO) {
		this.contextoSolicitudDTO = contextoSolicitudDTO;
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

}
