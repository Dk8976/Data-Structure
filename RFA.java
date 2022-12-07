//package application;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.collections.*;
public class RFA extends Application
{
	public void start(Stage primaryStage) throws Exception
	{
		primaryStage.setTitle("Registration Form JavaFX Application");
// Create the registration form grid pane
		GridPane gridPane = createRegistrationFormPane();
// Add UI controls to the registration form grid pane
		addUIControls(gridPane);
// Create a scene with registration form grid pane as the root node
		Scene scene = new Scene(gridPane, 800, 500);
// Set the scene in primary stage
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	private GridPane createRegistrationFormPane()
	{
// Instantiate a new Grid Pane
		GridPane gridPane = new GridPane();
// Position the pane at the center of the screen, both vertically and horizontally
		gridPane.setAlignment(Pos.CENTER);
// Set a padding of 20px on each side
		gridPane.setPadding(new Insets(40, 40, 40, 40));
// Set the horizontal gap between columns
		gridPane.setHgap(10);
// Set the vertical gap between rows
		gridPane.setVgap(10);
// Add Column Constraints
// columnOneConstraints will be applied to all the nodes placed in column one.
		ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100,Double.MAX_VALUE);
		columnOneConstraints.setHalignment(HPos.RIGHT);
// columnTwoConstraints will be applied to all the nodes placed in column two.
		ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200,Double.MAX_VALUE);
		columnTwoConstrains.setHgrow(Priority.ALWAYS);
		gridPane.getColumnConstraints().addAll(columnOneConstraints,columnTwoConstrains);
		return gridPane;
	}
	private void addUIControls(GridPane gridPane)
	{
// Add Header
		Label headerLabel = new Label("Registration Form");
		headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		gridPane.add(headerLabel, 0,0,2,1);
		GridPane.setHalignment(headerLabel, HPos.CENTER);
		GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));
// Add Name Label
		Label nameLabel = new Label("Full Name : ");
		gridPane.add(nameLabel, 0,1);
// Add Name Text Field
		TextField nameField = new TextField();
		nameField.setPrefHeight(40);
		gridPane.add(nameField, 1,1);
// Add Email Label
		Label emailLabel = new Label("Email ID : ");
		gridPane.add(emailLabel, 0, 2);
// Add Email Text Field
		TextField emailField = new TextField();
		emailField.setPrefHeight(40);
		gridPane.add(emailField, 1, 2);

// Add Password Label
		/*Label passwordLabel = new Label("Password : ");
		gridPane.add(passwordLabel, 0, 3);
// Add Password Field
		PasswordField passwordField = new PasswordField();
		passwordField.setPrefHeight(40);
		gridPane.add(passwordField, 1, 3);*/

		Label MobileLabel = new Label("Mobile No : ");
		gridPane.add(MobileLabel, 0, 3);
// Add Email Text Field
		TextField MobileNo = new TextField();
		MobileNo.setPrefHeight(40);
		gridPane.add(MobileNo, 1, 3);
		TilePane r = new TilePane();
		Label GenderLabel = new Label("Gender : ");
		ToggleGroup tg = new ToggleGroup();
		gridPane.add(GenderLabel, 0, 4);
		RadioButton MaleButton = new RadioButton("Male");
		RadioButton FemaleButton = new RadioButton("Female");
		RadioButton OthersButton = new RadioButton("Others");
		MaleButton.setToggleGroup(tg);
		FemaleButton.setToggleGroup(tg);
		OthersButton.setToggleGroup(tg);
//gridPane.add(GenderLabel);
		r.getChildren().add(MaleButton);
		r.getChildren().add(FemaleButton);
		r.getChildren().add(OthersButton);
		gridPane.add(r, 1, 4);
//Birth Date
		Label DobLabel = new Label("Date of Birth : ");
		gridPane.add(DobLabel, 0, 5);
		DatePicker dob = new DatePicker();
		gridPane.add(dob, 1, 5);
// Country Label
		Label CountryLabel = new Label("Country");
		gridPane.add(CountryLabel, 0, 6);
		String CountryList[] = {"USA","UK","Scotland","Armenia","India","Maldives"};
		ComboBox Countrycombo_box = new ComboBox(FXCollections.observableArrayList(CountryList));
		gridPane.add(Countrycombo_box, 1, 6);
// Add Submit Button
		Button submitButton = new Button("Submit");
		submitButton.setPrefHeight(40);
		submitButton.setDefaultButton(true);
		submitButton.setPrefWidth(100);
		gridPane.add(submitButton, 0, 7, 2, 1);
		GridPane.setHalignment(submitButton, HPos.CENTER);
		GridPane.setMargin(submitButton, new Insets(20, 0,20,0));
		submitButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{ if(nameField.getText().isEmpty())
				{
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(),"FormError!", "Please enter your name");
					return;
				}
				if(emailField.getText().isEmpty())
				{
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "FormError!", "Please enter your email id");
					return;
				}
				if(MobileNo.getText().isEmpty())
				{
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "FormError!", "Please enter a Mobile No");
					return;
				}
				if(!MaleButton.isSelected() && ! FemaleButton.isSelected() && !OthersButton.isSelected())
				{
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(),	"Form Error!", "Please select the Gender");
					return;
				}
				showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(),"Registration Successful!", "Welcome " + nameField.getText());
			}
		});
	}
	private void showAlert(Alert.AlertType alertType, Window owner, String title, String message)
	{
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(owner);
		alert.show();
	}
	public static void main(String[] args)
	{
		launch(args);
	}
}
