package co.gov.dane.uo.dao;

import javax.persistence.EntityManager;

import co.gov.dane.uo.dao.util.EntityManagerHelper;
import co.gov.dane.uo.dao.util.JpaDaoImpl;
import co.gov.dane.uo.modelo.Usuario;

public class UsuarioDAO extends JpaDaoImpl<Usuario, Integer> implements
		IUsuarioDAO {

	@SuppressWarnings("unused")
	private EntityManager em;

	public UsuarioDAO() {
		super();
		em = EntityManagerHelper.getEntityManager();
	}	

}
