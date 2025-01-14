package com.ammfec;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.ammfec.service.MatrizService;
import com.ammfec.service.PermutationService;
import com.ammfec.service.SodocuService;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes = { ConfigTest.class })
class EjerciciosApplicationTests {
	
	@Autowired
	private MatrizService matrizService;
	
	@Autowired
	private PermutationService permutationService;
	
	@Autowired
	private SodocuService sodocuService;
	

	@Test
	public void matrizSucces() {
		
		String[][] matriz = {
                {"1", "2", "3", "24", "25", "6"},
                {"7", "8", "9", "10", "112", "12"},
                {"13", "14", "15", "16", "172", "18"},
                {"19", "20", "21", "22", "23", "24"}
            };
		
		String[] data= matrizService.matriz(matriz);
		
		assertTrue(data instanceof String[]);
		
	}

	@Test
	public void matrizError() {
		
		String[][] data = null;

		assertNull(matrizService.matriz(data));
		
	}

	@Test
	public void sudocuValid() {
		
		Integer [][] matriz = { 
				{ 5, 3, 4, 6, 7, 8, 9, 1, 2 }, 
				{ 6, 7, 2, 1, 9, 5, 3, 4, 8 },
				{ 1, 9, 8, 3, 4, 2, 5, 6, 7 }, 
				{ 8, 5, 9, 7, 6, 1, 4, 2, 3 }, 
				{ 4, 2, 6, 8, 5, 3, 7, 9, 1 },
				{ 7, 1, 3, 9, 2, 4, 8, 5, 6 }, 
				{ 9, 6, 1, 5, 3, 7, 2, 8, 4 },
				{ 2, 8, 7, 4, 1, 9, 6, 3, 5 },
				{ 3, 4, 5, 2, 8, 6, 1, 7, 9 }
		};

		assertTrue(sodocuService.sodocu(matriz).equals("invalido"));
		
	}

	@Test
	public void sudocuInvalid() {
		
		Integer [][] matriz = { 
				{ 5, 3, 4, 6, 7, 8, 9, 1 }, 
				{ 6, 7, 2, 1, 9, 5, 3, 4 },
				{ 1, 9, 8, 3, 4, 2, 5, 6 }, 
				{ 8, 5, 9, 7, 6, 1, 4, 2 }, 
				{ 4, 2, 6, 8, 5, 3, 7, 9 },
				{ 7, 1, 3, 9, 2, 4, 8, 5 }, 
				{ 9, 6, 1, 5, 3, 7, 2, 8 },
				{ 2, 8, 7, 4, 1, 9, 6, 3 },

		};

		assertTrue(sodocuService.sodocu(matriz).equals("invalido"));
		
	}
	

	@Test
	public void permutaSucces() {
		
		String[] entrada = new String[]{"a","b","c"};	
		assertTrue(permutationService.permutaciones(entrada) instanceof List<String>);
		
	}
	
	@Test
	public void permutaError() {
		
		String[] entrada = null;	
		assertNull(permutationService.permutaciones(entrada));
		
	}

}
