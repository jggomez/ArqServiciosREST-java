package co.gov.dane.framework.msg.dto;

import java.util.Date;

public class ContextoRespuestaDTO {

	private String idTransaccion;
	private String codEstado;
	private Date fechatx;

	public String getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public String getCodEstado() {
		return codEstado;
	}

	public void setCodEstado(String codEstado) {
		this.codEstado = codEstado;
	}

	public Date getFechatx() {
		return fechatx;
	}

	public void setFechatx(Date fechatx) {
		this.fechatx = fechatx;
	}

}
