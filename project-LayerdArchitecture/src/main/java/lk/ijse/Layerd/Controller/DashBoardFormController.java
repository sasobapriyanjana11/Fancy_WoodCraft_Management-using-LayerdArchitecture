package lk.ijse.Layerd.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import lk.ijse.Layerd.dao.custom.EmployeeDAO;
import lk.ijse.Layerd.dao.custom.Impl.EmployeeModel;
import lk.ijse.Layerd.dao.custom.Impl.OrdersModel;
import lk.ijse.Layerd.dao.custom.Impl.ProductModel;
import lk.ijse.Layerd.dao.custom.Impl.SupplierModel;
import lk.ijse.Layerd.dao.custom.OrdersDAO;
import lk.ijse.Layerd.dao.custom.ProductDAO;
import lk.ijse.Layerd.dao.custom.SupplierDAO;
import lk.ijse.Layerd.dto.ProductDto;
import lk.ijse.Layerd.dto.SupplierDto;
import lk.ijse.Layerd.view.tdm.productTm;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;


public class DashBoardFormController {

    public javafx.scene.control.Label lblTotal1;
    public javafx.scene.control.Label lblTotal2;

    @FXML
    private PieChart pieChartId;

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
    private JFXButton btnSupplier;

    @FXML
    private AnchorPane dashboardPane;

    @FXML
    private Rectangle employeeTotal;

    @FXML
    private TableView<SupplierDto> tableSupplierDetails;

    @FXML
    private TableColumn<?, ?> columnPName;

    @FXML
    private TableColumn<?, ?> columnProduct_ID;

    @FXML
    private TableView<productTm> tableProductDetails;

    @FXML
    private TableColumn<?, ?> columnName;

    @FXML
    private TableColumn<?, ?> columnTel;

    @FXML
    private TextField txtSearch;

 /*   private final EmployeeModel employeeModel=new EmployeeModel();
    private final SupplierModel supplierModel=new SupplierModel();
    private final OrdersModel ordersModel=new OrdersModel();*/

    SupplierDAO supplierDAO=new SupplierModel();
    OrdersDAO ordersDAO=new OrdersModel();
    EmployeeDAO employeeDAO=new EmployeeModel();

    ProductDAO productDAO=new ProductModel();



    public  void initialize() throws SQLException {
        setCellValueFactory1();
        countEmployeeFrame();
        countDailyOrders();
        viewSupplierTable();
        setCellValueFactory2();
        viewProductTable();

    ObservableList<PieChart.Data> observableList = FXCollections.observableArrayList(
            new PieChart.Data("woodenElephant", 10),
            new PieChart.Data("woodenTrunkUpElephant", 20),
            new PieChart.Data("WoodCarvedMaskPainted", 30),
            new PieChart.Data("WoodCarvedMasked", 40),
            new PieChart.Data("fishManSculpture", 50),
            new PieChart.Data("WoodCarvingElephantPainted", 70),
            new PieChart.Data("buddhaStatue", 100)

    );

    pieChartId.setData(observableList);
    applyCustomColorSequence(
            observableList,
            "aqua",
            "pink",
            "chocolate",
            "red",
            "blue",
            "crimson",
            "yellow"
    );
}

    private void applyCustomColorSequence(ObservableList<PieChart.Data> pieChartData, String... pieColors) {
        int i = 0;
        for (PieChart.Data data : pieChartData) {
            data.getNode().setStyle("-fx-pie-color: " + pieColors[i % pieColors.length] + ";");
            i++;
        }
    }


    private void setCellValueFactory2() {
        columnProduct_ID.setCellValueFactory(new PropertyValueFactory<>("Product_ID"));
        columnPName.setCellValueFactory(new PropertyValueFactory<>("name"));
    }

    private void viewProductTable() {
       // var model = new ProductModel();

        ObservableList<productTm> obList = FXCollections.observableArrayList();

        try {
           // List<ProductDto> dtoList = model.getAllProduct();

            List<ProductDto> dtoList = productDAO.getAll();

            for(ProductDto dto : dtoList) {
                obList.add(
                        new productTm(
                                dto.getProduct_ID(),
                                dto.getName(),
                                dto.getDescription(),
                                dto.getPrice(),
                                dto.getQuantityOnStock()

                        )
                );
            }
            tableProductDetails.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    private void setCellValueFactory1() {
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
    }

    private void viewSupplierTable() {
       // var model = new SupplierModel();

        ObservableList<SupplierDto> obList = FXCollections.observableArrayList();

        try {
         //   List<SupplierDto> dtoList = model.getAllSuppliers();

            List<SupplierDto> dtoList = supplierDAO.getAll();

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
            tableSupplierDetails.setItems(obList);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void countDailyOrders() throws SQLException {
      //  String count2= String.valueOf(ordersModel.countDailyOrders());

        String count2= String.valueOf(ordersDAO.countDailyOrders());
        this.lblTotal2.setText(count2);

    }

    private void countEmployeeFrame() throws SQLException {
        //String count1= String.valueOf(employeeModel.countEmployee());

        String count1= String.valueOf(employeeDAO.countEmployee());
        this.lblTotal1.setText(count1);
    }




    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/CustomerForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)dashboardPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnDashboardOnAction(ActionEvent event)  {
    }

    @FXML
    void btnDeliveryOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/DeliveryForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)dashboardPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnEmployeeOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/EmployeeForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)dashboardPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnEmployeeSalaryOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/EmployeeSalaryManageForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)dashboardPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/LoginForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)dashboardPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnOrderDetailsOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/OrderDetailsForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)dashboardPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnOrdersOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/OrdersForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)dashboardPane.getScene().getWindow();
        stage1.close();


    }

    @FXML
    void btnProductOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/ProductForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage)dashboardPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnRawMaterialsOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/RawMaterialsForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) dashboardPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnSupplierOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/SupplierForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)dashboardPane.getScene().getWindow();
        stage1.close();

    }
    @FXML
    void txtSearchOnAction(ActionEvent event) {

        String searchText = txtSearch.getText();
        System.out.println(" searching for: " + searchText);
        updateDashboard(searchText);
    }

    private void updateDashboard(String searchText) {
        System.out.println("Updating dashboard based on search: " + searchText);
        boolean isHighSeason = isHighSeason();

        if (isHighSeason) {
            new Alert(Alert.AlertType.INFORMATION, "It's High Season!").show();
        }

        // Check if any product is in stock during high season
        checkProductInStock(searchText, isHighSeason);
    }

    private void checkProductInStock(String searchText, boolean isHighSeason) {
        var model = new ProductModel();

        try {
            List<ProductDto> productList = model.searchProductByName(searchText);

            if (productList.isEmpty()) {
                new Alert(Alert.AlertType.INFORMATION, "No product found with the given name.").show();
            } else {
                ProductDto product = productList.get(0);

                // Check if the product is in stock
                if (product.getQuantityOnStock() > 0) {
                    String message = "Product '" + product.getName() + "' is available in stock.";

                    if (isHighSeason) {

                        message += " Additionally, it's High Season!";//if it's high season

                    }

                    new Alert(Alert.AlertType.INFORMATION, message).show();
                } else {
                    new Alert(Alert.AlertType.INFORMATION, "Product '" + product.getName() + "' is out of stock.").show();
                }
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private boolean isHighSeason() {
        LocalDate currentDate = LocalDate.now();
        Month currentMonth = currentDate.getMonth();

        return (currentMonth == Month.DECEMBER || currentMonth == Month.JANUARY || currentMonth == Month.FEBRUARY || currentMonth == Month.MARCH);

    }


}
/*
* #b58333
* #a68f6a
* #80602d
* #593b0c
* #523404
* #3d2907
* #471707
* #8f2806
* #4d0603
* #994e11*/