package com.ammfec.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class EjeciciosServiceImp implements EjeciciosService {

	@Override
	public List<String> permutaciones(String[] entrada) {
		List<String> permutations = new ArrayList<>();
		permutando(entrada, 0, permutations);
		return permutations;
	}

	@Override
	public List<String> matriz(String[][] entrada) {
		   int[][] matriz = {
		            {1, 2, 3, 4, 5, 6},
		            {7, 8, 9, 10, 11, 12},
		            {13, 14, 15, 16, 17, 18},
		            {19, 20, 21, 22, 23, 24}
		        };

		int columnasBase = matriz[0].length;
		int filasBase = matriz.length;


		System.out.println("columna: "+columnasBase);
		System.out.println("fila: "+filasBase);

		int[] areglo = new int[columnasBase*filasBase];
		int position = 0;

		Map<String, String> mapMatriz = new HashMap<>();
		
		/*
		for(){
			
		}
*/
		
		for (int i = 0; i < areglo.length; i++) {
			System.out.println(areglo[i]); // Imprime cada valor
		}

		return null;
	}

	@Override
	public String sodocu(Integer[][] entrada) {
		
		int columnasBase = entrada[0].length;
		int filasBase = entrada.length;
		
		if(columnasBase != 9 && filasBase != 9) {
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
				for (Integer i = h; i <= j; i++) {
					Map<Integer, Integer> cuadro = new HashMap<>();
					for (Integer a = g; a <= c; a++) {
						 cuadro.put(entrada[i][j], 1);
					}
					if(cuadro.size() != 9) {
						return "invalido"; 
					}
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

	public void permutando(String[] entrada, Integer comienzo, List<String> permutations) {
		if (comienzo == entrada.length - 1) {
			permutations.add(String.join("", entrada));
			return;
		}

		for (int i = comienzo; i < entrada.length; i++) {
			intercambio(entrada, comienzo, i); 
			permutando(entrada, comienzo + 1, permutations); 
			intercambio(entrada, comienzo, i); 
		}
	}

	public void intercambio(String[] entrada, Integer i, Integer j) {
		String temporal = entrada[i];
		entrada[i] = entrada[j];
		entrada[j] = temporal;
	}

}
