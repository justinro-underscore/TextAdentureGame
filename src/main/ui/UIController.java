package main.ui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.text.CommandObj;
import main.text.TextInterpreter;

/**
 * Name: Justin Roderman
 * File: UIController.java
 * Date: August 26, 2018
 * Desc: File that facilitates user interaction
 */

public class UIController extends Application
{
	@FXML TextArea txtOutput;
	@FXML TextField txtInput;

	/**
	 * Where the application launches from
	 * @param args What is passed in (don't worry about this)
	 */
	public static void main(String[] args)
	{
		launch(args);
	}

	/**
	 * Where the application launches from
	 * @throws IOException If an input or output exception occurred
	 */
	public void start(Stage arg0) throws Exception
	{
		FXMLLoader load = new FXMLLoader(getClass().getResource("TextAdventureUI.fxml"));
		load.setController(this); // Makes it so that you can control the UI using this class

		Parent root = (Parent) load.load();
		Scene scene = new Scene(root);

		// Start the application
		Stage stage = new Stage();
		stage.setTitle("Text Adventure"); // TODO Change to name of game
		stage.setScene(scene);
		initializeVariables();
		initializeUI();

		stage.show();
	}

	/**
	 * Initializes all aspects of the UI
	 */
	private void initializeUI()
	{
		initializeListeners();
	}

	/**
	 * Initializes all variables required for the game to run
	 */
	private void initializeVariables()
	{

	}

	/**
	 * Sets the functions that run when the user clicks on certain objects
	 */
	private void initializeListeners()
	{
		txtInput.setOnAction(e -> {
			String in = ((TextField)e.getSource()).getText().trim();
			if(!in.isEmpty())
			{
				CommandObj cmd = TextInterpreter.input(in);
				Platform.runLater(() -> {
					txtOutput.appendText("\n\n" + cmd);
					txtOutput.setScrollTop(Double.MAX_VALUE);
				});

				((TextField)e.getSource()).clear();
			}
		});
	}
}