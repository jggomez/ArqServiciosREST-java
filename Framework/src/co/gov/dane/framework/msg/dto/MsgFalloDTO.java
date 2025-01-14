package co.gov.dane.framework.msg.dto;

import co.gov.dane.framework.msg.dto.ContextoRespuestaDTO;
import co.gov.dane.framework.msg.dto.FalloDTO;

public class MsgFalloDTO {
	
	private ContextoRespuestaDTO contextoRespuestaDTO;
	private FalloDTO falloDTO;	
		
	public ContextoRespuestaDTO getContextoRespuestaDTO() {
		return contextoRespuestaDTO;
	}

	public void setContextoRespuestaDTO(ContextoRespuestaDTO contextoRespuestaDTO) {
		this.contextoRespuestaDTO = contextoRespuestaDTO;
	}

	public FalloDTO getFalloDTO() {
		return falloDTO;
	}

	public void setFalloDTO(FalloDTO falloDTO) {
		this.falloDTO = falloDTO;
	}

}
