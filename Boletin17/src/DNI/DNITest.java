package DNI;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class DNITest {

	@Test
	public void testEValidoString() {
		DNI dni = new DNI();
		
		//metemos os tras validos
		assertTrue(dni.eValido("09667730W"));
		assertTrue(dni.eValido("90500394V"));
		assertTrue(dni.eValido("23669270Q"));
		assertTrue(dni.eValido("09667730w"));
		assertTrue(dni.eValido("90500394v"));
		assertTrue(dni.eValido("23669270q"));
		
		//metemos 3 con mal calculo da letra
		assertFalse(dni.eValido("09667730S"));
		assertFalse(dni.eValido("90500394T"));
		assertFalse(dni.eValido("23669270A"));
		
		//metemos alguns que non teñen o formato valido de dni
		assertFalse(dni.eValido("667730S"));
		assertFalse(dni.eValido("90A00394"));
		assertFalse(dni.eValido("A23669270"));
		assertFalse(dni.eValido("23669270"));
		assertFalse(dni.eValido("asdfsad"));
		assertFalse(dni.eValido("123456789T"));
	}

	@Test
	public void testCalculaLetraString() {
		DNI dni = new DNI();
		
		assertEquals('W',dni.calculaLetra("09667730"));
		assertEquals('V',dni.calculaLetra("90500394"));
		assertEquals('Q',dni.calculaLetra("23669270"));
		
		//metemos alguns que non teñen o formato valido de dni
		assertEquals(-1,dni.calculaLetra("23669270Q"));
		assertEquals(-1,dni.calculaLetra("667730"));
		assertEquals(-1,dni.calculaLetra("90A00394"));
		assertEquals(-1,dni.calculaLetra("A23669270"));
		assertEquals(-1,dni.calculaLetra("asdfsad"));
		assertEquals(-1,dni.calculaLetra("123456789T"));
	}

	@Test
	public void testEValidoArrayListOfIntegerChar() {
		DNI dni = new DNI();
		
		Integer[] array1 = new Integer[] {0,9,6,6,7,7,3,0}; 
		ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(array1));
		Integer[] array2 = new Integer[] {9,0,5,0,0,3,9,4}; 
		ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(array2));
		Integer[] array3 = new Integer[] {1,2,3,4,5,6,7,8,9}; 
		ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(array3));
		Integer[] array4 = new Integer[] {2,9,6,6,7,10,0}; 
		ArrayList<Integer> list4 = new ArrayList<>(Arrays.asList(array4));
		Integer[] array5 = new Integer[] {2,9,6,-1,7,10,0}; 
		ArrayList<Integer> list5 = new ArrayList<>(Arrays.asList(array5));
		
		assertTrue(dni.eValido(list1,'W'));
		assertTrue(dni.eValido(list1,'w'));
		assertTrue(dni.eValido(list2,'V'));
		assertTrue(dni.eValido(list2,'v'));
		
		assertFalse(dni.eValido(list1,'T'));
		assertFalse(dni.eValido(list2,'A'));
		assertFalse(dni.eValido(list3,'C'));
		assertFalse(dni.eValido(list4,'m'));
		assertFalse(dni.eValido(list5,'K'));
		
	}

	@Test
	public void testCalculaLetraArrayListOfInteger() {
		DNI dni = new DNI();
		
		Integer[] array1 = new Integer[] {0,9,6,6,7,7,3,0}; 
		ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(array1));
		Integer[] array2 = new Integer[] {9,0,5,0,0,3,9,4}; 
		ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(array2));
		Integer[] array3 = new Integer[] {1,2,3,4,5,6,7,8,9}; 
		ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(array3));
		Integer[] array4 = new Integer[] {2,9,6,6,7,10,0}; 
		ArrayList<Integer> list4 = new ArrayList<>(Arrays.asList(array4));
		Integer[] array5 = new Integer[] {2,9,6,-1,7,10,0}; 
		ArrayList<Integer> list5 = new ArrayList<>(Arrays.asList(array5));
		
		assertEquals('W', dni.calculaLetra(list1));
		assertEquals('V', dni.calculaLetra(list2));
		assertEquals(-1, dni.calculaLetra(list3));
		assertEquals(-1, dni.calculaLetra(list4));
		assertEquals(-1, dni.calculaLetra(list5));
	}

}
