package practica2;

import java.util.ArrayList;

public class MetodosParaProcesarLineas {   
    public static void analizar(String[] partes, ArrayList<Token> vci) {
        String[] elementos = {"-4", "-5", "-51", "-52", "-53", "-54", "-55", 
            "-61", "-62", "-63", "-64", "-65"};
        boolean esElemento = false; 

        for (int i = 0; i < elementos.length; i++) {
            if (partes[1].equals(elementos[i])) {
                esElemento = true; 
                break; 
            }
            else {
                continue;
            }
        }
        
        if (esElemento) {
            pasarAVCI(partes, vci);
        }
    }
    
    
    public static ArrayList<Token> pasarAVCI(String[] partes, ArrayList<Token> vci) {
        Token token = new Token(partes[0], partes[1], partes[2], partes[3]);
        vci.add(token); 
        return vci;
    }
}
