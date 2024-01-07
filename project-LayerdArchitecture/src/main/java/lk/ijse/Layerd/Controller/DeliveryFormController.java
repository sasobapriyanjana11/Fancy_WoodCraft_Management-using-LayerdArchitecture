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

import lk.ijse.Layerd.bo.custom.DeliveryBO;
import lk.ijse.Layerd.bo.custom.EmployeeBO;
import lk.ijse.Layerd.bo.custom.Impl.DeliveryBOImpl;
import lk.ijse.Layerd.bo.custom.Impl.EmployeeBOImpl;
import lk.ijse.Layerd.dao.custom.DeliveryDAO;
import lk.ijse.Layerd.dao.custom.EmployeeDAO;
import lk.ijse.Layerd.dao.custom.Impl.DeliveryModel;
import lk.ijse.Layerd.dao.custom.Impl.EmployeeModel;
import lk.ijse.Layerd.dao.custom.Impl.OrderDetailModel;
import lk.ijse.Layerd.dao.custom.Impl.OrdersModel;
import lk.ijse.Layerd.dto.DeliveryDto;
import lk.ijse.Layerd.dto.EmployeeDto;
import lk.ijse.Layerd.dto.OrderDto;
import lk.ijse.Layerd.entity.Employee;
import lk.ijse.Layerd.view.tdm.DeliveryTm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

public class DeliveryFormController {

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
    private JFXButton btnSupplier;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableColumn<?, ?> columnDeliveryStatus;

    @FXML
    private TableColumn<?, ?> columnDelivery_ID;

    @FXML
    private TableColumn<?, ?> columnE_ID;

    @FXML
    private TableColumn<?, ?> columnLocation;

    @FXML
    private TableColumn<?, ?> columnOrder_ID;

    @FXML
    private TableView<DeliveryTm> tableDelivery;

    @FXML
    private TextField txtDelivery_ID;

    @FXML
    private TextField txtE_ID;

    @FXML
    private TextField txtLocation;

    @FXML
    private TextField txtOrder_ID;

    @FXML
    private TextField txtDeliveryStatus;

    @FXML
    private TextField txtOrder_IDOnAction;

    @FXML
    private TextField txtTelephone;

    @FXML
    private AnchorPane DeliveryPane;

    @FXML
    private ComboBox<String> cmbE_ID;

    @FXML
    private ComboBox<String> cmbOrder_ID;

    private final EmployeeModel employeeModel=new EmployeeModel();
   private  final OrderDetailModel orderDetailModel=new OrderDetailModel();
      EmployeeDAO employeeDAO=new EmployeeModel();
   private final OrdersModel ordersModel=new OrdersModel();


   // DeliveryDAO deliveryDAO=new lk.ijse.Layerd.dao.custom.Impl.DeliveryModel();
    DeliveryBO deliveryBO=new DeliveryBOImpl();
    EmployeeBO employeeBO=new EmployeeBOImpl();

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/DashBoardForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)DeliveryPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        txtTelephone.setText("");
        txtLocation.setText("");
        txtDeliveryStatus.setText("");
    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/CustomerForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)DeliveryPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/DashBoardForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)DeliveryPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String Delivery_ID= txtDelivery_ID.getText();
       // var model=new DeliveryModel();
        try{
           // boolean isDeleted= model.deleteDelivery(Delivery_ID);

          //  boolean isDeleted=deliveryDAO.delete(Delivery_ID);
            boolean isDeleted=deliveryBO.deleteDelivery(Delivery_ID);
            if(isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION,"Delivery details deleted").show();
                tableDelivery.refresh();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }

    }

    @FXML
    void btnDeliveryOnAction(ActionEvent event) {


    }

    @FXML
    void btnEmployeeOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/EmployeeForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)DeliveryPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnEmployeeSalaryOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/EmployeeSalaryManageForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)DeliveryPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/LoginForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)DeliveryPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnOrderDetailsOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/OrderDetailsForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)DeliveryPane.getScene().getWindow();
        stage1.close();
    }

    @FXML
    void btnOrdersOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/OrdersForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)DeliveryPane.getScene().getWindow();
        stage1.close();


    }

    @FXML
    void btnProductOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/ProductForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) DeliveryPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnRawMaterialsOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/RawMaterialsForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) DeliveryPane.getScene().getWindow();
        stage1.close();

    }
    public void initialize() {
        setCellValueFactory();
        loadAllE_ID();
        loadAllOrder_ID();
        loadAllDelivery();
    }

    private void loadAllOrder_ID() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            List<OrderDto> cusList = ordersModel.loadAllOrder_ID();


            for (OrderDto dto : cusList) {
                obList.add(dto.getOrder_ID());
            }
            cmbOrder_ID .setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void loadAllE_ID() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
           //List<EmployeeDto> cusList = employeeDAO.loadAllEmployee();
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
        columnDelivery_ID.setCellValueFactory(new PropertyValueFactory<>("Delivery_ID"));
        columnOrder_ID.setCellValueFactory(new PropertyValueFactory<>("Order_ID"));
        columnE_ID.setCellValueFactory(new PropertyValueFactory<>("E_ID"));
        columnDeliveryStatus.setCellValueFactory(new PropertyValueFactory<>("deliveryStatus"));
        columnLocation.setCellValueFactory(new PropertyValueFactory<>("location"));

    }

    private void loadAllDelivery() {
        var model = new DeliveryModel();

        ObservableList<DeliveryTm> obList = FXCollections.observableArrayList();

        try {
           // List<DeliveryDto> dtoList = model.getAllDelivery();
          //  List<DeliveryDto> dtoList = deliveryDAO.getAll();
            List<DeliveryDto> dtoList = deliveryBO.getAllDelivery();

            for(DeliveryDto dto: dtoList) {
                obList.add(
                        new DeliveryTm(
                                dto.getDelivery_ID(),
                                dto.getOrder_ID(),
                                dto.getDelivery_Status(),
                                dto.getLocation(),
                                dto.getE_ID()

                        )
                );
            }
            tableDelivery.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        boolean isValidated=isDeliveryValidated();
       if(isValidated) {
           String Delivery_ID = txtDelivery_ID.getText();
           String Order_ID = cmbOrder_ID.getValue();
           String DeliveryStatus = txtDeliveryStatus.getText();
           String Location = txtLocation.getText();
           String E_ID = cmbE_ID.getValue();
           String Tel = txtTelephone.getText();


           var dto = new DeliveryDto(Delivery_ID,Order_ID,DeliveryStatus,Location,E_ID,Tel);
          // var model = new DeliveryModel();
           try {
              // boolean isSaved = model.saveDeliveryDetails(dto);

              // boolean isSaved=deliveryDAO.save(dto);
               boolean isSaved= deliveryBO.saveDeliveryDetails(dto);
               if (isSaved) {
                   new Alert(Alert.AlertType.CONFIRMATION, "Delivery details are saved successfully").showAndWait();

                   /////
                   Parent root= FXMLLoader.load(this.getClass().getResource("/view/DeliveryForm.fxml"));
                   Scene scene=new Scene(root);
                   Stage stage = new Stage();
                   stage.setScene(scene);
                   stage.show();

                   Stage stage1 = (Stage) DeliveryPane.getScene().getWindow();
                   stage1.close();
                   /////

               }
           } catch (SQLException | IOException e) {
               new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
           }
       }else{
           new Alert(Alert.AlertType.ERROR,"invalid delivery details included,try again!").show();
       }

    }

    private boolean isDeliveryValidated() {
//1)
        String id=txtDelivery_ID.getText();
        boolean isDeliveryIdValidated= Pattern.matches("[D][0-9]{3,}",id);

 //2)
        String location=txtLocation.getText();
        boolean isLocationValidated=Pattern.matches("[A-Za-z ]+",location);

 //3)
        String tel=txtTelephone.getText();
        boolean isTelValidated=Pattern.matches("[0-9]{10}",tel);

        if(!isDeliveryIdValidated){
            new Alert(Alert.AlertType.ERROR,"invalid Delivery id").show();
            txtDelivery_ID.requestFocus();
            return false;

        }


        else if(!isLocationValidated) {
            new Alert(Alert.AlertType.ERROR, "invalid delivery location").show();
            txtLocation.requestFocus();
            return false;
        }

        else if (!isTelValidated){
            new Alert(Alert.AlertType.ERROR,"invalid delivery tel").show();
            txtTelephone.requestFocus();
            return  false;

        }else {

            return true;
        }
    }

    @FXML
    void btnSupplierOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/SupplierForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)DeliveryPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

        boolean isValidated=isDeliveryValidated();
        if (isValidated) {
            String Delivery_ID = txtDelivery_ID.getText();
            String E_ID = cmbE_ID.getValue();
            String Location = txtLocation.getText();
            String Tel = txtTelephone.getText();
            String Order_ID = cmbOrder_ID.getValue();
            String deliveryStatus = txtDeliveryStatus.getText();

            var dto = new DeliveryDto(Delivery_ID,Order_ID,deliveryStatus,Location,E_ID,Tel);
           // var model = new DeliveryModel();
            try {
               // boolean isUpdated = model.updateDeliveryDetails(dto);

               // boolean isUpdated=deliveryDAO.update(dto);
                boolean isUpdated= deliveryBO.updateDeliveryDetails(dto);
                if (isUpdated) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Delivery details are updated").showAndWait();


                    /////
                    Parent root= FXMLLoader.load(this.getClass().getResource("/view/DeliveryForm.fxml"));
                    Scene scene=new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();

                    Stage stage1 = (Stage) DeliveryPane.getScene().getWindow();
                    stage1.close();
                    /////
                }

            } catch (SQLException | IOException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }else{
            new Alert(Alert.AlertType.ERROR, "can't update because delivery details are incorrect").show();
        }

    }

    @FXML
    void cmbE_IDOnAction(ActionEvent event) {

    }

    @FXML
    void cmbOrder_IDOnAction(ActionEvent event) {

    }
    @FXML
    void txtDelivery_IDOnAction(ActionEvent event) {
        String id = txtDelivery_ID.getText();

       // var model = new DeliveryModel();
        try {
         //   DeliveryDto dto = model.searchDelivery(id);
         //   DeliveryDto dto=deliveryDAO.search(id);
            DeliveryDto dto=deliveryBO.searchDelivery(id);

            if(dto != null) {
                fillFields(dto);
            } else {
                new Alert(Alert.AlertType.INFORMATION, "that delivery details  not found!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    private void fillFields(DeliveryDto dto) {
        txtDelivery_ID.setText(dto.getDelivery_ID());
        txtLocation.setText(dto.getLocation());
        txtTelephone.setText(dto.getTel());
        txtDeliveryStatus.setText(dto.getDelivery_Status());

    }



    @FXML
    void txtE_IDOnAction(ActionEvent event) {

    }

    @FXML
    void txtLocationOnAction(ActionEvent event) {

    }

    @FXML
    void txtTelephoneOnAction(ActionEvent event) {

    }

    @FXML
    void txtDeliveryStatusOnAction(ActionEvent event) {

    }
    @FXML
    void txtOrder_IDOnAction(ActionEvent event) {

    }

}

