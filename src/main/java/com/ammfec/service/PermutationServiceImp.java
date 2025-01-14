package com.ammfec.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PermutationServiceImp implements PermutationService {
	
	@Override
	public List<String> permutaciones(String[] entrada) {
		List<String> permutations = new ArrayList<>();
		if(entrada == null || entrada.length == 0) {
			return null;
		}
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
