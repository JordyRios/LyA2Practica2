
package practicaVCI;

import java.util.ArrayList;
import java.util.Stack;

public class OperadoresMethods {
    
    public OperadoresMethods() {
    }
    
    /* Metodo que recibe un token de la tabla de tokens. 
    Sirve para verificar si un token es (o no) un operador */
    public boolean checkOperador(Token token) {
        // Estos son los token que son operadores
        String[] items = {"-21", "-22", "-23", "-24", "-25", "-26", 
        "-31", "-32", "-33", "-34", "-35", "-36", "-41", "-42", "-43", "-73", "-74"}; 
        // Este es el retorno del metodo
        boolean output = false; 
        
        // Toma el token y verifica si es (o no) un operador 
        for (int i = 0; i < items.length; i++) { 
            String tokenValue = token.getToken(); 
            
            if (tokenValue.equals(items[i])) {     
                output = true; 
                break; 
            }  
        }
        
        return output; 
    }
    
    /* Metodo que obtiene la prioridad de un operador en la pila de
    operadores */
    public int getPrioridad(Token token) {
        // Este es el operador
        String operador = token.getToken(); 
        int prioridad = 0; 
        
        if (operador.equals("-21")
                || operador.equals("-22")
                || operador.equals("-23")) {
            prioridad = 60; //Los token -21, -22 y -23 tienen 60 de prioridad
        } else if (operador.equals("-24")
                || operador.equals("-25")) {
            prioridad = 50; //Los token -24 y -25 tienen 50 de prioridad
        } else if (operador.equals("-31")
                || operador.equals("-32")
                || operador.equals("-33")
                || operador.equals("-34")
                || operador.equals("-35")
                || operador.equals("-36")) {
            prioridad = 40; //Los token del -31 al -36 tienen 40 de prioridad
        } else if (operador.equals("-43")) {
            prioridad = 30; //El token -43 tiene 30 de prioridad
        } else if (operador.equals("-41")) {
            prioridad = 20; //El token -41 tiene 20 de prioridad
        } else if (operador.equals("-42")) {
            prioridad = 10; //El token -42 tiene 10 de prioridad
        }     

        //Si el operador entrante no coincide con ninguno de los token anteriores, 
        //tiene 0 de prioridad (Esto ocurre con el otken -26 de '=')        
        return prioridad; 
    }
    
    /* Metodo que recibe la prioridad de dos operadores. 
    Sirve para saber si un operador entrante es menor o igual al operador que se
    encuentra en la cabeza de la pila de operadores */
    public boolean comparePrioridades(int prioridadOperadorEntrante, int prioridadOperadorCabeza) {
        
        boolean output; 
        
        if (prioridadOperadorEntrante <= prioridadOperadorCabeza) {
            output = true; 
        } else {
            output = false; 
        }
        
        return output; 
    }
    
    /* Metodo que recibe la pila de operadores y el vci. 
    Sirve para eliminar el contenido que haya entre parentesis en una pila de 
    operadores */
    public void deleteContent(Stack<Token> operadores, ArrayList<Token> vci) {
        
        String operadorCabeza = null; 
        
        while (!operadores.empty()) {
            /* Toma el operador que se encuentra en la cabeza de la pila
            de operadores */
            operadorCabeza = operadores.peek().getToken(); 
            
            /* Elimina el contenido de la pila de operadores y lo pasa al vci 
            hasta encontrarse con un '(' */
            if (operadorCabeza.equals("-73")) {
                operadores.pop();
                break;
            } else {
                Token outToken = operadores.pop();    
                VciMethods vciMethods = new VciMethods(); 
                
                vciMethods.moveToVci(outToken, vci); 
            }
        }
    }
    
    /* Metodo que recibe un token, la pila de operadores y el vci.
    Sirve para pasar un operador a la pila de operadores */
    public void moveToOperadores(Token token, Stack<Token> operadores, ArrayList<Token> vci) {
        
        //Primero se verifica que la pila de operadores no este vacia
        if(!operadores.empty()) {
            // Este es el operador que va a entrar a la pila de operadores
            String operador = token.getToken(); 
            
            /* 
            Si el operador es un '(', el operador pasa directamente a la pila de operadores.
            Si el operador es un ')' se borra todo el contenido entre parentesis.
            Si es cualquier otro operador se realiza un analisis. 
            */
            if (operador.equals("-73")) {
                
                operadores.push(token); 
            } else if (operador.equals("-74")) {
                
                deleteContent(operadores, vci);
            } else {
                
                /*
                1. Se obtiene la prioridad del operador entrante y la prioridad del operador que se encuentra en la 
                cabeza de la pila de operadores (le llamaremos operador cabeza :D).
                2. Se mandan a comparar para saber si el operador entrante es menor al operador cabeza. 
                3. Si el operador entrante es menor o igual al operador cabeza: 
                    - Elimina el operador cabeza de la pila de operadores y lo pasa al vci
                    - Obtiene la prioridad del nuevo operador cabeza y lo manda a comparar con el operador entrante
                    - Repite el paso 3 hasta que el operador entrante sea mayor al operador cabeza
                4. Pasa el operador entrante a la cabeza de la pila de operadores
                */
                int prioridadOperadorEntrante = getPrioridad(token);                
                int prioridadOperadorCabeza = getPrioridad(operadores.peek()); 
                
                boolean prioridadMenor = comparePrioridades(prioridadOperadorEntrante, prioridadOperadorCabeza);  
                
                if (prioridadMenor) {
                    
                    do {
                        Token outToken = operadores.pop();      
                        VciMethods vciMethods = new VciMethods();

                        vciMethods.moveToVci(outToken, vci);
                        
                        prioridadOperadorCabeza = getPrioridad(operadores.peek()); 
                        prioridadMenor = comparePrioridades(prioridadOperadorEntrante, prioridadOperadorCabeza); 
                    } while (prioridadMenor); 
                    
                    operadores.push(token); 
                } else {
                    operadores.push(token); 
                }
            }
        }
    }
}
