package DNI;

import java.util.ArrayList;

public class DNI {
	private String letrasDNI;
	
	/**
	 * Constructor da clase
	 */
	public DNI(){
		this.letrasDNI = new String("TRWAGMYFPDXBNJZSQVHLCKE");
	}
	
	/**
	 * Indica se unha cadea ten un formato de DNI valido seguinte ddddddddL
	 * @param numeroLetra cadea do dni
	 * @return se e valido o dni ou non
	 */
	public boolean eValido(String numeroLetra){
		
		//Primeiro: que sexan nova caracteres
		if(numeroLetra.length()!=9) return false;
		
		//Que os 8 primeiros caracteres sexan todo numeros
		if(!sonTodoNumeros(numeroLetra.substring(0, 8))) return false;
		
		//Comprobamos que o noveno caracter e unha letra
		if(!Character.isLetter(numeroLetra.charAt(8))) return false;
		
		//Comprobamos que a letra se corresponde cos números
		Integer numero = Integer.valueOf(numeroLetra.substring(0,8));
		char letraValida = calculaLetraNumero(numero);
		char letraEntrada = Character.toUpperCase(numeroLetra.charAt(8));
		if(letraEntrada != letraValida) return false;
		
		//Se non houbo ningun erro, o DNI e valido
		return true;
		
	}
	
	/**
	 * Devolve a letra (o codigo asci) da cadea de numeros. Se a cadea non e valida devolve -1
	 * @param numero
	 * @return
	 */
	int calculaLetra(String numero){
		
		//Primeiro: que sexan nova caracteres
		if(numero.length()!=8) return -1;
		
		//Que todolos caracteres sexan numeros
		if(!sonTodoNumeros(numero)) return -1;
		
		//Calculamos a letra
		Integer numeroInt = Integer.valueOf(numero);
		return calculaLetraNumero(numeroInt);
		
		
	}
	
	/**
	 * Comproba que un dni teña o formato correcto
	 * @param numeros Lista cos numeros do dni en orden de esquerda a dereita
	 * @param letra do dni
	 * @return
	 */
	boolean eValido (ArrayList<Integer> numeros, char letra){
		
		//Comprobamos que sexan 8 numeros
		if(numeros.size()!=8) return false;
		
		//Comprobamos que todolos enteiros estan entre 0 e 9
		for(int i=0; i<numeros.size();i++){
			Integer aux = numeros.get(i);
			if(aux < 0 || aux > 9) return false;
		}
		
		//Calculamos o numero
		int numeroCompleto=deArrayANumero(numeros);
		
		//Comprobamos se esta ben a letra que nos dan
		char letraValida = calculaLetraNumero(numeroCompleto);
		
		char letraEntrada = Character.toUpperCase(letra);
		if(letraEntrada != letraValida) return false;
		
		
		return true;
	}
	
	/**
	 * Devolve a letra do dni dunha lista. Se a lista non ten o formato preciso devolve -1 
	 * @param numeros Lista cos numeros do dni en orden de esquerda a dereita
	 * @return
	 */
	int calculaLetra(ArrayList<Integer> numeros){
		//Comprobamos que sexan 8 numeros
		if(numeros.size()!=8) return -1;
		
		//Comprobamos que todolos enteiros estan entre 0 e 9
		for(int i=0; i<numeros.size();i++){
			Integer aux = numeros.get(i);
			if(aux < 0 || aux > 9) return -1;
		}
		
		//Calculamos o numero
		int numeroCompleto=deArrayANumero(numeros);
		
		//Calcula a letra
		return calculaLetraNumero(numeroCompleto);
		
	}
	
	
	/**************************************** Metodos auxiliares **************************************************************/
	
	private boolean sonTodoNumeros(String cadena){
		
		//Recorremos todolos caracteres da cadea
		for(int i=0;i<cadena.length();i++){
			
			//Comprobamos se e un numero
			char aux = cadena.charAt(i);
			if(!Character.isDigit(aux)) return false;
		}
		
		return true;
	}
	
	private char calculaLetraNumero(int numero){
		int resto = numero % this.letrasDNI.length();
		return this.letrasDNI.charAt(resto);
	}
	
	private int deArrayANumero(ArrayList<Integer> numeros){
		int numeroCompleto=0;
		int potencia =0;
		for(int i=numeros.size(); i>0;i--){
			Integer aux = numeros.get(i-1);
			numeroCompleto = numeroCompleto + aux * (int)Math.pow(10, potencia);
			potencia++;
		}
		return numeroCompleto;
	}

}
