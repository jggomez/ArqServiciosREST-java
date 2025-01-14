package co.gov.dane.framework.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class CacheMg {

	private static CacheMg instancia = null;
	private static CacheManager cm;
	private static Cache cache = null;

	private CacheMg() {
	}

	public static CacheMg getInstancia() {

		if (instancia == null) {
			instancia = new CacheMg();
			cm = CacheManager.getInstance();
			cm.addCache("cache1");
			cache = cm.getCache("cache1");
		}

		return instancia;

	}

	public void insertar(String llave, Object valor) {
		cache.put(new Element(llave, valor));
	}

	@SuppressWarnings("unchecked")
	public <T> T obtener(String llave) {
		Element elem = cache.get(llave);
		if (elem != null) {
			Object object = elem.getObjectValue();
			if (object != null) {
				return (T) object;
			}
		}

		return null;
	}

	public void eliminar(String llave) {
		cache.remove(llave);
	}

}
