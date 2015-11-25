package co.gov.dane.framework.msg.dto;

public class FalloDTO {
	
	private String codigo;
	private String mensaje;
	private String descripcion;
	private ErrorDTO[] errores;	

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ErrorDTO[] getErrores() {
		return errores;
	}

	public void setErrores(ErrorDTO[] errores) {
		this.errores = errores;
	}

}
