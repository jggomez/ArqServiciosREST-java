package co.gov.dane.uo.delegado;

import java.util.List;
import co.gov.dane.framework.cache.CacheMg;
import co.gov.dane.md.usuarios.UsuarioDTO;
import co.gov.dane.uo.br.LUsuario;
import co.gov.dane.uo.modelo.Usuario;
import co.gov.dane.uo.transf.UsuarioTransformador;

public class DelegadoNegocios implements IDelegadoNegocios {
		
	private CacheMg obtenerCache() {
		return CacheMg.getInstancia();
	}

	@Override
	public List<UsuarioDTO> getTodosUsuarios() throws Exception {
		LUsuario objLUsuario = new LUsuario();

		// Obtiene de Cache
		List<UsuarioDTO> lstUsuarioDTO = obtenerCache().obtener("USUARIOS");

		if (lstUsuarioDTO != null) {
			return lstUsuarioDTO;
		}

		List<Usuario> lstUsuario = objLUsuario.getTodos();

		// Transforma el usuario a DTO
		UsuarioTransformador objUsuTransf = new UsuarioTransformador();
		lstUsuarioDTO = objUsuTransf.transformListDTO(lstUsuario);

		// Obtiene de cache
		obtenerCache().insertar("USUARIOS", lstUsuarioDTO);

		return lstUsuarioDTO;
	}

	@Override
	public UsuarioDTO getUsuarioPorId(int id) throws Exception {
		LUsuario objLUsuario = new LUsuario();

		Usuario usuario = objLUsuario.getPorId(id);

		// usar cache

		// Transforma el usuario a DTO
		UsuarioTransformador objUsuTransf = new UsuarioTransformador();
		UsuarioDTO usuarioDTO = objUsuTransf.transformDTO(usuario);

		return usuarioDTO;
	}

	@Override
	public void eliminarUsuario(int id) throws Exception {
		LUsuario objLUsuario = new LUsuario();
		objLUsuario.eliminar(id);
		obtenerCache().eliminar("USUARIOS");
	}

	@Override
	public int insertarUsuario(String nombres, String apellidos,
			String celular, String direccion, String fechaNac) throws Exception {
		LUsuario objLUsuario = new LUsuario();
		
		obtenerCache().eliminar("USUARIOS");

		return objLUsuario.insertar(nombres, apellidos, celular, direccion,
				fechaNac);		
		
	}

}
