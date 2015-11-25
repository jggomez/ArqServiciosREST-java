package co.gov.dane.uo.transf;

import co.gov.dane.framework.transf.AdaptadorBase;
import co.gov.dane.md.usuarios.UsuarioDTO;
import co.gov.dane.uo.modelo.Usuario;

public class UsuarioTransformador extends AdaptadorBase<UsuarioDTO, Usuario> {

	@Override
	public UsuarioDTO transformDTO(Usuario model) {

		UsuarioDTO objUsuarioDTO = new UsuarioDTO();

		if (model != null) {

			objUsuarioDTO.setNombre(model.getNombres());
			objUsuarioDTO.setApellido(model.getApellidos());
			objUsuarioDTO.setCelular(model.getCelular());
			objUsuarioDTO.setDireccion(model.getDireccion());
			
		}

		return objUsuarioDTO;
	}

	@Override
	public Usuario transformModel(UsuarioDTO dto) {

		Usuario objUsuario = new Usuario();

		if (dto != null) {

			objUsuario.setNombres(dto.getNombre());
			objUsuario.setApellidos(dto.getApellido());
			objUsuario.setCelular(dto.getCelular());
			objUsuario.setDireccion(dto.getDireccion());			

		}

		return objUsuario;
	}

}

