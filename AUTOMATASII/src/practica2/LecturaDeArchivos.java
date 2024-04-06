package practica2;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JFileChooser;

public class LecturaDeArchivos {
    public static void leer(ArrayList<Token> vci, Stack<String> estatutos, 
            Stack<Integer> direcciones, Stack<String> operadores) {
        // Verificar si Desktop es compatible con el sistema actual 
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                // Obtener la carpeta de documentos del usuario
                File documentsFolder = new File(System.getProperty("user.home") + File.separator + "Documents");

                // Abrir el explorador de archivos en la carpeta de documentos
                desktop.open(documentsFolder);

                // Crear el JFileChooser y mostrarlo para que el usuario seleccione un archivo
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);

                // Si el usuario selecciona un archivo
                if (result == JFileChooser.APPROVE_OPTION) {
                    // Obtener el archivo seleccionado
                    File selectedFile = fileChooser.getSelectedFile();

                    // Leer el archivo línea por línea
                    try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            // Procesar la línea como desees
                            line.replaceAll(" ", ""); 
                            String[] partes = line.split(",");

                            if (partes.length == 5) {
                                String[] partesTemp = new String[4];
                                partesTemp[0] = ",";
                                partesTemp[1] = partes[2];
                                partesTemp[2] = partes[3];
                                partesTemp[3] = partes[4];

                                for (int i = 0; i < partes.length; i++) {
                                    partes[i] = null;
                                }
                                MetodosParaProcesarLineas.analizar(partesTemp, vci);
                            } else {
                                MetodosParaProcesarLineas.analizar(partes, vci);
                            }
                        }
                        for (int i = 0; i < vci.size(); i++) {
                            String salida = vci.get(i).toString(); 
                            System.out.println(salida);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("No se seleccionó ningún archivo.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("El escritorio no es compatible con este sistema.");
        }
    }
}
