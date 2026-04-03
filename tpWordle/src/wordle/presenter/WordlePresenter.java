package wordle.presenter;

import java.awt.Color;

import wordle.model.WordleLogica;
import wordle.view.IWordleView;

public class WordlePresenter {
	
	private IWordleView vista;   // El Presenter habla con la Interfaz, no con el JFrame directo
    private WordleLogica modelo;  // El Presenter tiene una instancia de la lógica

    public WordlePresenter(IWordleView vista, WordleLogica modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }
    
    public void validar() {
    	String palabraUser= vista.obtenerPalabra();
    	
    	if(palabraUser.length() < 5) {
    		return;
    	}
    	
    	int[]result = modelo.validar(palabraUser);
    	
    	for (int i = 0; i < result.length; i++) {
			
    		if(result[i] ==2) {
    			vista.setColorFondo(i, Color.GREEN);
    		}
    		else if(result[i] ==1) {
    			vista.setColorFondo(i, Color.YELLOW);
    		}
    		else {
    			vista.setColorFondo(i, Color.GRAY);
    		}
		}
    	
    	
    	
    }

}
