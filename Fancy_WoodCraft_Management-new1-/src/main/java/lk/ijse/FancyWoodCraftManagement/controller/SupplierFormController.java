package lk.ijse.FancyWoodCraftManagement.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.FancyWoodCraftManagement.dto.CustomerDto;
import lk.ijse.FancyWoodCraftManagement.dto.SupplierDto;
import lk.ijse.FancyWoodCraftManagement.model.CustomerModel;
import lk.ijse.FancyWoodCraftManagement.model.EmployeeModel;
import lk.ijse.FancyWoodCraftManagement.model.OrderDetailModel;
import lk.ijse.FancyWoodCraftManagement.model.SupplierModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

public class SupplierFormController {

    @FXML
    private TableColumn<?, ?> ColumnAddress;

    @FXML
    private TableColumn<?, ?> ColumnName;

    @FXML
    private TableColumn<?, ?> ColumnSupplier_ID;

    @FXML
    private TableColumn<?, ?> ColumnTel;

    @FXML
    private AnchorPane SupplierPane;

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnCustomer;

    @FXML
    private JFXButton btnDashboard;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnDelivery;

    @FXML
    private JFXButton btnEmployee;

    @FXML
    private JFXButton btnEmployeeSalary;

    @FXML
    private JFXButton btnLogOut;

    @FXML
    private JFXButton btnOrderDetails;

    @FXML
    private JFXButton btnOrders;

    @FXML
    private JFXButton btnProduct;

    @FXML
    private JFXButton btnRawMaterials;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnSupplier;

    @FXML
    private JFXButton btnUpdate;



    @FXML
    private TableView<SupplierDto> tableSupplier;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSupplier_ID;

    @FXML
    private TextField txtTel;

    @FXML
    private ComboBox<?> cmbE_ID;

    @FXML
    private ComboBox<?> cmbOrder_ID;

    private  final EmployeeModel employeeModel=new EmployeeModel();
    private final OrderDetailModel orderDetailModel=new OrderDetailModel();

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/DashBoardForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)SupplierPane.getScene().getWindow();
        stage1.close();


    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        txtSupplier_ID.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtTel.setText("");

    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/CustomerForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)SupplierPane.getScene().getWindow();
        stage1.close();
    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/DashBoardForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)SupplierPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String Supplier_ID= txtSupplier_ID.getText();
        var model=new SupplierModel();

        try{
            boolean isDeleted= model.deleteSupplier(Supplier_ID);
            if(isDeleted){
                tableSupplier.refresh();
                new Alert(Alert.AlertType.CONFIRMATION,"Supplier deleted successfully").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }

    }

    @FXML
    void btnDeliveryOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/DeliveryForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)SupplierPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnEmployeeOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/EmployeeForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage) SupplierPane.getScene().getWindow();
        stage1.close();

    }


    @FXML
    void btnEmployeeSalaryOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/EmployeeSalaryManageForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)SupplierPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/LoginForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)SupplierPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnOrderDetailsOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/OrderDetailsForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)SupplierPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnOrdersOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/OrdersForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)SupplierPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnProductOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/ProductForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) SupplierPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnRawMaterialsOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/RawMaterialsForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) SupplierPane.getScene().getWindow();
        stage1.close();

    }

    /////
    public void initialize() {
        setCellValueFactory();
        loadAllE_ID();
        loadAllOrder_ID();
        loadAllSuppliers();
    }

    private void loadAllOrder_ID() {
    }

    private void loadAllE_ID() {
    }

    private void setCellValueFactory() {
        ColumnSupplier_ID.setCellValueFactory(new PropertyValueFactory<>("Supplier_ID"));
        ColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        ColumnAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        ColumnTel.setCellValueFactory(new PropertyValueFactory<>("tel"));

    }

    private void loadAllSuppliers() {
        var model = new SupplierModel();

        ObservableList<SupplierDto> obList = FXCollections.observableArrayList();

        try {
            List<SupplierDto> dtoList = model.getAllSuppliers();

            for(SupplierDto dto : dtoList) {
                obList.add(
                        new SupplierDto(
                                dto.getSupplier_ID(),
                                dto.getName(),
                                dto.getAddress(),
                                dto.getTel()
                        )
                );
            }
        tableSupplier.setItems(obList);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    ///////

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        boolean isValidated=isSupplierValidated();
        if(isValidated) {
            String Supplier_ID = txtSupplier_ID.getText();
            String name = txtName.getText();
            String Address = txtAddress.getText();
            String Tel = txtTel.getText();

            var dto = new SupplierDto(Supplier_ID, name, Address, Tel);
            var model = new SupplierModel();

            try {
                boolean isSaved = model.saveSupplier(dto);
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Supplier Saved").showAndWait();
                    /////
                    Parent root= FXMLLoader.load(this.getClass().getResource("/view/SupplierForm.fxml"));
                    Scene scene=new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();

                    Stage stage1 = (Stage) SupplierPane.getScene().getWindow();
                    stage1.close();

                    /////
                }
            } catch (SQLException | IOException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }else{
            new Alert(Alert.AlertType.ERROR,"invalid Supplier details,try again").show();
        }

    }

    private boolean isSupplierValidated() {

        String id=txtSupplier_ID.getText();
        boolean isSupplierIdValidated= Pattern.matches("[S][0-9]{3,}",id);
        if(!isSupplierIdValidated){
            new Alert(Alert.AlertType.ERROR,"invalid Supplier  id").show();
            return false;

        }
        String name=txtName.getText();
        boolean isSupplierNameValidated=Pattern.matches("[A-Za-z]{3,}",name);
        if (!isSupplierNameValidated) {
            new Alert(Alert.AlertType.ERROR, "invalid Supplier name").show();
            return false;
        }

        String address=txtAddress.getText();
        boolean isAddressValidated=Pattern.matches("[A-Za-z]{3,}",address);
        if(!isAddressValidated) {
            new Alert(Alert.AlertType.ERROR, "invalid Supplier address").show();
            return false;
        }

        String tel=txtTel.getText();
        boolean isTelValidated=Pattern.matches("[0]\\d{9}",tel);
        if (!isTelValidated){
            new Alert(Alert.AlertType.ERROR,"invalid Supplier tel").show();
            return  false;
        }


        return true;
    }

    @FXML
    void btnSupplierOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

        boolean isValidated=isSupplierValidated();
        if(isValidated) {
            String Supplier_ID = txtSupplier_ID.getText();
            String name = txtName.getText();
            String tel = txtTel.getText();
            String address = txtAddress.getText();

            var dto = new SupplierDto(Supplier_ID, name, address, tel);
            var model = new SupplierModel();
            try {
                boolean isUpdated = model.updateSupplier(dto);
                if (isUpdated) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Supplier is Updated").showAndWait();

                    /////
                    Parent root= FXMLLoader.load(this.getClass().getResource("/view/SupplierForm.fxml"));
                    Scene scene=new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();

                    Stage stage1 = (Stage) SupplierPane.getScene().getWindow();
                    stage1.close();

                    /////
                }
            } catch (SQLException | IOException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }else{
            new Alert(Alert.AlertType.ERROR,"cannot update because supplier details are not corrected.").show();
        }

    }
    @FXML
    void cmbE_IDOnAction(ActionEvent event) {

    }

    @FXML
    void cmbOrder_IDOnAction(ActionEvent event) {

    }

    @FXML
    void txtAddressOnAction(ActionEvent event) {

    }

    @FXML
    void txtNameOnAction(ActionEvent event) {

    }

    @FXML
    void txtSupplier_IDOnAction(ActionEvent event) {
        String id = txtSupplier_ID.getText();

        var model = new SupplierModel();
        try {
           SupplierDto dto = model.searchSupplier(id);

            if(dto != null) {
                fillFields(dto);
            } else {
                new Alert(Alert.AlertType.INFORMATION, "supplier not found!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    private void fillFields(SupplierDto dto) {
        txtSupplier_ID.setText(dto.getSupplier_ID());
        txtName.setText(dto.getName());
        txtAddress.setText(dto.getAddress());
        txtTel.setText(dto.getTel());

    }



    @FXML
    void txtTelOnAction(ActionEvent event) {

    }

}
