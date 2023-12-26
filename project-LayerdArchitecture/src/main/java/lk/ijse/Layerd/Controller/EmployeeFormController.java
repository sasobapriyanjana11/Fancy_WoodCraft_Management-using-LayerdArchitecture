package lk.ijse.Layerd.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import lk.ijse.Layerd.dao.custom.EmployeeDAO;
import lk.ijse.Layerd.dao.custom.Impl.EmployeeModel;
import lk.ijse.Layerd.db.DbConnection;
import lk.ijse.Layerd.dto.EmployeeDto;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

public class EmployeeFormController {

    @FXML
    private AnchorPane EmployeePane;

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
    private TableColumn<?, ?> columnE_ID;

    @FXML
    private TableColumn<?, ?> columnJobTitle;

    @FXML
    private TableColumn<?, ?> columnName;

    @FXML
    private TableColumn<?, ?> columnTelephone;

    @FXML
    private TableView<EmployeeDto> tableEmployee;

    @FXML
    private TextField txtE_ID;

    @FXML
    private TextField txtJobTitle;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtTelephone;

    EmployeeDAO employeeDAO=new lk.ijse.Layerd.dao.custom.Impl.EmployeeModel();

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/DashBoardForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)EmployeePane.getScene().getWindow();
        stage1.close();


    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();

    }

    private void clearFields() {
        txtE_ID.setText("");
        txtName.setText("");
        txtJobTitle.setText("");
        txtTelephone.setText("");
    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {

        Parent root=FXMLLoader.load(this.getClass().getResource("/view/CustomerForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)EmployeePane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/DashBoardForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)EmployeePane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String E_ID= txtE_ID.getText();
        //var model=new EmployeeModel();


        try{
          //  boolean isDeleted= model.deleteEmployee(E_ID);
            boolean isDeleted=employeeDAO.delete(E_ID);
            if(isDeleted){
                tableEmployee.refresh();
                new Alert(Alert.AlertType.CONFIRMATION,"Employee deleted ").show();
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

        Stage stage1=(Stage)EmployeePane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnEmployeeOnAction(ActionEvent event) {


    }

    @FXML
    void btnEmployeeSalaryOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/EmployeeSalaryManageForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)EmployeePane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/LoginForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)EmployeePane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnOrderDetailsOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/OrderDetailsForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)EmployeePane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnOrdersOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/OrdersForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)EmployeePane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnProductOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/ProductForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) EmployeePane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnRawMaterialsOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/RawMaterialsForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) EmployeePane.getScene().getWindow();
        stage1.close();

    }

    /////
    public void initialize() throws SQLException {
        setCellValueFactory();
        loadAllEmployee();
      //  calculateEmployeeCount();

    }


   /* private void calculateEmployeeCount() throws SQLException {
        int total = 0;
        for (int i = 0; i <tableEmployee.getItems().size(); i++) {
            total += (int) columnE_ID.getCellData(i);
        }

       // lblEmployeeTotal.setText(String.valueOf(total));

    }*/




    private void setCellValueFactory() {
        columnE_ID.setCellValueFactory(new PropertyValueFactory<>("E_ID"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnJobTitle.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));
        columnTelephone.setCellValueFactory(new PropertyValueFactory<>("tel"));

    }

    private void loadAllEmployee() {
        var model = new EmployeeModel();

        ObservableList<EmployeeDto> obList = FXCollections.observableArrayList();

        try {
            //List<EmployeeDto> dtoList = model.getAllEmployee();
            List<EmployeeDto> dtoList = employeeDAO.getAll();

            for(EmployeeDto dto : dtoList) {
                obList.add(
                        new EmployeeDto(
                                dto.getE_ID(),
                                dto.getName(),
                                dto.getJobTitle(),
                                dto.getTel()
                        )
                );
            }
            tableEmployee.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    ///////

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        boolean isValidated=isEmployeeValidated();
       if(isValidated) {
           String E_ID = txtE_ID.getText();
           String name = txtName.getText();
           String job = txtJobTitle.getText();
           String tel = txtTelephone.getText();

           var dto = new EmployeeDto(E_ID, name, job, tel);
         //  var model = new EmployeeModel();
           try {
              // boolean isSaved = model.saveEmployee(dto);
               boolean isSaved=employeeDAO.save(dto);
               if (isSaved) {
                   new Alert(Alert.AlertType.CONFIRMATION, "Employee is saved ").showAndWait();

                   ////
                   Parent root= FXMLLoader.load(this.getClass().getResource("/view/EmployeeForm.fxml"));
                   Scene scene=new Scene(root);
                   Stage stage = new Stage();
                   stage.setScene(scene);
                   stage.show();

                   Stage stage1 = (Stage) EmployeePane.getScene().getWindow();
                   stage1.close();


               }
           } catch (Exception e) {
               new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
           }

       }
        ////
        InputStream resource = this.getClass().getResourceAsStream("/report/EmployeeDetailsReport.jrxml");
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(resource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DbConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /////



       //else{
        //           new Alert(Alert.AlertType.ERROR,"Employee details invalid,try again!").show();
        //       }


    }

    private boolean isEmployeeValidated() {

//1)
        String id=txtE_ID.getText();
        boolean isE_IdValidated= Pattern.matches("[E][0-9]{3,}",id);

 //2)
        String name=txtName.getText();
        boolean isNameValidated=Pattern.matches("[A-Za-z]{3,}",name);

  //3)
        String jobTitle =txtJobTitle.getText();
        boolean isTitleValidated=Pattern.matches("[A-Za-z]{2,}",jobTitle);

  //4)

        String Tel =txtTelephone.getText();
        boolean isTelValidated=Pattern.matches("[0]\\d{9}",Tel);


        if(!isE_IdValidated){
            new Alert(Alert.AlertType.ERROR,"invalid Employee id").show();
            txtE_ID.requestFocus();
            return false;

        }


        else if(!isNameValidated){
            new Alert(Alert.AlertType.ERROR,"invalid name").show();
            txtName.requestFocus();
            return  false;
        }


        else if(!isTitleValidated){
            new Alert(Alert.AlertType.ERROR,"invalid title for job").show();
            txtJobTitle.requestFocus();
            return  false;
        }

        else if(!isTelValidated){
            new Alert(Alert.AlertType.ERROR,"invalid telephone number").show();
            txtTelephone.requestFocus();
            return  false;

        }else {
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

        Stage stage1=(Stage)EmployeePane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

        boolean isValidated=isEmployeeValidated();
        if(isValidated) {
            String E_ID = txtE_ID.getText();
            String name = txtName.getText();
            String tel = txtTelephone.getText();
            String job = txtJobTitle.getText();

            var dto = new EmployeeDto(E_ID, name, job, tel);
           // var model = new EmployeeModel();
            try {
               // boolean isUpdated = model.updateEmployee(dto);

                boolean isUpdated=employeeDAO.update(dto);
                if (isUpdated) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Employee is Updated").showAndWait();
                    /////

                    Parent root= FXMLLoader.load(this.getClass().getResource("/view/EmployeeForm.fxml"));
                    Scene scene=new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();

                    Stage stage1 = (Stage) EmployeePane.getScene().getWindow();
                    stage1.close();
                    /////
                }
            } catch (SQLException | IOException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }else{
            new Alert(Alert.AlertType.ERROR, "can't update because,employee details are incorrect").show();
        }

    }

    @FXML
    void txtE_IDOnAction(ActionEvent event) {
        String id = txtE_ID.getText();

        var model = new EmployeeModel();
        try {
          //  EmployeeDto dto = model.searchEmployee(id);
            EmployeeDto dto=employeeDAO.search(id);

            if(dto != null) {
                fillFields(dto);
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Employee not found!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    private void fillFields(EmployeeDto dto) {
        txtE_ID.setText(dto.getE_ID());
        txtName.setText(dto.getName());
        txtJobTitle.setText(dto.getJobTitle());
        txtTelephone.setText(dto.getTel());

    }



    @FXML
    void txtJobTitleOnAction(ActionEvent event) {

    }

    @FXML
    void txtNameOnAction(ActionEvent event) {

    }

    @FXML
    void txtTelephoneOnAction(ActionEvent event) {

    }

}

