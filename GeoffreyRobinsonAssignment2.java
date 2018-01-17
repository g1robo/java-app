/** Geoffrey Robinson
 
 * Problem: Design a polygon with buttons that increases and decreases the sides of the polygon
 * 1.The YourNameAssignment1 class which will be an extension of the Application class
a.The start method will be located here
b.The pane’s width and height will be set to 270 x 210
c. An instance of the polygon class (see item 3 below) is created with a default of 6 sides
d.The polygon instance is set in the center of the BorderPane
e.The bindings to the polygon class’s methods to increase and decrease the number of sides will be located here
f. The BorderPane, HBox and Scene will be instantiated here
g.The state’s title is set
h.The + and – buttons are created and located in the HBox
2.a main method for the start of program execution
a.The launch method will be called here
3. a class that models the polygon which will be an extension of the StackPane class
a.The polygon will be instantiated here
i.The constructor:
1. is where the default number of sides will set (6)
2. the polygon instance will be added to the pane
3. the fill color will be set
4. the stroke color will be set
5. the paint method is initially called
b.The paint method will be defined here
i.An ObservableList of type Double will be created
ii.The width and height of the polygon will be set to 200 x 200
iii.The radius will be calculated
iv.Points in the polygon will be added to the list using the following formulas for the x and y locations of the point:
for (int i = 0; i < numberOfSides; i++) {
list.add(centerX + radius * Math.cos(2 * i * Math.PI / numberOfSides));
list.add(centerY - radius * Math.sin(2 * i * Math.PI / numberOfSides));
}
c. The methods to increase and decrease the number of sides of the polygon are defined here

 */
package geoffreyrobinsonassignment2;

import java.util.HashSet;
import java.util.Set;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import static javafx.print.PrintColor.COLOR;
import javafx.scene.paint.Color;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.scene.paint.Paint;

public class GeoffreyRobinsonAssignment2 extends Application {//GeoffreyRobinsonAssigment2 extending application
    private final PolygonPane PolygonPane = new PolygonPane();//create polygonpane
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));// not used fxml document to construct polygon within javafx
        // add hbox
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        // add buttons
        Button btadd = new Button("+");
        Button btsub = new Button("-");
        // create and register handlers
        btadd.setOnAction(new addHandlerClass());
        btsub.setOnAction(new subHandlerClass());
        hBox.getChildren().addAll(btadd,btsub);
        // create border pane
        BorderPane pane = new BorderPane();
        pane.setCenter(PolygonPane);
        pane.setBottom(hBox);
        pane.setAlignment(hBox, Pos.CENTER);
        //Create a scene and place pane witin it
        Scene scene = new Scene(pane, 270, 210);//set borderpane to 270 by 210 within scene
        stage.setTitle("GeoffreyRobinsonAssignment2");// set the stage title
        stage.setScene(scene);//set the scene
        stage.show();// Display the stage
    }
     // args constructor and launch
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    //eventhandler for the add button
    class addHandlerClass implements EventHandler<ActionEvent> {
        @Override//Override the handler method
        public void handle(ActionEvent e) {
            PolygonPane.enlarge();
         }
        }
    //event handler for the sub button
    class subHandlerClass implements EventHandler<ActionEvent> {
        @Override//Override the handler method
        public void handle(ActionEvent e) {
            PolygonPane.shrink();
         }
        }
    //create polygane class that extends the stackpane
    class PolygonPane extends StackPane {
        //create a polygon
        Polygon polygon = new Polygon();
        int numberOfSides = 6;
        //polygonpane class
        PolygonPane (){
        getChildren().add(polygon);//add the polygon
        polygon.setStroke(Color.BLACK);//set stroke to black
        polygon.setFill(Color.WHITE);//set fill white
        ObservableList<Double> list = polygon.getPoints();
        list.clear();
        final double WIDTH = 200, HEIGHT = 200;//set width and height to 200 by 200
        double centerX = WIDTH / 2, centerY = HEIGHT / 2;
        double radius = Math.min(WIDTH, HEIGHT) * 0.4;
        // add points to polygon
        for (int i = 0; i < numberOfSides; i++){//formula for creating polygon sides
            list.add(centerX + radius * Math.cos(2 * i * Math.PI / numberOfSides));
            list.add(centerY + radius * Math.sin(2 * i * Math.PI / numberOfSides));
      }
        }
        //paint method instantiated
        public void paint(){
        ObservableList<Double> list = polygon.getPoints();
        list.clear();
        final double WIDTH = 200, HEIGHT = 200;//set width and height to 200 by 200
        double centerX = WIDTH / 2, centerY = HEIGHT / 2;
        double radius = Math.min(WIDTH, HEIGHT) * 0.4;
        // add points to polygon
        for (int i = 0; i < numberOfSides; i++){//formula for creating polygon sides
            list.add(centerX + radius * Math.cos(2 * i * Math.PI / numberOfSides));
            list.add(centerY + radius * Math.sin(2 * i * Math.PI / numberOfSides));
      }
        
        }
        public void enlarge (){//method to enlarge pentagon sides using increment
            numberOfSides++;
            paint();//repaint scene
          
        }
        public void shrink(){//method to shrink pentagon using decrement
           if(numberOfSides >= 1)numberOfSides--;
            paint();//repaint scene
        }
    
    }
}

    

