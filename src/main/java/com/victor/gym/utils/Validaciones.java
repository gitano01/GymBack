package com.victor.gym.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validaciones {

	public Validaciones() {};
		
		public boolean  validaNumero(String id) {
			
			Pattern p = Pattern.compile("^[0-9]+$");
			Matcher m = p.matcher(id);
			
			boolean b = m.matches(); // devuelve verdadero
			return b;
		}
	
	 
	
	
}
