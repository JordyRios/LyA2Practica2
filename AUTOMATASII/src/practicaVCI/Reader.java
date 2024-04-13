package practicaVCI;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;

public class Reader {

    public Reader() {
    }

    public ArrayList read(ArrayList<Token> vci) {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                File documentsFolder = new File(
                        System.getProperty("user.home") + File.separator
                        + "Documents");
                desktop.open(documentsFolder);

                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();

                    try (BufferedReader br = new BufferedReader(new FileReader(
                            selectedFile))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            line.replaceAll(" ", "");

                            String[] columns = line.split(",");
                            Token token;

                            if (columns.length == 5) {
                                String[] columnsTemp = new String[4];
                                columnsTemp[0] = ",";
                                columnsTemp[1] = columns[2];
                                columnsTemp[2] = columns[3];
                                columnsTemp[3] = columns[4];

                                for (int i = 0; i < columns.length; i++) {
                                    columns[i] = null;
                                }

                                token = new Token(
                                        columnsTemp[0],
                                        columnsTemp[1],
                                        columnsTemp[2],
                                        columnsTemp[3]);
                            } else {

                                token = new Token(
                                        columns[0],
                                        columns[1],
                                        columns[2],
                                        columns[3]);
                            }
                            vci.add(token);
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
            System.out.println(
                    "El escritorio no es compatible con este sistema.");
        }

        return vci;
    }
}
