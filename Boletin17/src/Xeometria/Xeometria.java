package Xeometria;

public class Xeometria {
	
	/**
	 * Calcula o peimetro dun cadrado
	 * @param lado Lado do cadrado (debe de ser maior que 0)
	 * @return Devolve o perimetro do cadrado. Se devolve -1 e que hai un erro nos parametros de entrada
	 */
	public int perimetroCadrado(int lado){
		if(lado <=0) return -1;
		return lado*4;
	}
	
	/**
	 * Calcula a área dun cadrado
	 * @param lado Lado do cadrado (debe de ser maior que 0)
	 * @return Devolve a área do cadrado. Se devolve -1 e que hai un erro nos parametros de entrada
	 */
	public int areaCadrado(int lado){
		if(lado <=0) return -1;
		return lado*lado;
	}

	/**
	 * Calcula a hipotenusa dun triangulo rectangulo
	 * @param catetoA
	 * @param catetoB
	 * @return Devolve a hipotenusa. Se devolve -1 e que hai un erro nos parametros de entrada
	 */
	public double teoremaPitagoras(int catetoA, int catetoB){
		if(catetoA<=0 || catetoB<=0) return -1;
		return Math.sqrt((catetoA*catetoA)+(catetoB*catetoB));
	}
	
	/**
	 * Calcula o outro cateto dun triangulo rectangulo
	 * @param hipotenusa
	 * @param catetoB
	 * @return Devolve o outro cateto. Se devolve -1 e que hai un erro nos parametros de entrada
	 */
	public double teoremaPitagoras (double hipotenusa, double catetoA){
		if(catetoA<=0 || hipotenusa<=0) return -1;
		if(hipotenusa<=catetoA) return -1;
		return Math.sqrt((hipotenusa*hipotenusa)-(catetoA*catetoA));
	}
}
