package Xeometria;

import static org.junit.Assert.*;

import org.junit.Test;

public class XeometriaTest {

	@Test
	public void testPerimetroCadrado() {
		Xeometria xeometria = new Xeometria();
		assertEquals(8, xeometria.perimetroCadrado(2));
		assertEquals(24, xeometria.perimetroCadrado(6));
		assertEquals(-1, xeometria.perimetroCadrado(0));
		assertEquals(-1, xeometria.perimetroCadrado(-2));
	}

	@Test
	public void testAreaCadrado() {
		Xeometria xeometria = new Xeometria();
		assertEquals(4, xeometria.areaCadrado(2));
		assertEquals(36, xeometria.areaCadrado(6));
		assertEquals(-1, xeometria.areaCadrado(0));
		assertEquals(-1, xeometria.areaCadrado(-2));
	}

	@Test
	public void testTeoremaPitagorasIntInt() {
		Xeometria xeometria = new Xeometria();
		assertEquals(5, xeometria.teoremaPitagoras(4,3),0.001);
		assertEquals(5, xeometria.teoremaPitagoras(3,4),0.001);
		assertEquals(-1, xeometria.teoremaPitagoras(0,4),0.001);
		assertEquals(-1, xeometria.teoremaPitagoras(-2,4),0.001);
		assertEquals(-1, xeometria.teoremaPitagoras(3,0),0.001);
		assertEquals(-1, xeometria.teoremaPitagoras(3,-4),0.001);
		assertEquals(-1, xeometria.teoremaPitagoras(0,0),0.001);
		assertEquals(-1, xeometria.teoremaPitagoras(-3,-4),0.001);
	}

	@Test
	public void testTeoremaPitagorasDoubleDouble() {
		Xeometria xeometria = new Xeometria();
		assertEquals(4, xeometria.teoremaPitagoras(5.0,3.0),0.001);
		assertEquals(-1, xeometria.teoremaPitagoras(3.0,5.0),0.001);
		assertEquals(-1, xeometria.teoremaPitagoras(0.0,5.0),0.001);
		assertEquals(-1, xeometria.teoremaPitagoras(-3.0,5.0),0.001);
		assertEquals(-1, xeometria.teoremaPitagoras(3.0,0.0),0.001);
		assertEquals(-1, xeometria.teoremaPitagoras(3.0,-5.0),0.001);
		assertEquals(-1, xeometria.teoremaPitagoras(0.0,0.0),0.001);
		assertEquals(-1, xeometria.teoremaPitagoras(-3.0,-5.0),0.001);
	}

}
