package practicaVCI;

import java.util.ArrayList;
import java.util.Stack;

public class App {
    
    public static void main(String[] args) {
        // Estas son las estructuras necesarias para generar el codigo intermedio
        ArrayList<Token> vci = new ArrayList<>();
        Stack<Token> estatutos = new Stack<>();
        Stack<Integer> direcciones = new Stack<>();
        Stack<Token> operadores = new Stack<>();

        /* Estos objetos se encargan de llamar a los metodos necesarios para trabajar
        con la tabla de tokens */        
        Reader reader = new Reader();
        VciMethods vciMethods = new VciMethods();

        // Aqui se guarda la tabla de tokens  
        ArrayList<Token> tablaDeTokens = new ArrayList<>();

        // Lee el archivo con la tabla de tokens y lo guarda en tablaDeTokens
        reader.read(tablaDeTokens);
        
        /* Esta es una prueba. Aqui se toma loa token de las tablas de token 
        para verificar si se pasan directamente al vci */
        for (int i = 0; i < tablaDeTokens.size(); i++) {
            
            Token token = tablaDeTokens.get(i); 
            boolean itsVci = vciMethods.checkVci(token); 
            
            if(itsVci) {
                vciMethods.moveToVci(token, vci); 
            } //EN ESTA PARTE CONTINUA LA PRACTICA
        }
        
        // Aqui imprime el vci 
        for (int i = 0; i < vci.size(); i++) {
            Token token = vci.get(i); 
            
            System.out.println(token); 
        }
    }
}
