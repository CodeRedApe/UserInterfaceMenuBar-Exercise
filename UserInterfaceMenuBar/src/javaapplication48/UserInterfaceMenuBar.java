// This program creates a menu which has 4 items along with listeners
import javafx.application.*;
import javafx.scene.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.FileWriter;
import java.util.Date;
public class UserInterfaceMenuBar extends Application {

   // launches app
   public void start(final Stage state)
   {
       // stage title
       state.setTitle("creating MenuBar");

       // menu
       Menu mainMenu = new Menu("Menu");

       // menu items
       MenuItem menu1 = new MenuItem("Option 1");
       MenuItem menu2 = new MenuItem("Option 2");
       MenuItem menu3 = new MenuItem("Option 3");
       MenuItem menu4 = new MenuItem("Option 4");

       // add *Options* to menu
       mainMenu.getItems().add(menu1);
       mainMenu.getItems().add(menu2);
       mainMenu.getItems().add(menu3);
       mainMenu.getItems().add(menu4);

       // label to display events
       final TextField l = new TextField("");

       // Events for the Options
       // action event
       EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
           public void handle(ActionEvent e)
           {
               Date date = new Date();
               l.setText(date.toString());
           }
       };
       EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
           public void handle(ActionEvent e)
           {
               String text = l.getText();
               try{
               FileWriter fw = new FileWriter("log.txt");
               fw.write(text);
               fw.close();
               }catch(Exception exception){
                  
               }
               l.setText("The text was written to log.txt");
           }
       };
       EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>() {
           public void handle(ActionEvent e)
           {

           }
       };
       EventHandler<ActionEvent> event4 = new EventHandler<ActionEvent>() {
           public void handle(ActionEvent e)
           {
               Platform.exit();
           }
       };

       // Event
       menu1.setOnAction(event1);
       menu2.setOnAction(event2);
       menu3.setOnAction(event3);
       menu4.setOnAction(event4);

       // menubar
       MenuBar mb = new MenuBar();

       // menu for the menubar
       mb.getMenus().add(mainMenu);

       // VBox
       VBox vb = new VBox(mb, l);

       // scene 800x530
       Scene sc = new Scene(vb, 800, 350);

       // sets scene
       state.setScene(sc);

       state.show();
   }

   public static void main(String args[])
   {
       launch(args);
   }
}