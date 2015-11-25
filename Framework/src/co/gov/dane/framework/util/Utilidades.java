package co.gov.dane.framework.util;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Utilidades {
	
	public static <T> String convertirAJson(T msg){
		Gson gson = new GsonBuilder().create();
		Type tipoMsg = new TypeToken<T>(){}.getType();
		String json = gson.toJson(msg, tipoMsg);
		return json;		
	}		

}