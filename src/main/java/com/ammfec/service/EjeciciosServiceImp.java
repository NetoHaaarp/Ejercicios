package com.ammfec.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class EjeciciosServiceImp implements EjeciciosService {

	@Override
	public String[] matriz(String[][] entrada) {

		int c = entrada[0].length;
		int f= entrada.length;

		String[] areglo = new String[c*f];
		int position = 0;

		Map<String, String> mapMatriz = new HashMap<>();
		
		Integer fila = 0;
		for(String[] entradaFilas: entrada) {
			Integer columna = 0;
			for(String entradaColumnas: entradaFilas) {
				mapMatriz.put(fila+"-"+columna, entradaColumnas);
				columna++;
		    }
			fila++;
		}
		
		int filaMain = 0;
		int fila2 = 0;
		int incremento = 0;
		
		while (mapMatriz.size() > 0) {

			for (int j = incremento; j < c; j++) {
				if (mapMatriz.size() > 0) {
					areglo[position] = entrada[filaMain][j];
					position++;
					mapMatriz.remove(filaMain + "-" + j);
				}
			}

			filaMain++;

			for (; filaMain < f; filaMain++) {
				if (mapMatriz.size() > 0) {
					areglo[position] = entrada[filaMain][c - 1];
					position++;
					mapMatriz.remove(filaMain + "-" + (c - 1));
				}
			}

			filaMain--;

			for (int j = c - 2; j >= 0; j--) {
				if (mapMatriz.size() > 0) {
					areglo[position] = entrada[filaMain][j];
					position++;
					mapMatriz.remove(filaMain + "-" + j);
				}
			}

			filaMain--;

			for (; filaMain > fila2; filaMain--) {
				if (mapMatriz.size() > 0) {
					areglo[position] = entrada[filaMain][fila2];
					position++;
					mapMatriz.remove(filaMain + "-" + fila2);
				}
			}

			f--;
			c--;
			filaMain++;
			fila2++;
			incremento++;
		}
		
		return areglo;
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
	
	@Override
	public List<String> permutaciones(String[] entrada) {
		List<String> permutations = new ArrayList<>();
		permutando(entrada, 0, permutations);
		return permutations;
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
