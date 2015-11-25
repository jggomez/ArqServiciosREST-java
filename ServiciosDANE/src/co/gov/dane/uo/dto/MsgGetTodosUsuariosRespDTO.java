package co.gov.dane.uo.dto;

import java.util.List;

import co.gov.dane.framework.msg.dto.ContextoRespuestaDTO;
import co.gov.dane.md.usuarios.UsuarioDTO;

public class MsgGetTodosUsuariosRespDTO {

	private ContextoRespuestaDTO contextoRespuestaDTO;
	private List<UsuarioDTO> usuariosDTO;

	public ContextoRespuestaDTO getContextoRespuestaDTO() {
		return contextoRespuestaDTO;
	}

	public void setContextoRespuestaDTO(
			ContextoRespuestaDTO contextoRespuestaDTO) {
		this.contextoRespuestaDTO = contextoRespuestaDTO;
	}

	public List<UsuarioDTO> getUsuariosDTO() {
		return usuariosDTO;
	}

	public void setUsuariosDTO(List<UsuarioDTO> usuariosDTO) {
		this.usuariosDTO = usuariosDTO;
	}

}
