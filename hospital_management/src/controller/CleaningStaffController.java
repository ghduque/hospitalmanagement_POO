package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.CleaningStaff;
import util.DataStore;
import javafx.event.ActionEvent;

public class CleaningStaffController {

	@FXML
	private TextField nameField;

	@FXML
	private TextField phoneField;

	@FXML
	private TextField credentialField;

	@FXML
	private Button addButton;

	@FXML
	private ListView<String> staffList;

	@FXML
	public void initialize() {
		updateListView();
	}

	@FXML
	private void handleAddCleaningStaff(ActionEvent event) {
		String name = nameField.getText();
		String phone = phoneField.getText();
		String credential = credentialField.getText();

		if (!name.isEmpty() && !phone.isEmpty() && !credential.isEmpty()) {
			CleaningStaff staff = new CleaningStaff(name, phone, credential);
			DataStore.getInstance();
			DataStore.getCleaningStaff().add(staff);
			updateListView();
			clearFields();
		}
	}

	private void updateListView() {
		staffList.getItems().clear();
		DataStore.getInstance();
		for (CleaningStaff c : DataStore.getCleaningStaff()) {
			staffList.getItems().add(c.toString());
		}
	}

	private void clearFields() {
		nameField.clear();
		phoneField.clear();
		credentialField.clear();
	}
}
