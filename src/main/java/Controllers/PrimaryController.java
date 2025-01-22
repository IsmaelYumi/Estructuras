package Controllers;
import modelo.App;
import modelo.Grafo;
import modelo.Vertice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.PatternSyntaxException;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class PrimaryController implements Initializable {

     @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Código de inicialización
        Inicio_Ambiente();
    }


    Grafo Grafo= new Grafo();
    @FXML
    Pane root;
   
    private void Inicio_Ambiente() {
        String datos [];
        try (InputStream inputStream = getClass().getResourceAsStream("/Archivos/grafo.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            String PosicionInicial = reader.readLine();
            String PosicionFinal = reader.readLine();
            int PosicionInicialx;
            int PosicionInicialy;
            int PosicionFinalx;
            int PosicionFinaly;
            try {
                PosicionInicialx = Integer.parseInt(PosicionInicial.split(",")[0]);
                PosicionInicialy = Integer.parseInt(PosicionInicial.split(",")[1]);
                PosicionFinalx = Integer.parseInt(PosicionFinal.split(",")[0]);
                PosicionFinaly = Integer.parseInt(PosicionFinal.split(",")[1]);
                /*Agregar los vertices*/ 
                Vertice vertice_inicio = new Vertice(PosicionInicialx,PosicionInicialy);
                Vertice vertice_final = new Vertice(PosicionFinalx,PosicionFinaly);
                Grafo.addVertice(vertice_inicio);
                Grafo.addVertice(vertice_final);
                 Circle robot = new Circle();
                 robot.setCenterX(vertice_inicio.getPosicionx()); // Coordenada X del centro
                 robot.setCenterY(vertice_inicio.getPosiciony());
                 robot.setRadius(10); // Radio
                 robot.setFill(javafx.scene.paint.Color.RED); // Color
                 root.getChildren().add(robot);
                

            } catch (PatternSyntaxException e) {
                System.out.println("Error en el archivo");
                return;
            }
            /*Agregar Obstaculos*/
            while ((line = reader.readLine()) != null) {
               datos = line.split(";"); 
               int posicionx_esquina= Integer.parseInt(datos[0].split(",")[0]);
               int posiciony_esquina= Integer.parseInt(datos[0].split(",")[1]);
               int posicionx_esquina2_x= Integer.parseInt(datos[1].split(",")[0]);
               int posiciony_esquina3_x= Integer.parseInt(datos[2].split(",")[1]);
               Rectangle rectangulo=new Rectangle();
               rectangulo.setX(posicionx_esquina);
               rectangulo.setY(posiciony_esquina);
               rectangulo.setWidth(posicionx_esquina2_x-posicionx_esquina);
               rectangulo.setHeight(posiciony_esquina3_x-posiciony_esquina);
               root.getChildren().add(rectangulo);

            }
        } catch (IOException e) {
            e.printStackTrace();
    
    }
}
}
