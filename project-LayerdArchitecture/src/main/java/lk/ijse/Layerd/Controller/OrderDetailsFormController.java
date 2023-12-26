package lk.ijse.Layerd.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import lk.ijse.Layerd.dao.custom.CustomerDAO;
import lk.ijse.Layerd.dao.custom.Impl.CustomerModel;
import lk.ijse.Layerd.dao.custom.Impl.OrdersModel;
import lk.ijse.Layerd.dao.custom.Impl.PlaceOrderModel;
import lk.ijse.Layerd.dao.custom.Impl.ProductModel;
import lk.ijse.Layerd.dao.custom.OrdersDAO;
import lk.ijse.Layerd.dao.custom.ProductDAO;
import lk.ijse.Layerd.db.DbConnection;
import lk.ijse.Layerd.dto.CustomerDto;
import lk.ijse.Layerd.dto.PlaceOrderDto;
import lk.ijse.Layerd.dto.ProductDto;
import lk.ijse.Layerd.view.tdm.CartTm;
import lk.ijse.Layerd.view.tdm.CustomerTm;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderDetailsFormController {
    /*private final CustomerModel customerModel = new CustomerModel();
    private final ProductModel itemModel = new ProductModel();
    private final OrdersModel orderModel = new OrdersModel();*/

    CustomerDAO customerDAO=new CustomerModel();
    ProductDAO productDAO=new ProductModel();

    OrdersDAO ordersDAO=new OrdersModel();
    private final ObservableList<CartTm> obList = FXCollections.observableArrayList();

    @FXML
    private JFXButton btnReport;

    @FXML
    private JFXButton btnAddToCart;

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnCustomer;

    @FXML
    private JFXButton btnDashboard;

    @FXML
    private JFXButton btnDelivery;

    @FXML
    private JFXButton btnEmployee;

    @FXML
    private JFXButton btnEmployeeSalary;

    @FXML
    private JFXButton btnLOgOut;

    @FXML
    private JFXButton btnOrderDetails;

    @FXML
    private JFXButton btnOrders;

    @FXML
    private JFXButton btnPlaceOrder;

    @FXML
    private JFXButton btnProduct;

    @FXML
    private JFXButton btnRawMaterials;

    @FXML
    private JFXButton btnSupplier;

    @FXML
    private JFXComboBox<String> cmbCustomerId;

    @FXML
    private JFXComboBox<String> cmbItemCode;

    @FXML
    private TableColumn<?, ?> colAction;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private AnchorPane pane;

    @FXML
    private TableView<CartTm> tblOrderCart;

    @FXML
    private TextField txtQty;

    @FXML
    private Label lblCode;

    @FXML
    private Label lblCustomerName;

    @FXML
    private Label lblCustomer_ID;

    @FXML
    private Label lblDescription;

    @FXML
    private Label lblNetTotal;

    @FXML
    private Label lblOrderDate;

    @FXML
    private Label lblOrderId;

    @FXML
    private Label lblQty;

    @FXML
    private Label lblQtyOnHand;

    @FXML
    private Label lblUnitPrice;

    private final PlaceOrderModel placeOrderModel = new PlaceOrderModel();

    public void initialize() {
        setCellValueFactory();
        generateNextOrderId();
        setDate();
        loadCustomerIds();
        loadItemCodes();

    }



    private void setCellValueFactory() {
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("tot"));
        colAction.setCellValueFactory(new PropertyValueFactory<>("btn"));
    }
    private void generateNextOrderId() {
        try {
            //String orderId = orderModel.generateNextOrderId();

            String orderId = ordersDAO.generateNextOrderId();
            lblOrderId.setText(orderId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void loadItemCodes() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
           // List<ProductDto> itemList = itemModel.loadAllProduct();

            List<ProductDto> itemList = productDAO.loadAllProduct();

            for (ProductDto  itemDto : itemList) {
                obList.add(itemDto.getProduct_ID());
            }

            cmbItemCode.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadCustomerIds() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
           // List<CustomerTm> cusList = customerModel.loadAllCustomers();

            List<CustomerTm> cusList = customerDAO.loadAllCustomers();

            for (CustomerTm Tm : cusList) {
                obList.add(Tm.getC_ID());
            }
            cmbCustomerId.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void setDate() {
        String date = String.valueOf(LocalDate.now());
        lblOrderDate.setText(date);
    }

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {
        String code = cmbItemCode.getValue();
        String description = lblDescription.getText();
        int qty = Integer.parseInt(txtQty.getText());
        double unitPrice = Double.parseDouble(lblUnitPrice.getText());
        double total = qty * unitPrice;
        Button btn = new Button("remove");
        btn.setCursor(Cursor.HAND);

        btn.setOnAction((e) -> {
            ButtonType yes = new ButtonType("yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("no", ButtonBar.ButtonData.CANCEL_CLOSE);

            Optional<ButtonType> type = new Alert(Alert.AlertType.INFORMATION, "Are you sure to remove?", yes, no).showAndWait();

            if (type.orElse(no) == yes) {
                int index = tblOrderCart.getSelectionModel().getSelectedIndex();
                obList.remove(index);
                tblOrderCart.refresh();

                calculateNetTotal();
            }
        });

        for (int i = 0; i < tblOrderCart.getItems().size(); i++) {
            if (code.equals(colItemCode.getCellData(i))) {
                qty += (int) colQty.getCellData(i);
                total = qty * unitPrice;

                obList.get(i).setQty(qty);
                obList.get(i).setTot(total);

                tblOrderCart.refresh();
                calculateNetTotal();
                return;
            }
        }

        obList.add(new CartTm(
                code,
                description,
                qty,
                unitPrice,
                total,
                btn
        ));

        tblOrderCart.setItems(obList);
        calculateNetTotal();
        txtQty.clear();

    }

    private void calculateNetTotal() {
        double total = 0;
        for (int i = 0; i < tblOrderCart.getItems().size(); i++) {
            total += (double) colTotal.getCellData(i);
        }

        lblNetTotal.setText(String.valueOf(total));
    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/DashBoardForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)pane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/CustomerForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)pane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/DashBoardForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)pane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnDeliveryOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/DeliveryForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)pane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnEmployeeOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/EmployeeForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)pane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnEmployeeSalaryOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/EmployeeSalaryManageForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)pane.getScene().getWindow();
        stage1.close();


    }

    @FXML
    void btnLOgOutOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/LoginForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)pane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnNewCustomerOnAction(ActionEvent event) throws IOException {
        Parent anchorPane = FXMLLoader.load(this.getClass().getResource("/view/CustomerForm.fxml"));
        Scene scene = new Scene(anchorPane);

        Stage stage = new Stage();
        stage.setTitle("Customer Manage");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    @FXML
    void btnOrderDetailsOnAction(ActionEvent event) {

    }

    @FXML
    void btnOrdersOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/OrdersForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)pane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {

        String orderId = lblOrderId.getText();
        String cusId = cmbCustomerId.getValue();
        LocalDate date = LocalDate.parse(lblOrderDate.getText());



        List<CartTm> tmList = new ArrayList<>();

        for (CartTm cartTm : obList) {
            tmList.add(cartTm);
        }

        PlaceOrderDto placeOrderDto = new PlaceOrderDto(
                orderId,
                cusId,
                date,
                tmList
        );

        try {
            boolean isSuccess = placeOrderModel.placeOrder(placeOrderDto);
            if(isSuccess) {
                new Alert(Alert.AlertType.CONFIRMATION, "order completed!").showAndWait();


            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }


    }

    @FXML
    void btnProductOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/ProductForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) pane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnRawMaterialsOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/RawMaterialsForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage)pane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnSupplierOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/SupplierForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)pane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void cmbCustomerOnAction(ActionEvent event) throws SQLException {
        String id = cmbCustomerId.getValue();
       // CustomerDto dto = customerModel.searchCustomer(id);

        CustomerDto dto = customerDAO.searchCustomer(id);
        lblCustomerName.setText(dto.getName());

    }

    @FXML
    void cmbItemOnAction(ActionEvent event) {
        String code =  cmbItemCode.getValue();

        txtQty.requestFocus();

        try {
          // ProductDto  dto = itemModel.searchProduct(code);

            ProductDto  dto = productDAO.search(code);

            lblDescription.setText(dto.getDescription());
            lblUnitPrice.setText(String.valueOf(dto.getPrice()));
            lblQtyOnHand.setText(String.valueOf(dto.getQuantityOnStock()));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void txtQtyOnAction(ActionEvent event) {
        btnAddToCartOnAction(event);

    }
    @FXML
    void btnReportOnAction(ActionEvent event) {

        InputStream resource = this.getClass().getResourceAsStream("/report/PlaceOrderForm2003.jrxml");
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(resource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DbConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

