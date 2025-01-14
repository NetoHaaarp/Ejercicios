package com.ammfec.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class SodocuServiceImp implements SodocuService {
	
	@Override
	public String sodocu(Integer[][] entrada) {
		
		int columnasBase = entrada[0].length;
		int filasBase = entrada.length;
		
		if(entrada ==  null || columnasBase != 9 || filasBase != 9) {
			return "invalido"; 
		}
		
		for(Integer[] enter: entrada) {
			Map<Integer, Integer> filas = new HashMap<>();
			int i = 1;
			for(Integer en: enter) {
				filas.put(en, i);
				i++;
			}
			if(filas.size() != 9) {
				return "invalido"; 
			}
		}
	
		for (Integer i = 0; i < 9; i++) {
			Map<Integer, Integer> columnas = new HashMap<>();
			for (Integer[] enter : entrada) {
				columnas.put(enter[i], i);
			}
			if(columnas.size() != 9) {
				return "invalido"; 
			}
		}
		
		Integer p = 0;
		Integer m = 0;
		Integer h = 0;
		Integer g = 0;
		Integer j = 2;
	    Integer c = 2;
	    
		while (m <= 2) {
			while (p <= 2) {
				Map<Integer, Integer> cuadro = new HashMap<>();
				for (Integer i = h; i <= j; i++) {
					for (Integer a = g; a <= c; a++) {
						 cuadro.put(entrada[i][a], 1);
					}
				}
				if(cuadro.size() != 9) {
					return "invalido"; 
				}
				c = c + 3;
				g = g + 3;
				p++;
			}

			j = j + 3;
			h = h + 3;
			g = 0;
			c = 2;
			p = 0;
			m++;
		}
		
		return "valido";
	}

}
