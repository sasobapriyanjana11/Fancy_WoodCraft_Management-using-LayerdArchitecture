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
import lk.ijse.Layerd.bo.custom.CustomerBO;
import lk.ijse.Layerd.bo.custom.Impl.CustomerBOImpl;
import lk.ijse.Layerd.bo.custom.Impl.OrdersBOImpl;
import lk.ijse.Layerd.bo.custom.OrdersBO;
import lk.ijse.Layerd.dto.CustomerDto;
import lk.ijse.Layerd.view.tdm.OrdersTm;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

public class OrdersFormController {

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
    private TableColumn<?, ?> columnC_ID;

    @FXML
    private TableColumn<?, ?> columnDate;

    @FXML
    private TableColumn<?, ?> columnOrder_ID;

    @FXML
    private TableColumn<?, ?> columnPayment;

    @FXML
    private TableColumn<?, ?> columnRatings;

    @FXML
    private AnchorPane ordersPane;

    @FXML
    private TableView<OrdersTm> tableOrders;

    @FXML
    private TextField txtC_ID;

    @FXML
    private DatePicker txtDate;

    @FXML
    private TextField txtOrder_ID;

    @FXML
    private TextField txtPayments;


    @FXML
    private ComboBox<String> cmbC_ID;


    @FXML
    private JFXButton btnNew;

    //private final CustomerModel customerModel=new CustomerModel();

   // CustomerDAO customerDAO=new CustomerModel();
    CustomerBO customerBO=new CustomerBOImpl();
   // OrdersDAO ordersDAO=new OrdersModel();
    OrdersBO ordersBO=new OrdersBOImpl();



    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("/view/DashBoardForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)ordersPane.getScene().getWindow();
        stage1.close();
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();

    }

    private void clearFields() {
        txtC_ID.setText("");
        txtOrder_ID.setText("");
        txtPayments.setText("");

    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/CustomerForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)ordersPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/DashBoardForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)ordersPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String Order_ID= txtOrder_ID.getText();
       // var model=new OrdersModel();

        try{
           // boolean isDeleted= model.deleteOrders(Order_ID);
          //  boolean isDeleted=ordersDAO.delete(Order_ID);
            boolean isDeleted=ordersBO.deleteOrders(Order_ID);
            if(isDeleted){
                tableOrders.refresh();
                new Alert(Alert.AlertType.CONFIRMATION,"order is   deleted ").show();
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

        Stage stage1=(Stage)ordersPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnEmployeeOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/EmployeeForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)ordersPane.getScene().getWindow();
        stage1.close();
    }

    @FXML
    void btnEmployeeSalaryOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/EmployeeSalaryManageForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)ordersPane.getScene().getWindow();
        stage1.close();
    }


    @FXML
    void btnNewOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/CustomerForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)ordersPane.getScene().getWindow();
        stage1.close();


    }

    @FXML
    void btnOrderDetailsOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/OrderDetailsForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)ordersPane.getScene().getWindow();
        stage1.close();
    }

    @FXML
    void btnOrdersOnAction(ActionEvent event) {

    }

    @FXML
    void btnProductOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/ProductForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) ordersPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnRawMaterialsOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/RawMaterialsForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) ordersPane.getScene().getWindow();
        stage1.close();

    }
    //////
    public void initialize() {
        setCellValueFactory();
        loadAllC_ID();
        loadAllOrders();
    }

    private void loadAllC_ID() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
          //  List<CustomerDto> cusList = customerModel.getAllCustomers();

           // List<CustomerDto> cusList = customerDAO.getAllCustomers();
            List<CustomerDto> cusList = customerBO.getAllCustomers();

            for (CustomerDto dto : cusList) {
                obList.add(dto.getC_ID());
            }
            cmbC_ID.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        columnOrder_ID.setCellValueFactory(new PropertyValueFactory<>("Order_ID"));
        columnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        columnC_ID.setCellValueFactory(new PropertyValueFactory<>("C_ID"));
    }

    private void loadAllOrders() {
      //  var model = new OrdersModel();

        ObservableList<OrdersTm> obList = FXCollections.observableArrayList();

        try {
           // List<OrdersTm> dtoList = model.getAllOrders();

           // List<OrdersTm> dtoList = ordersDAO.getAll();
            List<OrdersTm> dtoList = ordersBO.getAllOrders();
            for(OrdersTm Tm: dtoList) {
                obList.add(
                        new OrdersTm(
                                Tm.getOrder_ID(),
                                Tm.getC_ID(),
                                Tm.getDate()
                        )
                );
            }
            tableOrders.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    ///////

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        boolean isValidated=isOrderDetailsAreValidate();
        if(isValidated) {
            String Order_ID = txtOrder_ID.getText();
            String C_ID = cmbC_ID.getValue();
            LocalDate date = txtDate.getValue();

            var Tm = new OrdersTm(Order_ID,C_ID,date);

           // var model = new OrdersModel();
            try {
              //  boolean isSaved = model.saveOrders(Tm);
               // boolean isSaved=ordersDAO.save(Tm);
                boolean isSaved=ordersBO.saveOrders(Tm);


                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Order saved ").showAndWait();

                    ////
                    Parent root= FXMLLoader.load(this.getClass().getResource("/view/OrdersForm.fxml"));
                    Scene scene=new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();

                    Stage stage1 = (Stage) ordersPane.getScene().getWindow();
                    stage1.close();
                    ////
                }
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }else{
            new Alert(Alert.AlertType.ERROR, "invalid order details,try again!").show();
        }

    }

    private boolean isOrderDetailsAreValidate() {

 //1)
        String O_ID=txtOrder_ID.getText();
        boolean isOrder_IDValidated=Pattern.matches("[O][0-9]{3,}",O_ID);


        if(!isOrder_IDValidated){
            new Alert(Alert.AlertType.ERROR, "invalid order id").show();
            txtOrder_ID.requestFocus();
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

        Stage stage1=(Stage)ordersPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        boolean isValidated=isOrderDetailsAreValidate();
        if(isValidated) {

            String Order_ID = txtOrder_ID.getText();
            String C_ID = cmbC_ID.getValue();
            LocalDate date = txtDate.getValue();

            var Tm = new OrdersTm(Order_ID,C_ID,date);

           // var model = new OrdersModel();

            try {
                // boolean isUpdated = model.updateOrders(Tm);

               // boolean isUpdated=ordersDAO.update(Tm);
                boolean isUpdated=ordersBO.updateOrders(Tm);
                if (isUpdated) {
                    new Alert(Alert.AlertType.CONFIRMATION, "order Updated").showAndWait();
                    ////
                    Parent root= FXMLLoader.load(this.getClass().getResource("/view/OrdersForm.fxml"));
                    Scene scene=new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();

                    Stage stage1 = (Stage) ordersPane.getScene().getWindow();
                    stage1.close();
                    ////
                }
            } catch (SQLException | IOException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }else{
            new Alert(Alert.AlertType.ERROR,"can't update,invalid  order details").show();
        }

    }

    @FXML
    void cmbC_IDOnAction(ActionEvent event) {

    }

    @FXML
    void txtDateOnAction(ActionEvent event) {

    }

    @FXML
    void txtOrder_IDOnAction(ActionEvent event) {
        String id = txtOrder_ID.getText();

       // var model = new OrdersModel();
        try {
           // OrdersTm  Tm = model.searchOrder(id);
           // OrdersTm  Tm = ordersDAO.search(id);
            OrdersTm  Tm = ordersBO.searchOrder(id);

            if(Tm != null) {
                fillFields(Tm);
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Order not found!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            new Alert(Alert.AlertType.ERROR, "Something went wrong").show();

        }

    }

    private void fillFields(OrdersTm  Tm) {
        txtOrder_ID.setText(Tm.getOrder_ID());
        String date = String.valueOf(LocalDate.now());
        txtDate.setId(date);
        txtC_ID.setText(Tm.getC_ID());

    }


}

