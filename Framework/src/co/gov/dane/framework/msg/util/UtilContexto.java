package co.gov.dane.framework.msg.util;

import java.util.Date;

import co.gov.dane.framework.msg.dto.ContextoRespuestaDTO;
import co.gov.dane.framework.msg.dto.ContextoSolicitudDTO;
import co.gov.dane.framework.msg.dto.ErrorDTO;
import co.gov.dane.framework.msg.dto.FalloDTO;
import co.gov.dane.framework.msg.dto.MsgFalloDTO;
import co.gov.dane.framework.util.Constantes;

public class UtilContexto {

	public static ContextoRespuestaDTO getFillContextResponseDTOBasic(
			ContextoSolicitudDTO request, String estado) {

		ContextoRespuestaDTO contextResponse = new ContextoRespuestaDTO();
		contextResponse.setIdTransaccion(request.getIdTransaccion());
		contextResponse.setFechatx(new Date());
		contextResponse.setCodEstado(estado);

		return contextResponse;

	}

	public static ContextoRespuestaDTO getFillContextResponseDTOBasic(
			String idTransaction, String estado) {

		ContextoRespuestaDTO contextResponse = new ContextoRespuestaDTO();
		contextResponse.setIdTransaccion(idTransaction);
		contextResponse.setFechatx(new Date());
		contextResponse.setCodEstado(estado);

		return contextResponse;

	}

	public static MsgFalloDTO getFillContextFalloDTO(String idTransaction,
			Exception e, String codError) {	
		
		MsgFalloDTO msgFallo = new MsgFalloDTO();
		
		ContextoRespuestaDTO contextResponse = getFillContextResponseDTOBasic("", Constantes.ESTADO_FALLIDO);
		msgFallo.setContextoRespuestaDTO(contextResponse);

		FalloDTO falloDTO = new FalloDTO();		
		falloDTO.setCodigo(codError);
		falloDTO.setMensaje(e.getMessage());
		falloDTO.setDescripcion(e.getMessage());
		msgFallo.setFalloDTO(falloDTO);

		return msgFallo;

	}

	public static MsgFalloDTO getFillContextFalloDTO(String idTransaction,
			Exception e, String codError, String descripcionError) {
		
		MsgFalloDTO msgFallo = new MsgFalloDTO();
		
		ContextoRespuestaDTO contextResponse = getFillContextResponseDTOBasic("", Constantes.ESTADO_FALLIDO);
		msgFallo.setContextoRespuestaDTO(contextResponse);
		
		FalloDTO falloDTO = new FalloDTO();		
		falloDTO.setCodigo(codError);
		falloDTO.setMensaje(e.getMessage());
		falloDTO.setDescripcion(descripcionError);
		msgFallo.setFalloDTO(falloDTO);

		return msgFallo;

	}

	public static MsgFalloDTO getFillContextFalloDTO(String idTransaction,
			Exception e, String codError, String descripcionError,
			ErrorDTO[] errores) {
		
		MsgFalloDTO msgFallo = new MsgFalloDTO();
		
		ContextoRespuestaDTO contextResponse = getFillContextResponseDTOBasic("", Constantes.ESTADO_FALLIDO);
		msgFallo.setContextoRespuestaDTO(contextResponse);

		FalloDTO falloDTO = new FalloDTO();		
		falloDTO.setCodigo(codError);
		falloDTO.setMensaje(e.getMessage());
		falloDTO.setDescripcion(descripcionError);
		falloDTO.setErrores(errores);
		msgFallo.setFalloDTO(falloDTO);

		return msgFallo;

	}

}
