package com.ammfec.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class MatrizServiceImp implements MatrizService {

	@Override
	public String[] matriz(String[][] entrada) {
		
		if(entrada == null || entrada[0].length == 0 || entrada.length == 0) {
			String[] response = null;
			return response;
		}

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

}
