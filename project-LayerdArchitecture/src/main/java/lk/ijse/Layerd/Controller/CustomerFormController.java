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

import lk.ijse.Layerd.bo.custom.CustomerBO;
import lk.ijse.Layerd.bo.custom.Impl.CustomerBOImpl;
import lk.ijse.Layerd.dao.custom.Impl.CustomerImpl;
import lk.ijse.Layerd.dao.custom.Impl.OrdersImpl;
import lk.ijse.Layerd.dto.CustomerDto;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.regex.Pattern;

public class CustomerFormController {
    //now

    @FXML
    private AnchorPane CustomerPane;

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
    private JFXButton btnLogout;

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
    private JFXButton btnSuppplier;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableColumn<?, ?> columnAddress;

    @FXML
    private TableColumn<?, ?> columnC_ID;

    @FXML
    private TableColumn<?, ?> columnLoyalatyStatus;

    @FXML
    private TableColumn<?, ?> columnName;

    @FXML
    private TableColumn<?, ?> columnTelephone;

    @FXML
    private TableView<CustomerDto> tableCustomer;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtC_ID;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtTelephone;

    private  final OrdersImpl ordersModel=new OrdersImpl();

 //   CustomerDAO customerDAO=new lk.ijse.Layerd.dao.custom.Impl.CustomerModel();
     CustomerBO customerBO=new CustomerBOImpl();

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/LoginForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)CustomerPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();

    }

    private void clearFields() {
        txtC_ID.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtTelephone.setText("");
    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) {}

    @FXML
    void btnDashboardOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/DashBoardForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)CustomerPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

        String C_ID=  txtC_ID.getText();
       // var model=new CustomerModel();
        try {
           // boolean isDeleted= model.deleteCustomer(C_ID);

           // boolean isDeleted=customerDAO.deleteCustomer(C_ID);
            boolean isDeleted=customerBO.deleteCustomer(C_ID);
            if(isDeleted){
                tableCustomer.refresh();
                new Alert(Alert.AlertType.CONFIRMATION,"Customer deleted successfully").show();
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

        Stage stage1=(Stage)CustomerPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnEmployeeOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/EmployeeForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)CustomerPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnEmployeeSalaryOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/EmployeeSalaryManageForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)CustomerPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/LoginForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)CustomerPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnOrderDetailsOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/OrderDetailsForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)CustomerPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnOrdersOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/OrdersForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)CustomerPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnProductOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/ProductForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) CustomerPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnRawMaterialsOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/RawMaterialsForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) CustomerPane.getScene().getWindow();
        stage1.close();

    }
    public void initialize() {
        setCellValueFactory();
        loadAllCustomers();
        setLoyaltyStatus();
    }

    private void setLoyaltyStatus() {

        try{
          int count=  ordersModel.labelCustomerByOrdersCount();
          if(count>=3){
              columnLoyalatyStatus.setText("loyalty customer");
          }else{
              columnLoyalatyStatus.setText("regular customer");
          }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setCellValueFactory() {
        columnC_ID.setCellValueFactory(new PropertyValueFactory<>("C_ID"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        columnTelephone.setCellValueFactory(new PropertyValueFactory<>("tel"));
        columnLoyalatyStatus.setCellValueFactory(new PropertyValueFactory<>("LoyaltyStatus"));
    }

    private void loadAllCustomers() {
      //  var model = new CustomerModel();

        ObservableList<CustomerDto> obList = FXCollections.observableArrayList();

        try {
          //  List<CustomerDto> dtoList = model.getAllCustomers();

           // List<CustomerDto> dtoList=customerDAO.getAllCustomers();
            List<CustomerDto> dtoList=customerBO.getAllCustomers();

            for(CustomerDto dto : dtoList) {
                obList.add(
                        new CustomerDto(
                                dto.getC_ID(),
                                dto.getName(),
                                dto.getAddress(),
                                dto.getLoyaltyStatus(),
                                dto.getTel()

                        )
                );
            }
            tableCustomer.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws SQLException {
        boolean isValidatedCustomer=validateCustomer();

        if(isValidatedCustomer) {
            new Alert(Alert.AlertType.CONFIRMATION, "successfully added").show();

            String C_ID = txtC_ID.getText();
            String name = txtName.getText();
            String Address = txtAddress.getText();
            String Tel = txtTelephone.getText();
            String LoyaltyStatus = columnLoyalatyStatus.getText();
          //  double discountPercentage = determineDiscountPercentage();

           // var dto = new CustomerDto(C_ID, name, Address, LoyaltyStatus, Tel);
          //  discountPercentage
            var dto=new CustomerDto(C_ID, name, Address,LoyaltyStatus,Tel);

           // var model = new CustomerModel();

            try {
               // boolean isSaved = model.saveCustomer(dto);

                //boolean isSaved=customerDAO.saveCustomer(dto);
                boolean isSaved=customerBO.saveCustomer(dto);
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Customer Saved").showAndWait();
                    ////

                    Parent root= FXMLLoader.load(this.getClass().getResource("/view/CustomerForm.fxml"));
                    Scene scene=new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();

                    Stage stage1 = (Stage) CustomerPane.getScene().getWindow();
                    stage1.close();


                }
            } catch (SQLException | IOException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }

    }

    private double determineDiscountPercentage() {
        try {
            boolean isHighSeason = checkHighSeason();
            int orderCount = ordersModel.labelCustomerByOrdersCount();

            if (isHighSeason) {
                if (orderCount >= 3) {
                    return 0.2; // if loyalty customers during high season
                } else {
                    return 0.1; // if regular customers during high season
                }
            } else {
                return 0.0; // No discount if not in high season
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0; // Default to no discount if an exception occurs
        }
    }

    private boolean checkHighSeason() {
        LocalDate currentDate = LocalDate.now();
        Month currentMonth = currentDate.getMonth();

        return (currentMonth == Month.DECEMBER || currentMonth == Month.JANUARY || currentMonth == Month.FEBRUARY || currentMonth == Month.MARCH);

    }

    private boolean validateCustomer() {
//1)
        String id=txtC_ID.getText();
        boolean isCustomerIdValidated= Pattern.matches("[C][0-9]{3,}",id);

 //2)
         String name=txtName.getText();
          boolean isCustomerNameValidated=Pattern.matches("[A-Za-z ]+",name);

  //3)
        String address=txtAddress.getText();
        boolean isAddressValidated=Pattern.matches(".{3,}",address);

 //4)
        String tel=txtTelephone.getText();
        boolean isTelValidated=Pattern.matches("([0-9]){10}",tel);



        if(!isCustomerIdValidated){
            new Alert(Alert.AlertType.ERROR,"invalid customer id").show();
            txtC_ID.requestFocus();
            return false;

        }

       else if (!isCustomerNameValidated) {
            new Alert(Alert.AlertType.ERROR, "invalid Customer name").show();
            txtName.requestFocus();
            return false;
        }

       else if(!isAddressValidated) {
            new Alert(Alert.AlertType.ERROR, "invalid Customer address").show();
            txtAddress.requestFocus();
            return false;
        }


       else if (!isTelValidated){
            new Alert(Alert.AlertType.ERROR,"invalid Customer tel").show();
            txtTelephone.requestFocus();
            return  false;

        }else {

            return true;
        }


    }

    @FXML
    void btnSuppplierOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/SupplierForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)CustomerPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

        boolean isValidated=validateCustomer();
        if(isValidated) {
            String C_ID = txtC_ID.getText();
            String name = txtName.getText();
            String Address = txtAddress.getText();
            String Tel = txtTelephone.getText();
            String LoyaltyStatus = columnLoyalatyStatus.getText();

            var dto = new CustomerDto(C_ID, name, Address, LoyaltyStatus, Tel);
           // var model = new CustomerModel();
            try {
              //  boolean isUpdated = model.updateCustomer(dto);

                //boolean isUpdated=customerDAO.updateCustomer(dto);
                boolean isUpdated=customerBO.updateCustomer(dto);
                if (isUpdated) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Customer is Updated").showAndWait();

                    Parent root=FXMLLoader.load(this.getClass().getResource("/view/CustomerForm.fxml"));
                    Scene scene=new Scene(root);
                    Stage stage=new Stage();
                    stage.setScene(scene);
                    stage.show();

                    Stage stage1=(Stage)CustomerPane.getScene().getWindow();
                    stage1.close();

                }
            } catch (SQLException | IOException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }else{
            new Alert(Alert.AlertType.ERROR, "customer details are incorrect,can't update").show();
        }

    }

    @FXML
    void txtAddressOnAction(ActionEvent event) {

    }

    @FXML
    void txtC_IDOnAction(ActionEvent event) {
        String id = txtC_ID.getText();

        var model = new CustomerImpl();
        try {
          //  CustomerDto dto = model.searchCustomer(id);

           // CustomerDto dto=customerDAO.searchCustomer(id);
            CustomerDto dto=customerBO.searchCustomer(id);

            if(dto != null) {
                fillFields(dto);
            } else {
                new Alert(Alert.AlertType.INFORMATION, "customer not found!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    private void fillFields(CustomerDto dto) {
        txtC_ID.setText(dto.getC_ID());
        txtName.setText(dto.getName());
        txtAddress.setText(dto.getAddress());
        txtTelephone.setText(dto.getTel());

    }

    @FXML
    void txtNameOnAction(ActionEvent event) {

    }

    @FXML
    void txtTelephoneOnAction(ActionEvent event) {

    }

}

