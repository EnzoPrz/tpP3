package wordle.model;

import java.util.Random;

public class WordleLogica {
	
	private String[] palabras= {"GATOS", "CASAS", "AUTOS"};
	private String palabraElegida;
	
	public WordleLogica() {
        // Elegimos una palabra al azar al iniciar el modelo
        Random rand = new Random();
        int indiceRandom = rand.nextInt(palabras.length);
        this.palabraElegida = palabras[indiceRandom];
        
        // Un print para que vos sepas cuál eligió mientras probás
        System.out.println("Palabra secreta del día: " + palabraElegida);
    }
	
	
	public int[] validar(String intento) {
		int[] result = new int[5];
		String objetivo= palabraElegida.toUpperCase();
		String palabraUser= intento.toUpperCase();
		
		
		for(int i=0; i<5 ; i++) {
			char letraPalabraUser = palabraUser.charAt(i);
			
			if(letraPalabraUser == objetivo.charAt(i)) {
				result[i] = 2;
			}
			
			else if(objetivo.contains(String.valueOf(letraPalabraUser))){
				result[i]= 1;
			}
			
			else {
				result[i]=0;
			}
			
		}
		
		return result;
	}
	

}
