package practicaVCI;

import java.util.ArrayList;

/**
 *
 * @author edson
 */
public class VciMethods {

    public VciMethods() {
    }
    
    /* Metodo que recibe un token de la tabla de token. 
    Sirve para verificar si un token se pasa directamente (o no) al vci */
    public boolean checkVci(Token token) {
        // Estos son los token que se pasan directamente al vci
        String[] items = {"-4", "-5", "-51", "-52", "-53", "-54", "-55",
            "-61", "-62", "-63", "-64", "-65"};
        // Este es el retorno del metodo
        boolean output = false;

        // Toma el token y verifica si se pasa directamente (o no) al vci 
        for (int i = 0; i < items.length; i++) {      
            String tokenValue = token.getToken(); 
            
            if (tokenValue.equals(items[i])) {              
                output = true; 
                break; 
            }
        }

        return output; 
    }
    
    /* Metodo que recibe un token de la tabla de tokens y el vci. 
    Sirve para pasar un token al vci */ 
    public void moveToVci (Token token, ArrayList<Token> vci)
    {
        vci.add(token);   
    }
}
