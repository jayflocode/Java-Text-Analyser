package com.example.projectfinal;
	
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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;




/**
 * This is an application that removes html informatiom from a document and generates a list of common words found
 * @author Jayson jflo Flores
 * @version 2.0
 * @category Class Assignment
 * 
 *
 */
public class Main extends Application {
	
	
	/**
	 * Public static elements used for GUI elements and also to declare file names
	 */
	
	
	public static int range; //represent range of results
	public static String resultEntry;
	public static String htmlFile = "mod2.htm";
	public static String output3;
	public static String db = "";
	
	
	
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			/**
			 * THe line below uses a line for the graphical user interface. The values 
			 control the coordinates where the line starts and ends right at the top area of graphical interface
			 */
			   	
			//creates line 
			Line line = new Line();
			
			// line settings
			
			line.setStartX(50.0); 
			line.setStartY(75.0); 
			line.setEndX(1030.0); 
			line.setEndY(75.0);
			
			/**
			 * Creates a group in which we are going to use to combine a button in a grid java fx view
			 */
			
			// creates group for scene
			Group root = new Group(line);
			
			
			//app size
			
			/**
			 * Sets the size of the window to use 1080 x 768 
			 */
			
			Scene scene = new Scene(root,1080,768);
			/**
			 * Sets title to Frequency Counter App
			 */
			//app title
			primaryStage.setTitle("Frequency Counter App");
			
			/**
			 * Creates a label and specifics a size for the label, also provides customized fonts
			 */
			
			//creates objects for scene
			
			Label label1 = new Label();     //label1
			
			//label settings for app title
			label1.setLayoutX(440);
			label1.setLayoutY(20);
			label1.setText("Word Analyser");
			label1.setFont(Font.font("verdana", FontPosture.REGULAR, 20)); //setting static font
			
			
			/**
			 * A textfield will be used to input the results. These results will be numbers, for example 20 would give top 20 results of
			 * words found in document
			 */
			
			//Grid Text Field for results
			
			TextField resultsField = new TextField();    //textfield 1
			resultsField.setMaxWidth(40);
			
			
			TextField schema = new TextField();    //textfield 1
			schema.setMaxWidth(120);
			
			TextField queryField = new TextField();    //textfield 1
			queryField.setPrefWidth(300);
			queryField.setPromptText("SELECT Words FROM word ORDER BY Words*1;");
			
			
			//action listener for the key presses
		
			/**
			 * This is an event handler that converts strings of the input to actual integer using parsing method
			 * it creates a file object from the public string, and it launches a method that accesses counter class
			 * 
			 */
			
			resultsField.setOnKeyReleased(new EventHandler<KeyEvent>() {

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


			/** action listener for query field, this is where the query is executed
			 */

			queryField.setOnKeyReleased(new EventHandler<KeyEvent>() {

				@Override
				public void handle(KeyEvent eventType) {
					// TODO Auto-generated method stub

					SqlConnect.query = queryField.getText();
					System.out.println("Query is: " + queryField.getText());
					System.out.println("Query Field = " + SqlConnect.query);
					
					
				}
				
				
			});

			/** action listener for schema field, this is where database is indicated
			 */

			schema.setOnKeyReleased(new EventHandler<KeyEvent>() {

				@Override
				public void handle(KeyEvent eventType) {
					// TODO Auto-generated method stub

					SqlConnect.schemaName = schema.getText();
					System.out.println("Schema is: " + schema.getText());
					System.out.println("Schema is set to = " + SqlConnect.schemaName);


				}


			});
			
			/**
			 * Text area is created to display the results
			 * An action listener is set up to run a for clear the textfield first so that it doesn't merge results, and then the for loop
			 * gathers elements and appends them into the textfield
			 */
			
            //Grid Text Area   where results are set to be displayed 
			
			TextArea output = new TextArea();    //textfield 1
			output.setPrefSize(450, 400);
			
			   //textfield 1
			TextArea outputDB = new TextArea();
			outputDB.setPrefSize(450, 400);
			
			Label lab = new Label();
			lab.setText("SQL Database Information");

			Label intruc1 = new Label();
			intruc1.setText("                                                     Query Field                                                 Schema Field");
			
			
			//creation of execute search button
			
			Button button1 = new Button();  //button1
			button1.setText("Execute Search");
			
			
			Button dbButton = new Button();  //button1
			dbButton.setText("Query Database");
			
			/** query button listener, upon pressing it retrieves information from the table */
			
			
			dbButton.setOnAction(new EventHandler<ActionEvent>() {
				
				
			    @Override public void handle(ActionEvent e) {
			    	

                try {
					SqlConnect.print();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
			    outputDB.clear();	
			    
			
			    try {
					for (int i = 0; i < SqlConnect.arrayMaster.size(); i++) {
						
						
						// prints output to textfield
						outputDB.appendText(SqlConnect.arrayMaster.get(i) + "\n");
						

					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					
					
					System.out.println("Contents failed to load in Text Area");
					
					
				}
			    	
			    	
			    }
			});
			
			
			//action listener for the button execute search (array retrieval)
			button1.setOnAction(new EventHandler<ActionEvent>() {
				
			
			    @Override public void handle(ActionEvent e) {
			    	

			       
			    output.clear();	
			    
			
			    for (int i = 0; i < counter.array.size(); i++) {
			    	
			    	
			    	// prints output to textfield
			    	output.appendText(counter.array.get(i) + "\n");
			    	
			    	// sends output as an insert command to the database 
			    	
			
			    	
			    }
			    	
			    	
			    }
			});
			/**
			 * A button that closes the program using a listener and using system exit method. 
			 */
			//exit program button
			
			Button insertDB = new Button();
			insertDB.setText("Insert Data to SQL Table");
			
			//action listener for exit program button
			insertDB.setOnAction(new EventHandler<ActionEvent>() {
				
				
			    @Override public void handle(ActionEvent e) {
			       
			    	// System.exit(0);  exits program- set for later use 
			    	
			    	
			    	for (int i = 0; i < counter.array.size(); i ++) {
			    		
			    		try {
							SqlConnect.insert(counter.array.get(i));
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			    		
			    		
			    	}
			    	
			    	
			    }
			});
			
            /**
			 * Grid view arranging the results of the buttons in the scene using grid view
			 * The specific grid view adds button 1 and button 2 in different coordinates in x and y fashion
			 */
			
			//textfield grid view settings 
			 
			    GridPane grid = new GridPane();
			    
			    grid.setLayoutY(100);
			    grid.setLayoutX(50);
			    
			    grid.setVgap(4);
			    grid.setHgap(10);
			    grid.setPadding(new Insets(5, 5, 5, 5));
			    grid.add(new Label("Enter Range of Results: "), 0, 0);
			    grid.add(resultsField, 1, 0);
			    grid.add(button1, 3, 0);
			    grid.add(insertDB, 5, 0);
			   
			   
			    grid.add(queryField, 6, 28);
			    grid.add(schema, 7, 28);
			    grid.add(dbButton, 7, 15);
			    
			    /**
				 * This second grid is for the textfield only. 
				 */
			    

				//textfield grid settings 2
				 
				    GridPane grid2 = new GridPane();
				    
				    grid2.setLayoutY(200);
				    grid2.setLayoutX(50);
				    
				    
				    grid2.setVgap(4);
				    grid2.setHgap(10);
				    grid2.setPadding(new Insets(5, 5, 5, 5));
				    grid2.add(new Label("Top Words found in HTML document (document html packaged into jar): "), 0, 0);
				    
				    
				    grid2.add(output, 0, 15);
				    grid2.add(outputDB, 1, 15);
				    grid2.add(lab, 1, 1);
					grid2.add(intruc1, 1, 2);
				    
			   
			
			
				    /**
					 * The bottom codes executes the scenes so that they can be shown as active when we run the code
					 */
			
			//creates execution of scene items
			
			Group label = (Group) scene.getRoot();
			
			//root.getChildren().add(button1);  // creates a button
			
			
			root.getChildren().add(label1);  //creates a label 
			
			/**
			 * The below code retrives and executes both grids that we created previously.
			 */
			label.getChildren().add(grid2);  //group for text label grid 
			label.getChildren().add(grid);
			
			
			
			
			
			
			

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
