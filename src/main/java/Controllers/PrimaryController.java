package Controllers;
import modelo.App;
import modelo.Grafo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javafx.fxml.FXML;

public class PrimaryController {

    Grafo Grafo= new Grafo();
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    private void lectura() {
        try (InputStream inputStream = getClass().getResourceAsStream("/Archivos/grafo.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Procesa cada línea del archivo
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
