package lk.ijse.FancyWoodCraftManagement.controller;

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
import lk.ijse.FancyWoodCraftManagement.dto.ProductDto;
import lk.ijse.FancyWoodCraftManagement.dto.tm.productTm;
import lk.ijse.FancyWoodCraftManagement.model.ProductModel;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ProductFormController {

    @FXML
    private TextField txtqty;
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
    private TableColumn<?, ?> columnDescription;

    @FXML
    private TableColumn<?, ?> columnName;

    @FXML
    private TableColumn<?, ?> columnPrice;

    @FXML
    private TableColumn<?, ?> columnProduct_ID;

    @FXML
    private TableColumn<?, ?> columnQuantityOnStock;

    @FXML
    private AnchorPane paneProduct;

    @FXML
    private TableView<productTm> tableProduct;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtProduct_ID;

    @FXML
    private TextField txtProduct_Name;

    @FXML
    private TextField txtQty;


    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/DashBoardForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)paneProduct.getScene().getWindow();
        stage1.close();

    }



    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        txtProduct_ID.setText("");
        txtProduct_Name.setText("");
        txtDescription.setText("");
        txtPrice.setText("");
    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/CustomerForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)paneProduct.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/DashBoardForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)paneProduct.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

        String Product_ID=txtProduct_ID.getText();
        var model=new ProductModel();

        try{
            boolean isDeleted= model.deleteProduct(Product_ID);
            if(isDeleted){
                tableProduct.refresh();
                new Alert(Alert.AlertType.CONFIRMATION,"product is Deleted").show();
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

        Stage stage1=(Stage)paneProduct.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnEmployeeOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/EmployeeForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage) paneProduct.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnEmployeeSalaryOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/EmployeeSalaryManageForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)paneProduct.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/LoginForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)paneProduct.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnOrderDetailsOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(this.getClass().getResource("/view/OrderDetailsForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)paneProduct.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnOrdersOnAction(ActionEvent event) throws IOException {

        Parent root=FXMLLoader.load(this.getClass().getResource("/view/OrdersForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)paneProduct.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnProductOnAction(ActionEvent event) {

    }

    @FXML
    void btnRawMaterialsOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/RawMaterialsForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) paneProduct.getScene().getWindow();
        stage1.close();

    }
    /////
    public void initialize() {
        setCellValueFactory();
        loadAllProduct();
    }
    private void setCellValueFactory() {
        columnProduct_ID.setCellValueFactory(new PropertyValueFactory<>("Product_ID"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        columnQuantityOnStock.setCellValueFactory(new PropertyValueFactory<>("Quantity_On_Stock"));
    }

    private void loadAllProduct() {
        var model = new ProductModel();

        ObservableList<productTm> obList = FXCollections.observableArrayList();

        try {
            List<ProductDto> dtoList = model.getAllProduct();

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
       tableProduct.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    ///////

    @FXML
    void btnSaveOnAction(ActionEvent event) {


        boolean isValidated=isProductValidated();
        if(isValidated) {
            String Product_ID = txtProduct_ID.getText();
            String name = txtProduct_Name.getText();
            String Description = txtDescription.getText();
            Double Price = Double.parseDouble(txtPrice.getText());
            Integer qty = Integer.parseInt(txtqty.getText());



          var Dto = new ProductDto(Product_ID, name, Description, Price,qty);
            var model = new ProductModel();
            try {
                boolean isSaved = model.saveProduct(Dto);

                boolean isPeakSeason = isPeakSeason();
                 List<ProductDto> products;
                products = model.loadAllProduct();
                SeasonalAdjustment.adjustQuantity(products, isPeakSeason);

                // Display adjusted quantities
                for (ProductDto product : products) {
                    System.out.println("Product ID: " + product.getProduct_ID() +
                            ", Adjusted Quantity: " + product.getQuantityOnStock());
                }
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Product saved!").showAndWait();
                    clearFields();

                    ////
                    Parent root= FXMLLoader.load(this.getClass().getResource("/view/ProductForm.fxml"));
                    Scene scene=new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();

                    Stage stage1 = (Stage) paneProduct.getScene().getWindow();
                    stage1.close();
                    /////
                }
            } catch (SQLException | IOException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }else{
            new Alert(Alert.AlertType.ERROR, "invalid product content").show();
        }

    }

    private boolean isPeakSeason() {
        // Adjusted logic for highest seasonal months (December to March)
        LocalDate currentDate = LocalDate.now();
        Month currentMonth = currentDate.getMonth();

        return (currentMonth.compareTo(Month.DECEMBER) >= 0 && currentMonth.compareTo(Month.MARCH) <= 0);

    }

    private boolean isProductValidated() {

 //1)
        String id=txtProduct_ID.getText();
        boolean isProductIdValidated= Pattern.matches("[P][0-9]{3,}",id);

  //2)
        String name=txtProduct_Name.getText();
        boolean isProductNameValidated=Pattern.matches("[A-Za-z]{2,}",name);

 //3)
        String desc=txtDescription.getText();
        boolean isDescValidated=Pattern.matches("[A-Za-z]{1,}+[0-9]{1,}",desc);



        if(!isProductIdValidated){
            new Alert(Alert.AlertType.ERROR,"invalid product id").show();
            txtProduct_ID.requestFocus();
            return false;

        }

        else if (!isProductNameValidated) {
            new Alert(Alert.AlertType.ERROR, "invalid product name").show();
            txtProduct_Name.requestFocus();
            return false;
        }


        else if(!isDescValidated) {
            new Alert(Alert.AlertType.ERROR, "invalid product description content").show();
            txtDescription.requestFocus();
            return false;

        }else {
            return true;
        }
    }

    @FXML
    void btnSupplierOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("/view/SupplierForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)paneProduct.getScene().getWindow();
        stage1.close();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

        boolean isValidated=isProductValidated();
       if(isValidated) {
           String Product_ID = txtProduct_ID.getText();
           String name = txtProduct_Name.getText();
           String Description = txtDescription.getText();
           Double Price = Double.parseDouble(txtPrice.getText());
           Integer qty = Integer.parseInt(txtqty.getText());

           var tm = new productTm(Product_ID, name, Description, Price,qty);
           var model = new ProductModel();

           try {
               boolean isUpdated = model.updateProduct(tm);
               if (isUpdated) {
                   new Alert(Alert.AlertType.CONFIRMATION, "Product updated").showAndWait();

                   ////
                   Parent root= FXMLLoader.load(this.getClass().getResource("/view/ProductForm.fxml"));
                   Scene scene=new Scene(root);
                   Stage stage = new Stage();
                   stage.setScene(scene);
                   stage.show();

                   Stage stage1 = (Stage) paneProduct.getScene().getWindow();
                   stage1.close();
                   /////

               }
           } catch (SQLException | IOException e) {
               new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
           }
       }else{
           new Alert(Alert.AlertType.ERROR, "product details are invalid to update,try again!").show();
       }

    }


    @FXML
    void txtDescriptionOnAction(ActionEvent event) {

    }

    @FXML
    void txtPriceOnAction(ActionEvent event) {

    }

    @FXML
    void txtProduct_IDOnAction(ActionEvent event) {
        String id = txtProduct_ID.getText();

        var model = new ProductModel();
        try {
            ProductDto dto = model.searchProduct(id);

            if(dto != null) {
                fillFields(dto);
            } else {
                new Alert(Alert.AlertType.INFORMATION, "product not found!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    private void fillFields(ProductDto dto) {
        if (dto != null) {
            txtProduct_ID.setText(dto.getProduct_ID());
            txtProduct_Name.setText(dto.getName());
            txtPrice.setText(String.valueOf(dto.getPrice()));
            txtDescription.setText(dto.getDescription());
            txtQty.setText(String.valueOf(dto.getQuantityOnStock()));

        } else {
            new Alert(Alert.AlertType.INFORMATION, "ProductDto is null").show();
        }

    }

    @FXML
    void txtProduct_NameOnAction(ActionEvent event) {

    }

    @FXML
    void txtQtyOnAction(ActionEvent event) {

    }
    private static class SeasonalAdjustment {

        private static final double PEAK_SEASON_INCREASE_PERCENTAGE = 0.20;
        private static final double SLOWER_PERIOD_DECREASE_PERCENTAGE = 0.10;

        public static void adjustQuantity(List<ProductDto> products, boolean isPeakSeason) {
            for (ProductDto product : products) {
                double currentQuantity = product.getQuantityOnStock();
                double adjustedQuantity;

                if (isPeakSeason) {
                    // Increase quantity during peak season
                    adjustedQuantity = currentQuantity * (1 + PEAK_SEASON_INCREASE_PERCENTAGE);
                } else {
                    // Decrease quantity during slower periods
                    adjustedQuantity = currentQuantity * (1 - SLOWER_PERIOD_DECREASE_PERCENTAGE);
                }

                // Update the product quantity
                product.setQuantityOnStock((int) adjustedQuantity);
            }
        }
    }




}

