package db.UImenuFX;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import db.jdbc.SQLManager;
import db.pojos.Client;
import db.pojos.Director;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AccountClientController implements Initializable {

	// -----> CLASS ATRIBUTES <-----

	private static Client client_account;
	private static SQLManager manager_object;
	
	// -----> FXML ATRIBUTES <-----

	@FXML
	private JFXButton done_button;
	@FXML
	private AnchorPane account_window;
	@FXML
	private JFXButton update_button;
	@FXML
	private JFXButton change_button;
	@FXML
	private JFXButton delete_account_button;
	@FXML
	private JFXTextField name_field;
	@FXML
	private JFXTextField email_field;
	@FXML
	private JFXTextField telephone_field;
	@FXML
	private JFXPasswordField password_field;
	@FXML
	private JFXPasswordField repeat_password_field;
	@FXML
	private JFXPasswordField new_password_field;

	// -----> ESSENTIAL METHODS <-----+

	public AccountClientController() {
		// TODO Auto-generated constructor stub
	}
	
	public static void setValues(SQLManager manager, Client client) {
		manager_object = manager;
		client_account = client;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		delete_account_button.setOnAction((ActionEvent event) -> {
			manager_object.Delete_stored_user(client_account.getUser().getUserId());
			manager_object.Close_connection();
			LaunchApplication.getStage().show();
			ChargingScreenController.getMain_menu_stage().close();
		});
	}

	// -----> BUTTON METHODS <-----
	
	@FXML
	private void update_information(MouseEvent event) {
		if (!this.name_field.getText().equals("")) {
			client_account.setName(this.name_field.getText());
			this.name_field.setText("");
		} else {
			this.name_field.setText("");
		}
		if (!this.email_field.getText().equals("")) {
			client_account.setEmail(this.email_field.getText());
			this.email_field.setText("");
		} else {
			this.email_field.setText("");
		}
		if (!this.telephone_field.getText().equals("")) {
			client_account.setTelephone(Integer.parseInt(this.telephone_field.getText()));
			this.telephone_field.setText("");
		} else {
			this.telephone_field.setText("");
		}
		manager_object.Update_client_info(client_account);
	}

	@FXML
	private void change_password(MouseEvent event) {
		if (!(this.password_field.getText().equals("") && this.repeat_password_field.getText().equals("")
				&& this.new_password_field.getText().equals(""))
				&& (this.new_password_field.getText().equals(this.repeat_password_field.getText()))) {
			manager_object.Change_password(this.new_password_field.getText(), client_account.getUser().getUserId());
			this.password_field.setText("");
			this.repeat_password_field.setText("");
			this.new_password_field.setText("");
		} else {
			this.password_field.setText("");
			this.repeat_password_field.setText("");
			this.new_password_field.setText("");
		}
	}
	
	public void close_window() {
		Stage stage = (Stage) account_window.getScene().getWindow();
		stage.close();
	}
	
	// -----> GETTERS AND SETTERS <-----
	
	public JFXButton getDoneButton() {
		return done_button;
	}
}
