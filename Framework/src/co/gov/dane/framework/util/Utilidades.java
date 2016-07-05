package co.gov.dane.framework.util;

import java.lang.reflect.Type;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Utilidades {
		
	@Inject
	private transient Logger logger;	
	
	public static <T> String convertirAJson(T msg){
		Gson gson = new GsonBuilder().create();
		Type tipoMsg = new TypeToken<T>(){}.getType();
		String json = gson.toJson(msg, tipoMsg);
		return json;		
	}
		
	public void printErrorLogger(String mensaje){
		logger.error(mensaje);
	}
	
	public void printInfoLogger(String mensaje){
		Logger logger = Logger.getLogger(this.getClass());
		logger.info("Error -> " + mensaje);
	}

}
