package co.gov.dane.uo.delegado;

import java.util.List;

import co.gov.dane.md.usuarios.UsuarioDTO;

public interface IDelegadoNegocios {
	
	public List<UsuarioDTO> getTodosUsuarios() throws Exception;	
	
	public UsuarioDTO getUsuarioPorId(int id) throws Exception;
	
	public void eliminarUsuario(int id) throws Exception;
	
	public int insertarUsuario(String nombres, String apellidos, String celular, String direccion, String fechaNac) throws Exception;

}
