package application;
	
import java.io.File;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;


public class Main extends Application {
	
	public static int range; //represent range of results
	public static String AreaField;
	public static String resultEntry;
	public static String htmlFile = "mod2.htm";
	public static String output3;
	
	
	
	
		
	
	
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			
			File module2 = new File(htmlFile);
	    	try {
				counter.reader(module2, range);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	
			
			
			//creates line 
			Line line = new Line();
			
			// line settings
			
			line.setStartX(50.0); 
			line.setStartY(75.0); 
			line.setEndX(1030.0); 
			line.setEndY(75.0);
			
			// creates group for scene
			Group root = new Group(line);
			
			
			//app size
			
			Scene scene = new Scene(root,1080,768);
			
			//app title
			primaryStage.setTitle("Frequency Counter App");
			
			//creation of pane
			Pane p = new Pane();
			
			//creates objects for scene
			
			Label label1 = new Label();     //label1
			
			//label settings for app title
			label1.setLayoutX(440);
			label1.setLayoutY(20);
			label1.setText("Word Analyzer");
			label1.setFont(Font.font("verdana", FontPosture.REGULAR, 20)); //setting static font
			
			
			
			
			
			
			
			//Grid Text Field 1
			
			TextField resultsField = new TextField();    //textfield 1
			resultsField.setText(resultEntry);
			resultsField.setMaxWidth(40);
			
			//action listener for the key presses
			
			
			scene.setOnKeyReleased(new EventHandler<KeyEvent>() {

				@Override
				public void handle(KeyEvent eventType) {
					// TODO Auto-generated method stub
					
					System.out.println("Key Press is: " + resultsField.getText());
					
					range = Integer.parseInt(resultsField.getText());
					
					System.out.println("range integer is: " + range);
					
					
					File module2 = new File(htmlFile);
					
					try {
						counter.reader(module2, range);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
				}
				
				
			});
			
		
			
            //Grid Text Area 2  where results are set to be displayed 
			
			TextArea output = new TextArea();    //textfield 1
			output.setPrefSize(500, 400);
			
			
			
			
			
			Button button1 = new Button();  //button1
			button1.setText("Execute Search");
			
			
			//action listener for the button
			button1.setOnAction(new EventHandler<ActionEvent>() {
				
			
				
				
			    @Override public void handle(ActionEvent e) {
			       
			    output.clear();	
			    	
			    for (int i = 0; i < counter.array.size(); i++) {
			    	
			    	
			    	
			    	output.appendText(counter.array.get(i) + "\n");
			    	
			    	
			    	
			    }
			    	
			    	
			
			    	
			    }
			});
			
			
			
			//textfield grid settings 1 
			 
			    GridPane grid = new GridPane();
			    
			    grid.setLayoutY(100);
			    grid.setLayoutX(50);
			    
			    grid.setVgap(4);
			    grid.setHgap(10);
			    grid.setPadding(new Insets(5, 5, 5, 5));
			    grid.add(new Label("Enter Range of Results: "), 0, 0);
			    grid.add(resultsField, 1, 0);
			    grid.add(button1, 3, 0);
			    

				//textfield grid settings 2
				 
				    GridPane grid2 = new GridPane();
				    
				    grid2.setLayoutY(200);
				    grid2.setLayoutX(50);
				    
				    
				    grid2.setVgap(4);
				    grid2.setHgap(10);
				    grid2.setPadding(new Insets(5, 5, 5, 5));
				    grid2.add(new Label("Output of Search: "), 0, 0);
				    grid2.add(output, 0, 15);	    
			   
			
			
			
			
			//creates execution of scene items
			
			Group label = (Group) scene.getRoot();
			
			//root.getChildren().add(button1);  // creates a button
			
			
			root.getChildren().add(label1);  //creates a label 
			
			
			label.getChildren().add(grid);  //group for text label grid 
			label.getChildren().add(grid2);
			
			
			
			
			
			
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		
		
		launch(args);
		
		
		
	}
}
