package Controllers;
import modelo.App;
import modelo.Arista;
import modelo.Grafo;
import modelo.Vertice;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.channels.Pipe.SourceChannel;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.PatternSyntaxException;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

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
                 Circle meta = new Circle();
                 meta.setCenterX(vertice_final.getPosicionx()); // Coordenada X del centro
                 meta.setCenterY(vertice_final.getPosiciony());
                 meta.setRadius(10); // Radio
                 meta.setFill(javafx.scene.paint.Color.GREEN); // Color
                 root.getChildren().add(meta);
                

            } catch (PatternSyntaxException e) {
                System.out.println("Error en el archivo");
                return;
            }
            /*Agregar Obstaculos*/
            List<Rectangle> obstaculos = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
               datos = line.split(";"); 
               int posicionx_esquina= Integer.parseInt(datos[0].split(",")[0]);
               int posiciony_esquina= Integer.parseInt(datos[0].split(",")[1]);
               int posicionx_esquina2x= Integer.parseInt(datos[1].split(",")[0]);
               int posiciony_esquina2y= Integer.parseInt(datos[1].split(",")[1]);
               int posicionx_esquina3x= Integer.parseInt(datos[2].split(",")[0]);
               int posiciony_esquina3y= Integer.parseInt(datos[2].split(",")[1]);
               int posicionx_esquina4x= Integer.parseInt(datos[3].split(",")[0]);
               int posiciony_esquina4y= Integer.parseInt(datos[3].split(",")[1]);
               Rectangle rectangulo=new Rectangle();
               rectangulo.setX(posicionx_esquina);
               rectangulo.setY(posiciony_esquina);
               rectangulo.setWidth(posicionx_esquina2x-posicionx_esquina);
               rectangulo.setHeight(posiciony_esquina3y-posiciony_esquina);
               root.getChildren().add(rectangulo);
               obstaculos.add(rectangulo);
               Vertice vertice_obstaculo1 = new Vertice(posicionx_esquina-9,posiciony_esquina-16);
               Vertice vertice_obstaculo2 = new Vertice(posicionx_esquina2x+9,posiciony_esquina2y-16);
               Vertice vertice_obstaculo3 = new Vertice(posicionx_esquina3x-9,posiciony_esquina3y+16);
               Vertice vertice_obstaculo4 = new Vertice(posicionx_esquina4x+9,posiciony_esquina4y+16);
               Circle obstaculo1 = new Circle();
               obstaculo1.setCenterX(vertice_obstaculo1.getPosicionx()); // Coordenada X del centro
               obstaculo1.setCenterY(vertice_obstaculo1.getPosiciony());
               obstaculo1.setRadius(10); // Radio
               obstaculo1.setFill(javafx.scene.paint.Color.BLUE);
               Circle obstaculo2 = new Circle();
                obstaculo2.setCenterX(vertice_obstaculo2.getPosicionx()); // Coordenada X del centro
                obstaculo2.setCenterY(vertice_obstaculo2.getPosiciony());
                obstaculo2.setRadius(10); // Radio
                obstaculo2.setFill(javafx.scene.paint.Color.BLUE);
                Circle obstaculo3 = new Circle();
                obstaculo3.setCenterX(vertice_obstaculo3.getPosicionx()); // Coordenada X del centro
                obstaculo3.setCenterY(vertice_obstaculo3.getPosiciony());
                obstaculo3.setRadius(10); // Radio
                obstaculo3.setFill(javafx.scene.paint.Color.BLUE);
                Circle obstaculo4 = new Circle();
                obstaculo4.setCenterX(vertice_obstaculo4.getPosicionx()); // Coordenada X del centro
                obstaculo4.setCenterY(vertice_obstaculo4.getPosiciony());
                obstaculo4.setRadius(10); // Radio
                obstaculo4.setFill(javafx.scene.paint.Color.BLUE);
                root.getChildren().add(obstaculo1);
                root.getChildren().add(obstaculo2);
                root.getChildren().add(obstaculo3);
                root.getChildren().add(obstaculo4);
                Grafo.addVertice(vertice_obstaculo1);
                Grafo.addVertice(vertice_obstaculo2);
                Grafo.addVertice(vertice_obstaculo3);
                Grafo.addVertice(vertice_obstaculo4);
                System.out.println("Verices Agrergados");                
            }
            /*Agregar aristas*/
            for (Vertice vertice : Grafo.getVertices()) {
                for (Vertice vertice2 : Grafo.getVertices()) {
                    if (vertice != vertice2) {
                        System.out.println("Entrando");
                        if (intersectaObstaculo(vertice, vertice2, obstaculos)!=true && vertice.getPosicionx()!=vertice2.getPosicionx()) {
                            Arista arista = new Arista(vertice, vertice2,vertice.distancia(vertice2));
                            vertice.getAristas().add(arista);
                            Line linea = new Line(vertice.getPosicionx(), vertice.getPosiciony(), vertice2.getPosicionx(), vertice2.getPosiciony());
                            linea.setStroke(javafx.scene.paint.Color.BLACK);
                            root.getChildren().add(linea);
                            System.out.println("LNEA CREADA");
                        }else{
                            System.out.println("No se puede crear la linea");
                        }
                    }
                }
            }
          
        } catch (IOException e) {
            e.printStackTrace();
    
    }
}private boolean intersectaObstaculo(Vertice v1, Vertice v2, List<Rectangle> obstaculos) {
    Line linea = new Line(v1.getPosicionx(), v1.getPosiciony(), v2.getPosicionx(), v2.getPosiciony());
    for (Rectangle rect : obstaculos) {
        Shape interseccion = Shape.intersect(linea, rect);
        if (interseccion.getBoundsInLocal().getWidth() != -1) {
            return true;
        }
    }
    return false;
}


 @FXML
    void Iniciar_camino(ActionEvent event) {
        List<Vertice> lista =  Grafo.dijkstra(Grafo.getVertices().get(0), Grafo.getVertices().get(1));
        for (Vertice v: lista){
            System.out.println(v.getPosicionx()+","+v.getPosiciony());
            pintarVertice(v, javafx.scene.paint.Color.YELLOW);
           
        }	
        mostrarAlerta("Camino Creado");

    }private void pintarVertice(Vertice vertice, javafx.scene.paint.Color color) {
        Circle circle = new Circle();
        circle.setCenterX(vertice.getPosicionx());
        circle.setCenterY(vertice.getPosiciony());
        circle.setRadius(10);
        circle.setFill(color);
        root.getChildren().add(circle);
    }
    private Circle previousCircle = null;

    private void simularAvanceRobot(List<Vertice> camino) {
        new Thread(() -> {
    
            for (Vertice vertice : camino) {
                try {
                    Thread.sleep(1000); // Espera 1 segundo entre cada vértice
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
    
                javafx.application.Platform.runLater(() -> {
                    if (previousCircle != null) {
                        previousCircle.setFill(Color.YELLOW); // Color original
                    }
                    Circle circle = new Circle();
                    circle.setCenterX(vertice.getPosicionx());
                    circle.setCenterY(vertice.getPosiciony());
                    circle.setRadius(10);
                    circle.setFill(Color.RED); // Color del robot
                    root.getChildren().add(circle);
                    previousCircle = circle;
                    System.out.println("Avanzando al siguiente vértice");
                });
            }
        }).start();
}
@FXML
void Iniciar(ActionEvent event) {
    List<Vertice> lista =  Grafo.dijkstra(Grafo.getVertices().get(0), Grafo.getVertices().get(1));
    simularAvanceRobot(lista);
    
}
private void mostrarAlerta(String mensaje) {
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Recorrido Completo");
    alert.setHeaderText(null);
    alert.setContentText(mensaje);
    alert.showAndWait();
}

}
