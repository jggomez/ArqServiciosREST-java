package co.gov.dane.uo.br;

import java.util.ArrayList;
import java.util.List;
import co.gov.dane.uo.modelo.Usuario;

public class LUsuario {

	//private UsuarioDAO usuarioDAO;
	private static List<Usuario> lstUsuarios = null;

	public LUsuario() {
		//usuarioDAO = new UsuarioDAO();
		init();
	}
	
	private void init(){
		
		if (lstUsuarios == null) {
			
			lstUsuarios = new ArrayList<Usuario>();

			Usuario usuario = new Usuario();
			usuario.setNombres("Juan Guillermo");
			usuario.setApellidos("Gomez Torres");
			usuario.setCelular("317449844");
			usuario.setDireccion("Cr 56 #45");
			usuario.setFechaNacimiento("21/08/1990");
			usuario.setId(1);

			lstUsuarios.add(usuario);

			usuario = new Usuario();
			usuario.setNombres("Juan Carlos");
			usuario.setApellidos("Paz");
			usuario.setCelular("317444444");
			usuario.setDireccion("Cr 56 #45");
			usuario.setFechaNacimiento("12/10/1996");
			usuario.setId(2);

			lstUsuarios.add(usuario);

			usuario = new Usuario();
			usuario.setNombres("Carlos");
			usuario.setApellidos("Perez");
			usuario.setCelular("317555555");
			usuario.setDireccion("Cr 89 #45");
			usuario.setFechaNacimiento("21/08/2011");
			usuario.setId(3);

			lstUsuarios.add(usuario);
		}
						
	}

	public List<Usuario> getTodos() {
		
		// Se obtiene del DAO
		//List<Usuario> lstUsuarios = usuarioDAO.findAll();
		
		// Para el ejemplo se crean		
		
		return lstUsuarios;

	}
	
	public Usuario getPorId(int id) {
		try {
			
			for (Usuario usu : lstUsuarios) {
				if(usu.getId() == id){
					return usu;
				}
			}
			
			return null;
			
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	public void eliminar(int id) {
		try {
			
			for (Usuario usu : lstUsuarios) {
				if(usu.getId() == id){
					lstUsuarios.remove(usu);
					break;
				}
			}					
			
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	public int insertar(String nombres, String apellidos, String celular, String direccion, String fechaNac) {
		try {
			
			Usuario usuario = new Usuario();
			usuario.setNombres(nombres);
			usuario.setApellidos(apellidos);
			usuario.setCelular(celular);
			usuario.setDireccion(direccion);
			usuario.setFechaNacimiento(fechaNac);
			
			lstUsuarios.add(usuario);
			
			// retorna el id 
			return 3;
			
		} catch (Exception e) {
			throw e;
		}
		
	}

}
