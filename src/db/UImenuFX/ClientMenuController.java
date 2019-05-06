package db.UImenuFX;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import db.jdbc.SQLManager;
import db.pojos.Client;
import db.pojos.Director;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class ClientMenuController implements Initializable {

	// -----> CLASS ATRIBUTES <-----

	@SuppressWarnings("unused")
	private static Client client_account;
	@SuppressWarnings("unused")
	private static SQLManager manager_object;

	// -----> FXML ATRIBUTES <-----

	@FXML
	private AnchorPane menu_window;
	@FXML
	private Pane main_pane;
	@FXML
	private Pane menu_main_pane;
	@FXML
	private JFXButton logOut_button;
	@FXML
	private JFXButton myAccount_button;
	@FXML
	private JFXButton marketplace_button;
	@FXML
	private JFXButton club_button;
	@FXML
	private JFXButton mainmenu_button;
	@FXML
	private Label client_name;
	@FXML
	private Label email;
	@FXML
	private Label telephone;
	@FXML
	private ImageView minButton;
	@FXML
	private ImageView exitButton;
	@FXML
	private static Stage stage_window;
	// -----> ESSENTIAL METHODS <-----

	public ClientMenuController() {
		// TODO Auto-generated constructor stub
	}

	public static void setValues(SQLManager manager, Client client) {
		manager_object = manager;
		client_account = client;
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		myAccount_button.setOnAction((ActionEvent) -> {
			try {
				AccountClientController.setValues(manager_object, client_account);
				FXMLLoader loader = new FXMLLoader(getClass().getResource("AccountClientView.fxml"));
				Parent root = (Parent) loader.load();
				AccountClientController account_controller = new AccountClientController();
				account_controller = loader.getController();
				account_controller.getDoneButton().setOnMouseClicked(new EventHandler<Event>() {
					@Override
					public void handle(Event event) {
						update_client_account();
						menu_window.setEffect(null);
						stage_window.close();
					} 
				});	
				stage_window = new Stage();
				stage_window.initStyle(StageStyle.UNDECORATED);
				stage_window.setScene(new Scene(root));
				stage_window.setAlwaysOnTop(true);				
				stage_window.setOnShowing(new EventHandler<WindowEvent>() {
					@Override
					public void handle(WindowEvent arg0) {
						menu_window.setEffect(new BoxBlur(3,3,3));
					    setAllButtonsOff();
					}
				});
				stage_window.setOnHiding(new EventHandler<WindowEvent>() {		
					@Override
					public void handle(WindowEvent event) {
						setAllButtonsOn();
						menu_window.setEffect(null);
					}
				});		
				stage_window.show();
			} catch (IOException director_account_error) {
				director_account_error.printStackTrace();
				System.exit(0);
			
			}
		});}
	

	protected void setAllButtonsOff() {
		 myAccount_button.setDisable(true);
		    marketplace_button.setDisable(true);
		    club_button.setDisable(true);
		    mainmenu_button.setDisable(true);
		    logOut_button.setDisable(true);
		    minButton.setDisable(true);
		    exitButton.setDisable(true);
	}
	
	protected void setAllButtonsOn() {
		 myAccount_button.setDisable(false);
		    marketplace_button.setDisable(false);
		    club_button.setDisable(false);
		    mainmenu_button.setDisable(false);
		    logOut_button.setDisable(false);
		    minButton.setDisable(false);
		    exitButton.setDisable(false);
	}
	// -----> BUTTOM METHODS <-----

	@FXML
	private void close_app(MouseEvent event) {
		System.exit(0);
	}

	@FXML
	private void log_out(MouseEvent event) {
		    manager_object.Close_connection();
			LaunchApplication.getStage().show();
			Stage stage = (Stage) logOut_button.getScene().getWindow();
			stage.close();
	}
	@FXML
	private void min_window(MouseEvent event) {
		Stage stage = (Stage) menu_main_pane.getScene().getWindow();
		stage.setIconified(true);
	}

	@FXML
	private void open_marketplace(MouseEvent event) {
		// try {

		// } catch (IOException marketplace_charge_error) {
      
		// }
	}
	
	public AnchorPane getAnchorPane() {
		return this.menu_window;
	}
	public void update_client_account() {
		client_account = manager_object.Search_client_by_id(client_account.getClient_id());
    	setClientEmail(client_account.getEmail());
    	setClientName(client_account.getName());
		setClientTelephone(client_account.getTelephone());
}

public void setClientTelephone(Integer telephone) {
		if (telephone == null) {
			this.telephone.setText("Telephone: No telephone associated");
		} else {
			if (telephone != 0) {
				this.telephone.setText("Telephone: " + telephone);
			} else {
				this.telephone.setText("Telephone: No telephone associated");
			}
		}
	}

	public void setClientName(String name) {
		this.client_name.setText("Client's name: " + name );
	}

	public void setClientEmail(String email) {
		System.out.println(email);
		if (email != null) {
			this.email.setText("Email: " + email);
		} else {
			this.email.setText("Email: No email associated");
		}
	}
	@FXML
	private void loadmarketplace(MouseEvent event) throws IOException {
		System.out.println("holiwi he entrado en el metro de vanaina");
		setAllButtonsOn();
		marketplace_button.setDisable(true);
		Pane marketplace_pane = FXMLLoader.load(getClass().getResource("MarketplaceView.fxml"));
		main_pane.getChildren().removeAll();
		main_pane.getChildren().setAll(marketplace_pane);
		
	}
	
}
