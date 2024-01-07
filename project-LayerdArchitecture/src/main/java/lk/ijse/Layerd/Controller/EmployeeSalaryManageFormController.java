package lk.ijse.Layerd.Controller;

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
import javafx.util.Callback;
import lk.ijse.Layerd.bo.custom.EmployeeBO;
import lk.ijse.Layerd.bo.custom.EmployeeSalaryBO;
import lk.ijse.Layerd.bo.custom.Impl.EmployeeBOImpl;
import lk.ijse.Layerd.bo.custom.Impl.EmployeeSalaryBOImpl;
import lk.ijse.Layerd.dao.custom.EmployeeDAO;
import lk.ijse.Layerd.dao.custom.EmployeeSalaryDAO;
import lk.ijse.Layerd.dao.custom.Impl.EmployeeModel;
import lk.ijse.Layerd.dao.custom.Impl.EmployeeSalaryModel;
import lk.ijse.Layerd.dto.ESalaryDto;
import lk.ijse.Layerd.dto.EmployeeDto;
import lk.ijse.Layerd.view.tdm.ESalaryTm;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

import static java.lang.String.valueOf;


public class EmployeeSalaryManageFormController {

    @FXML
    private AnchorPane ESalaryPane;

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
    private TableColumn<?, ?> columnDate;

    @FXML
    private TableColumn<?, ?> columnE_ID;

    @FXML
    private TableColumn<?, ?> columnPayments;

    @FXML
    private TableColumn<?, ?> columnSalary_ID;

    @FXML
    private TableView<ESalaryTm> tableESalary;

    @FXML
    private DatePicker txtDate;

    @FXML
    private TextField txtE_ID;

    @FXML
    private TextField txtPayment;

    @FXML
    private TextField txtSalary_ID;

    @FXML
    private TextField txtTelephone;

    @FXML
    private ComboBox<String> cmbE_ID;

   // private  final EmployeeModel employeeModel=new EmployeeModel();

   // EmployeeDAO employeeDAO=new EmployeeModel();
   // EmployeeSalaryDAO employeeSalaryDAO=new EmployeeSalaryModel();

    EmployeeBO employeeBO=new EmployeeBOImpl();
    EmployeeSalaryBO employeeSalaryBO=new EmployeeSalaryBOImpl();

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/DashBoardForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)ESalaryPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();

    }

    private void clearFields() {
     //   txtE_ID.setText("");
        txtTelephone.setText("");
        txtPayment.setText("");
        txtSalary_ID.setText("");
        txtDate.dayCellFactoryProperty();
    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/CustomerForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)ESalaryPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/DashBoardForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)ESalaryPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String Salary_ID= txtSalary_ID.getText();
       // var model=new EmployeeSalaryModel();

        try{
            //boolean isDeleted= model.deleteESalaryDetails(Salary_ID);

           // boolean isDeleted=employeeSalaryDAO.delete(Salary_ID);
            boolean isDeleted= employeeSalaryBO.deleteESalaryDetails(Salary_ID);
            if(isDeleted){
                tableESalary.refresh();
                new Alert(Alert.AlertType.CONFIRMATION,"Employee Salary details are  deleted ").show();
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

        Stage stage1=(Stage)ESalaryPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnEmployeeOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/EmployeeForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)ESalaryPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnEmployeeSalaryOnAction(ActionEvent event) {

    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/LoginForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)ESalaryPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnOrderDetailsOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/OrderDetailsForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)ESalaryPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnOrdersOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/OrdersForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)ESalaryPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnProductOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/ProductForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) ESalaryPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnRawMaterialsOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/RawMaterialsForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage)ESalaryPane.getScene().getWindow();
        stage1.close();

    }
    /////
    public void initialize() {
        setCellValueFactory();
        setDate();
        loadAllE_ID();
        loadAllSalaryDetails();
    }

    private void loadAllE_ID() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
           // List<EmployeeDto> cusList = employeeModel.loadAllEmployee();
           // List<EmployeeDto> cusList = employeeDAO.loadAllEmployee();
            List<EmployeeDto> cusList = employeeBO.loadAllEmployee();

            for (EmployeeDto dto : cusList) {
                obList.add(dto.getE_ID());
            }
            cmbE_ID.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        columnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        columnSalary_ID.setCellValueFactory(new PropertyValueFactory<>("Salary_ID"));
        columnE_ID.setCellValueFactory(new PropertyValueFactory<>("E_ID"));
        columnPayments.setCellValueFactory(new PropertyValueFactory<>("Payment"));
        columnDate.setCellValueFactory(new PropertyValueFactory<>("date"));


    }

    private void loadAllSalaryDetails() {
       // var model = new EmployeeSalaryModel();

        ObservableList<ESalaryTm> obList = FXCollections.observableArrayList();

        try {
          //  List<ESalaryDto> dtoList = model.getAllESalaryDetails();

          //  List<ESalaryDto> dtoList = employeeSalaryDAO.getAll();
            List<ESalaryDto> dtoList = employeeSalaryBO.getAllESalaryDetails();

            for(ESalaryDto dto : dtoList) {
                obList.add(
                        new ESalaryTm(
                                dto.getSalary_ID(),
                                dto.getE_ID(),
                                dto.getDate(),
                                dto.getPayment()

                        )
                );
            }
            tableESalary.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    ///////

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        boolean isValidated=ESalaryValidated();
        if(isValidated) {
            String Salary_ID = txtSalary_ID.getText();
            String E_ID = cmbE_ID.getValue();
            double  Payment = Double.valueOf(txtPayment.getText());
            String tel = txtTelephone.getText();
            String date = valueOf(LocalDate.now());

            var dto = new ESalaryDto(Salary_ID, E_ID, tel, date, Payment);

           // var model = new EmployeeSalaryModel();
            try {
               // boolean isSaved = model.saveESalaryDetails(dto);

                //boolean isSaved=employeeSalaryDAO.save(dto);
                boolean isSaved= employeeSalaryBO.saveESalaryDetails(dto);
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Employee Salary Details are saved ").showAndWait();

                    /////
                    Parent root= FXMLLoader.load(this.getClass().getResource("/view/EmployeeSalaryManageForm.fxml"));
                    Scene scene=new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();

                    Stage stage1 = (Stage)ESalaryPane.getScene().getWindow();
                    stage1.close();
                    /////////

                }
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }else{
            new Alert(Alert.AlertType.ERROR,"Employee details are invalid, try again!").show();
        }

    }

    private boolean ESalaryValidated() {
//1)
        String id=txtSalary_ID.getText();
        boolean isSalaryIdValidated= Pattern.matches("[S][0-9]{3,}",id);
//2)txtE_ID.getText()
     //   String E_ID=cmbE_ID.getId();
      //  boolean isE_IDValidated=Pattern.matches("[E][0-9]{3,}",E_ID);
//3)
        String tel=txtTelephone.getText();
        boolean isTelValidated=Pattern.matches("[0][0-9]{9,}",tel);

        if(!isSalaryIdValidated ){
            new Alert(Alert.AlertType.ERROR,"invalid Salary id").show();
            txtSalary_ID.requestFocus();
            return false;

        }

       /*else  if(!isE_IDValidated ){
            new Alert(Alert.AlertType.ERROR,"invalid E id ").show();
            txtE_ID.requestFocus();
            return  false;
        }*/

       else if(!isTelValidated ){
            new Alert(Alert.AlertType.ERROR,"invalid telephone content ").show();
            txtTelephone.requestFocus();
            return  false;
        }
        else {
            return true;
        }
    }

    @FXML
    void btnSupplierOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/SupplierForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)ESalaryPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

        boolean isValidated=ESalaryValidated();
        if(isValidated) {
            String Salary_ID = txtSalary_ID.getText();
            String E_ID = cmbE_ID.getValue();
            Double Payment = Double.valueOf(txtPayment.getText());
            String tel = txtTelephone.getText();
            String date = valueOf(LocalDate.now());


            var dto = new ESalaryDto(Salary_ID, E_ID, tel, date, Payment);
           // var model = new EmployeeSalaryModel();
            try {
                //boolean isUpdated = model.updateESalaryDetails(dto);

               // boolean isUpdated=employeeSalaryDAO.update(dto);
                boolean isUpdated= employeeSalaryBO.updateESalaryDetails(dto);
                if (isUpdated) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Employee Salary details are Updated").showAndWait();

                    /////
                    Parent root= FXMLLoader.load(this.getClass().getResource("/view/EmployeeSalaryManageForm.fxml"));
                    Scene scene=new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();

                    Stage stage1 = (Stage)ESalaryPane.getScene().getWindow();
                    stage1.close();
                    /////////
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            new Alert(Alert.AlertType.ERROR, "can't update,because salary details are incorrect").show();
        }

    }

    @FXML
    void txtDateOnAction(ActionEvent event) {

    }

    @FXML
    void cmbE_IDOnAction(ActionEvent event) {

    }

    @FXML
    void txtPaymentOnAction(ActionEvent event) {

    }

    @FXML
    void txtSalary_IDOnAction(ActionEvent event) {
        String id = txtSalary_ID.getText();

       // var model = new EmployeeSalaryModel();
        try {
           // ESalaryDto dto = model.searchESalaryDetails(id);

           // ESalaryDto dto = employeeSalaryDAO.search(id);
            ESalaryDto dto = employeeSalaryBO.searchESalaryDetails(id);

            if(dto != null) {
                fillFields(dto);
            } else {
                new Alert(Alert.AlertType.INFORMATION, "that salary detail not found!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    private void fillFields(ESalaryDto dto) {
        txtSalary_ID.setText(dto.getSalary_ID());
        txtTelephone.setText(dto.getTel());
        txtPayment.setText(String.valueOf(dto.getPayment()));
        txtDate.getValue();

    }
    //////
    private void setDate() {

        Date date = Date.valueOf(valueOf(LocalDate.now()));
    }



    @FXML
    void txtTelephoneOnAction(ActionEvent event) {

    }

}

