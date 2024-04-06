package practica2;

import javax.swing.*;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author edson
 */
public class Aplicacion {
    public static void main(String[] args) {
        ArrayList<Token> vci = new ArrayList<Token>();
        Stack<String> estatutos = new Stack<String>();
        Stack<Integer> direcciones = new Stack<Integer>();
        Stack<String> operadores = new Stack<String>();
        
        LecturaDeArchivos.leer(vci, estatutos, direcciones, operadores); 
    }
}
