package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.CleaningStaff;
import model.Doctor;
import model.Nurse;
import model.Patient;
import model.Receptionist;
import javafx.scene.control.Tab;

import java.util.ArrayList;
import java.util.List;

public class HospitalApp extends Application {

	// Mantendo as listas aqui, pois você não está usando DataStore.getDoctors()
	// globalmente ainda.
	// Se você pretende usar DataStore globalmente, essas listas aqui poderiam ser
	// removidas.
	private final List<Patient> patients = new ArrayList<>();
	private final List<Doctor> doctors = new ArrayList<>(); // Esta lista será usada para a aba de Doutores
	private final List<Nurse> nurses = new ArrayList<>();
	private final List<Receptionist> receptionists = new ArrayList<>();
	private final List<CleaningStaff> cleaners = new ArrayList<>();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Hospital Management System");

		TabPane tabPane = new TabPane();
		tabPane.getTabs().addAll(createPatientTab(), createDoctorTab(), // Chamada para o método atualizado
				createNurseTab(), createReceptionistTab(), createCleaningStaffTab());

		Scene scene = new Scene(tabPane, 600, 400);
		stage.setScene(scene);
		stage.show();
	}

	// --- Métodos de Criação de Abas ---

	private Tab createPatientTab() {
		VBox layout = new VBox(5);
		layout.setPadding(new javafx.geometry.Insets(10));
		layout.setSpacing(5);

		TextField idField = new TextField();
		idField.setPromptText("ID");
		TextField nameField = new TextField();
		nameField.setPromptText("Name");
		TextField phoneField = new TextField();
		phoneField.setPromptText("Phone");
		TextField healthPlanIdField = new TextField();
		healthPlanIdField.setPromptText("Health Plan ID");

		Button registerButton = new Button("Register Patient");
		Button updateButton = new Button("Update Patient");
		Button removeButton = new Button("Remove Patient");

		ListView<Patient> patientListView = new ListView<>();

		// Listener para preencher campos ao selecionar paciente
		patientListView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, selectedPatient) -> {
			if (selectedPatient != null) {
				idField.setText(String.valueOf(selectedPatient.getId()));
				nameField.setText(selectedPatient.getName());
				phoneField.setText(selectedPatient.getPhone());
				healthPlanIdField.setText(selectedPatient.getHealthPlanId());
			} else {
				clearPatientFields(idField, nameField, phoneField, healthPlanIdField);
			}
		});

		// Ação de registrar paciente
		registerButton.setOnAction(e -> {
			try {
				if (idField.getText().isEmpty() || nameField.getText().isEmpty() || phoneField.getText().isEmpty()
						|| healthPlanIdField.getText().isEmpty()) {
					showAlert("Erro", "Por favor, preencha todos os campos para registrar o paciente.");
					return;
				}

				int id = Integer.parseInt(idField.getText());
				Patient p = new Patient(nameField.getText(), phoneField.getText(), id, healthPlanIdField.getText());
				patients.add(p);
				patientListView.getItems().add(p);
				clearPatientFields(idField, nameField, phoneField, healthPlanIdField);
			} catch (NumberFormatException ex) {
				showAlert("Erro de Entrada", "O ID do paciente deve ser um número válido.");
			}
		});

		// Ação de atualizar paciente
		updateButton.setOnAction(e -> {
			Patient selectedPatient = patientListView.getSelectionModel().getSelectedItem();
			if (selectedPatient == null) {
				showAlert("Erro", "Por favor, selecione um paciente para alterar.");
				return;
			}

			try {
				if (idField.getText().isEmpty() || nameField.getText().isEmpty() || phoneField.getText().isEmpty()
						|| healthPlanIdField.getText().isEmpty()) {
					showAlert("Erro", "Por favor, preencha todos os campos para atualizar o paciente.");
					return;
				}

				int id = Integer.parseInt(idField.getText());

				selectedPatient.setId(id);
				selectedPatient.setName(nameField.getText());
				selectedPatient.setPhone(phoneField.getText());
				selectedPatient.setHealthPlanId(healthPlanIdField.getText());

				int index = patientListView.getSelectionModel().getSelectedIndex();
				patientListView.getItems().set(index, selectedPatient);
				patientListView.getSelectionModel().clearSelection();

				showAlert("Sucesso", "Paciente alterado com sucesso!");
				clearPatientFields(idField, nameField, phoneField, healthPlanIdField);
			} catch (NumberFormatException ex) {
				showAlert("Erro de Entrada", "O ID do paciente deve ser um número válido.");
			}
		});

		// Ação de remover paciente
		removeButton.setOnAction(e -> {
			Patient selectedPatient = patientListView.getSelectionModel().getSelectedItem();
			if (selectedPatient == null) {
				showAlert("Erro", "Por favor, selecione um paciente para remover.");
				return;
			}

			patients.remove(selectedPatient);
			patientListView.getItems().remove(selectedPatient);

			showAlert("Sucesso", "Paciente removido com sucesso!");
			clearPatientFields(idField, nameField, phoneField, healthPlanIdField);
		});

		HBox buttonBox = new HBox(5, registerButton, updateButton, removeButton);
		layout.getChildren().addAll(idField, nameField, phoneField, healthPlanIdField, buttonBox, patientListView);
		patientListView.getItems().addAll(patients);

		return new Tab("Patients", layout);
	}

	private void clearPatientFields(TextField id, TextField name, TextField phone, TextField healthPlanId) {
		id.clear();
		name.clear();
		phone.clear();
		healthPlanId.clear();
	}

	private Tab createDoctorTab() {
		VBox layout = new VBox(5);
		layout.setPadding(new javafx.geometry.Insets(10)); // Adiciona um padding
		layout.setSpacing(5); // Espaçamento entre os elementos

		TextField nameField = new TextField();
		nameField.setPromptText("Name");
		TextField phoneField = new TextField();
		phoneField.setPromptText("Phone");
		TextField credentialField = new TextField();
		credentialField.setPromptText("Credential");
		TextField crmField = new TextField();
		crmField.setPromptText("CRM");
		TextField specialtyField = new TextField();
		specialtyField.setPromptText("Speciality");

		Button registerButton = new Button("Register Doctor");
		Button updateButton = new Button("Update Doctor"); // Novo botão
		Button removeButton = new Button("Remove Doctor"); // Novo botão

		// Usamos ListView<Doctor> para trabalhar diretamente com os objetos Doctor
		ListView<Doctor> doctorListView = new ListView<>();

		// Adiciona um listener para preencher os campos quando um doutor é selecionado
		// na lista
		doctorListView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, selectedDoctor) -> {
			if (selectedDoctor != null) {
				nameField.setText(selectedDoctor.getName());
				phoneField.setText(selectedDoctor.getPhone());
				credentialField.setText(selectedDoctor.getCredential());
				crmField.setText(selectedDoctor.getCrm());
				specialtyField.setText(selectedDoctor.getSpecialty());
			} else {
				// Limpa os campos se nada estiver selecionado
				nameField.clear();
				phoneField.clear();
				credentialField.clear();
				crmField.clear();
				specialtyField.clear();
			}
		});

		// Ação para Registrar Doutor
		registerButton.setOnAction(e -> {
			if (nameField.getText().isEmpty() || phoneField.getText().isEmpty() || credentialField.getText().isEmpty()
					|| crmField.getText().isEmpty() || specialtyField.getText().isEmpty()) {
				showAlert("Erro", "Por favor, preencha todos os campos para registrar o doutor.");
				return;
			}
			Doctor d = new Doctor(nameField.getText(), phoneField.getText(), credentialField.getText(),
					crmField.getText(), specialtyField.getText());
			doctors.add(d);
			doctorListView.getItems().add(d); // Adiciona o objeto Doctor diretamente
			clearDoctorFields(nameField, phoneField, credentialField, crmField, specialtyField);
		});

		// Ação para Alterar Doutor
		updateButton.setOnAction(e -> {
			Doctor selectedDoctor = doctorListView.getSelectionModel().getSelectedItem();
			if (selectedDoctor == null) {
				showAlert("Erro", "Por favor, selecione um doutor para alterar.");
				return;
			}
			if (nameField.getText().isEmpty() || phoneField.getText().isEmpty() || credentialField.getText().isEmpty()
					|| crmField.getText().isEmpty() || specialtyField.getText().isEmpty()) {
				showAlert("Erro", "Por favor, preencha todos os campos para atualizar o doutor.");
				return;
			}

			// Atualiza os dados do doutor selecionado
			selectedDoctor.setName(nameField.getText());
			selectedDoctor.setPhone(phoneField.getText());
			selectedDoctor.setCredential(credentialField.getText());
			selectedDoctor.setCrm(crmField.getText());
			selectedDoctor.setSpecialty(specialtyField.getText());

			// Força a atualização visual na ListView
			int selectedIndex = doctorListView.getSelectionModel().getSelectedIndex();
			doctorListView.getItems().set(selectedIndex, selectedDoctor); // Re-seta o item para forçar atualização
			doctorListView.getSelectionModel().clearSelection(); // Desseleciona

			showAlert("Sucesso", "Doutor alterado com sucesso!");
			clearDoctorFields(nameField, phoneField, credentialField, crmField, specialtyField);
		});

		// Ação para Remover Doutor
		removeButton.setOnAction(e -> {
			Doctor selectedDoctor = doctorListView.getSelectionModel().getSelectedItem();
			if (selectedDoctor == null) {
				showAlert("Erro", "Por favor, selecione um doutor para remover.");
				return;
			}

			// Remove da lista interna e da ListView
			doctors.remove(selectedDoctor);
			doctorListView.getItems().remove(selectedDoctor);

			showAlert("Sucesso", "Doutor removido com sucesso!");
			clearDoctorFields(nameField, phoneField, credentialField, crmField, specialtyField);
		});

		// Adiciona todos os campos e botões ao layout
		HBox buttonBox = new HBox(5, registerButton, updateButton, removeButton); // Caixa para os botões
		layout.getChildren().addAll(nameField, phoneField, credentialField, crmField, specialtyField, buttonBox,
				doctorListView);

		// Preenche a lista com os doutores existentes (se houver algum)
		doctorListView.getItems().addAll(doctors);

		return new Tab("Doctors", layout);
	}

	// Método auxiliar para limpar os campos da aba de Doutores
	private void clearDoctorFields(TextField name, TextField phone, TextField credential, TextField crm,
			TextField specialty) {
		name.clear();
		phone.clear();
		credential.clear();
		crm.clear();
		specialty.clear();
	}

	private Tab createNurseTab() {
		VBox layout = new VBox(5);
		layout.setPadding(new javafx.geometry.Insets(10));
		layout.setSpacing(5);

		TextField nameField = new TextField();
		nameField.setPromptText("Name");
		TextField phoneField = new TextField();
		phoneField.setPromptText("Phone");
		TextField credentialField = new TextField();
		credentialField.setPromptText("Credential");

		Button registerButton = new Button("Register Nurse");
		Button updateButton = new Button("Update Nurse");
		Button removeButton = new Button("Remove Nurse");

		ListView<Nurse> nurseListView = new ListView<>();

		// Listener para seleção de enfermeiro
		nurseListView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, selectedNurse) -> {
			if (selectedNurse != null) {
				nameField.setText(selectedNurse.getName());
				phoneField.setText(selectedNurse.getPhone());
				credentialField.setText(selectedNurse.getCredential());
			} else {
				clearNurseFields(nameField, phoneField, credentialField);
			}
		});

		// Ação para Registrar
		registerButton.setOnAction(e -> {
			if (nameField.getText().isEmpty() || phoneField.getText().isEmpty()
					|| credentialField.getText().isEmpty()) {
				showAlert("Erro", "Por favor, preencha todos os campos para registrar o enfermeiro.");
				return;
			}

			Nurse n = new Nurse(nameField.getText(), phoneField.getText(), credentialField.getText());
			nurses.add(n);
			nurseListView.getItems().add(n);
			clearNurseFields(nameField, phoneField, credentialField);
		});

		// Ação para Atualizar
		updateButton.setOnAction(e -> {
			Nurse selectedNurse = nurseListView.getSelectionModel().getSelectedItem();
			if (selectedNurse == null) {
				showAlert("Erro", "Por favor, selecione um enfermeiro para alterar.");
				return;
			}

			if (nameField.getText().isEmpty() || phoneField.getText().isEmpty()
					|| credentialField.getText().isEmpty()) {
				showAlert("Erro", "Por favor, preencha todos os campos para atualizar o enfermeiro.");
				return;
			}

			selectedNurse.setName(nameField.getText());
			selectedNurse.setPhone(phoneField.getText());
			selectedNurse.setCredential(credentialField.getText());

			int index = nurseListView.getSelectionModel().getSelectedIndex();
			nurseListView.getItems().set(index, selectedNurse);
			nurseListView.getSelectionModel().clearSelection();

			showAlert("Sucesso", "Enfermeiro alterado com sucesso!");
			clearNurseFields(nameField, phoneField, credentialField);
		});

		// Ação para Remover
		removeButton.setOnAction(e -> {
			Nurse selectedNurse = nurseListView.getSelectionModel().getSelectedItem();
			if (selectedNurse == null) {
				showAlert("Erro", "Por favor, selecione um enfermeiro para remover.");
				return;
			}

			nurses.remove(selectedNurse);
			nurseListView.getItems().remove(selectedNurse);

			showAlert("Sucesso", "Enfermeiro removido com sucesso!");
			clearNurseFields(nameField, phoneField, credentialField);
		});

		HBox buttonBox = new HBox(5, registerButton, updateButton, removeButton);
		layout.getChildren().addAll(nameField, phoneField, credentialField, buttonBox, nurseListView);
		nurseListView.getItems().addAll(nurses);

		return new Tab("Nurses", layout);
	}

	// Método auxiliar para limpar os campos
	private void clearNurseFields(TextField name, TextField phone, TextField credential) {
		name.clear();
		phone.clear();
		credential.clear();
	}

	private Tab createReceptionistTab() {
		VBox layout = new VBox(5);
		layout.setPadding(new javafx.geometry.Insets(10));
		layout.setSpacing(5);

		TextField nameField = new TextField();
		nameField.setPromptText("Name");
		TextField phoneField = new TextField();
		phoneField.setPromptText("Phone");
		TextField credentialField = new TextField();
		credentialField.setPromptText("Credential");

		Button registerButton = new Button("Register Receptionist");
		Button updateButton = new Button("Update Receptionist");
		Button removeButton = new Button("Remove Receptionist");

		ListView<Receptionist> receptionistListView = new ListView<>();

		receptionistListView.getSelectionModel().selectedItemProperty()
				.addListener((obs, oldVal, selectedReceptionist) -> {
					if (selectedReceptionist != null) {
						nameField.setText(selectedReceptionist.getName());
						phoneField.setText(selectedReceptionist.getPhone());
						credentialField.setText(selectedReceptionist.getCredential());
					} else {
						clearReceptionistFields(nameField, phoneField, credentialField);
					}
				});

		registerButton.setOnAction(e -> {
			if (nameField.getText().isEmpty() || phoneField.getText().isEmpty()
					|| credentialField.getText().isEmpty()) {
				showAlert("Erro", "Por favor, preencha todos os campos para registrar o recepcionista.");
				return;
			}

			Receptionist r = new Receptionist(nameField.getText(), phoneField.getText(), credentialField.getText());
			receptionists.add(r);
			receptionistListView.getItems().add(r);
			clearReceptionistFields(nameField, phoneField, credentialField);
		});

		updateButton.setOnAction(e -> {
			Receptionist selectedReceptionist = receptionistListView.getSelectionModel().getSelectedItem();
			if (selectedReceptionist == null) {
				showAlert("Erro", "Por favor, selecione um recepcionista para alterar.");
				return;
			}

			if (nameField.getText().isEmpty() || phoneField.getText().isEmpty()
					|| credentialField.getText().isEmpty()) {
				showAlert("Erro", "Por favor, preencha todos os campos para atualizar o recepcionista.");
				return;
			}

			selectedReceptionist.setName(nameField.getText());
			selectedReceptionist.setPhone(phoneField.getText());
			selectedReceptionist.setCredential(credentialField.getText());

			int index = receptionistListView.getSelectionModel().getSelectedIndex();
			receptionistListView.getItems().set(index, selectedReceptionist);
			receptionistListView.getSelectionModel().clearSelection();

			showAlert("Sucesso", "Recepcionista alterado com sucesso!");
			clearReceptionistFields(nameField, phoneField, credentialField);
		});

		removeButton.setOnAction(e -> {
			Receptionist selectedReceptionist = receptionistListView.getSelectionModel().getSelectedItem();
			if (selectedReceptionist == null) {
				showAlert("Erro", "Por favor, selecione um recepcionista para remover.");
				return;
			}

			receptionists.remove(selectedReceptionist);
			receptionistListView.getItems().remove(selectedReceptionist);

			showAlert("Sucesso", "Recepcionista removido com sucesso!");
			clearReceptionistFields(nameField, phoneField, credentialField);
		});

		HBox buttonBox = new HBox(5, registerButton, updateButton, removeButton);
		layout.getChildren().addAll(nameField, phoneField, credentialField, buttonBox, receptionistListView);
		receptionistListView.getItems().addAll(receptionists);

		return new Tab("Receptionists", layout);
	}

	private void clearReceptionistFields(TextField name, TextField phone, TextField credential) {
		name.clear();
		phone.clear();
		credential.clear();
	}

	private Tab createCleaningStaffTab() {
		VBox layout = new VBox(5);
		layout.setPadding(new javafx.geometry.Insets(10));
		layout.setSpacing(5);

		TextField nameField = new TextField();
		nameField.setPromptText("Name");
		TextField phoneField = new TextField();
		phoneField.setPromptText("Phone");
		TextField credentialField = new TextField();
		credentialField.setPromptText("Credential");

		Button registerButton = new Button("Register Cleaner");
		Button updateButton = new Button("Update Cleaner");
		Button removeButton = new Button("Remove Cleaner");

		ListView<CleaningStaff> cleanerListView = new ListView<>();

		// Listener de seleção
		cleanerListView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, selectedCleaner) -> {
			if (selectedCleaner != null) {
				nameField.setText(selectedCleaner.getName());
				phoneField.setText(selectedCleaner.getPhone());
				credentialField.setText(selectedCleaner.getCredential());
			} else {
				clearCleanerFields(nameField, phoneField, credentialField);
			}
		});

		// Ação de registro
		registerButton.setOnAction(e -> {
			if (nameField.getText().isEmpty() || phoneField.getText().isEmpty()
					|| credentialField.getText().isEmpty()) {
				showAlert("Erro", "Por favor, preencha todos os campos para registrar o funcionário da limpeza.");
				return;
			}

			CleaningStaff c = new CleaningStaff(nameField.getText(), phoneField.getText(), credentialField.getText());
			cleaners.add(c);
			cleanerListView.getItems().add(c);
			clearCleanerFields(nameField, phoneField, credentialField);
		});

		// Ação de alteração
		updateButton.setOnAction(e -> {
			CleaningStaff selectedCleaner = cleanerListView.getSelectionModel().getSelectedItem();
			if (selectedCleaner == null) {
				showAlert("Erro", "Por favor, selecione um funcionário da limpeza para alterar.");
				return;
			}

			if (nameField.getText().isEmpty() || phoneField.getText().isEmpty()
					|| credentialField.getText().isEmpty()) {
				showAlert("Erro", "Por favor, preencha todos os campos para atualizar o funcionário da limpeza.");
				return;
			}

			selectedCleaner.setName(nameField.getText());
			selectedCleaner.setPhone(phoneField.getText());
			selectedCleaner.setCredential(credentialField.getText());

			int index = cleanerListView.getSelectionModel().getSelectedIndex();
			cleanerListView.getItems().set(index, selectedCleaner);
			cleanerListView.getSelectionModel().clearSelection();

			showAlert("Sucesso", "Funcionário da limpeza alterado com sucesso!");
			clearCleanerFields(nameField, phoneField, credentialField);
		});

		// Ação de remoção
		removeButton.setOnAction(e -> {
			CleaningStaff selectedCleaner = cleanerListView.getSelectionModel().getSelectedItem();
			if (selectedCleaner == null) {
				showAlert("Erro", "Por favor, selecione um funcionário da limpeza para remover.");
				return;
			}

			cleaners.remove(selectedCleaner);
			cleanerListView.getItems().remove(selectedCleaner);

			showAlert("Sucesso", "Funcionário da limpeza removido com sucesso!");
			clearCleanerFields(nameField, phoneField, credentialField);
		});

		HBox buttonBox = new HBox(5, registerButton, updateButton, removeButton);
		layout.getChildren().addAll(nameField, phoneField, credentialField, buttonBox, cleanerListView);
		cleanerListView.getItems().addAll(cleaners);

		return new Tab("Cleaning Staff", layout);
	}

	private void clearCleanerFields(TextField name, TextField phone, TextField credential) {
		name.clear();
		phone.clear();
		credential.clear();
	}

	private void showAlert(String title, String message) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}
}