package co.gov.dane.uo.dto;

import co.gov.dane.framework.msg.dto.ContextoRespuestaDTO;

public class MsgInsertarUsuarioRespDTO {

	private ContextoRespuestaDTO contextoRespuestaDTO;
	private int id;

	public ContextoRespuestaDTO getContextoRespuestaDTO() {
		return contextoRespuestaDTO;
	}

	public void setContextoRespuestaDTO(
			ContextoRespuestaDTO contextoRespuestaDTO) {
		this.contextoRespuestaDTO = contextoRespuestaDTO;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
