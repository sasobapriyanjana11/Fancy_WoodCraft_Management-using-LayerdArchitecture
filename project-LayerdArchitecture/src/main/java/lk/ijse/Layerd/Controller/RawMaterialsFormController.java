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
import lk.ijse.Layerd.dao.custom.Impl.Bill_OF_MaterialModel;
import lk.ijse.Layerd.dao.custom.Impl.RawMaterialModel;
import lk.ijse.Layerd.dao.custom.Impl.SupplierDetailsModel;
import lk.ijse.Layerd.dao.custom.Impl.SupplierModel;
import lk.ijse.Layerd.dao.custom.RawMaterialsDAO;
import lk.ijse.Layerd.dao.custom.SupplierDAO;
import lk.ijse.Layerd.dto.RawMaterialDto;
import lk.ijse.Layerd.dto.SupplierDto;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

public class RawMaterialsFormController {

    @FXML
    private AnchorPane RawMaterialsPane;

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
    private JFXButton btnLOgOut;

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
    private JFXButton btnReport;

    @FXML
    private TableColumn<?, ?> columnMaterialName;

    @FXML
    private TableColumn<?, ?> columnQuantityOnStock;

    @FXML
    private TableColumn<?, ?> columnQty;

    @FXML
    private TableColumn<?, ?> columnRawMaterial_ID;

    @FXML
    private TableColumn<?, ?> columnSupplier_ID;

    @FXML
    private TableView<RawMaterialDto> tableRawMaterial;

    @FXML
    private TextField txtMaterial_Name;

    @FXML
    private TextField txtRawMaterial_ID;

    @FXML
    private TextField txtSupplier_ID;

    @FXML
    private TextField txtQty;

    @FXML
    private ComboBox<String> cmbSupplier_ID;

     private  final SupplierDetailsModel supplierDetailsModel=new SupplierDetailsModel();
    private  final Bill_OF_MaterialModel billOfMaterialModel=new Bill_OF_MaterialModel();
/////
    RawMaterialsDAO rawMaterialsDAO=new RawMaterialModel();
    SupplierDAO supplierDAO=new SupplierModel();


    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/DashBoardForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)RawMaterialsPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();

    }

    private void clearFields() {
        txtSupplier_ID.setText("" );
        txtMaterial_Name.setText("");
        txtSupplier_ID.setText("");
    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/CustomerForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)RawMaterialsPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/DashBoardForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)RawMaterialsPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String  RawMaterial_ID=txtRawMaterial_ID.getText();

      //  var model=new RawMaterialModel();
        try{
          //  boolean isDeleted= model.deleteMaterial(RawMaterial_ID);

            boolean isDeleted=rawMaterialsDAO.delete(RawMaterial_ID);
            if(isDeleted){
                tableRawMaterial.refresh();
                new Alert(Alert.AlertType.CONFIRMATION,"Material Deleted").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }

    }

    @FXML
    void btnDeliveryOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/DeliveryForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)RawMaterialsPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnEmployeeOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/EmployeeForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)RawMaterialsPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnEmployeeSalaryOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/EmployeeSalaryManageForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)RawMaterialsPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnLOgOutOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/LoginForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)RawMaterialsPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnOrderDetailsOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/OrderDetailsForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)RawMaterialsPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnOrdersOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/OrdersForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)RawMaterialsPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnProductOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/ProductForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)RawMaterialsPane.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnRawMaterialsOnAction(ActionEvent event) {

    }

    /////
    public void initialize() {
        setCellValueFactory();
        loadAllSupplier_ID();
        loadAllMaterials();
    }


    private void loadAllSupplier_ID() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
           // List<SupplierDto> cusList = supplierModel.getAllSuppliers();
            List<SupplierDto> cusList = supplierDAO.getAll();

            for (SupplierDto dto : cusList) {
                obList.add(dto.getSupplier_ID());
            }
            cmbSupplier_ID.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        columnRawMaterial_ID.setCellValueFactory(new PropertyValueFactory<>("RawMaterial_ID"));
        columnMaterialName.setCellValueFactory(new PropertyValueFactory<>("MaterialName"));
        columnSupplier_ID.setCellValueFactory(new PropertyValueFactory<>("Supplier_ID"));
        columnQty.setCellValueFactory(new PropertyValueFactory<>("Qty"));
    }

    private void loadAllMaterials() {
      //  var model = new RawMaterialModel();

        ObservableList<RawMaterialDto> obList = FXCollections.observableArrayList();

        try {
            //List<RawMaterialDto> dtoList = model.getAllMaterials();

            List<RawMaterialDto> dtoList = rawMaterialsDAO.getAll();

            for(RawMaterialDto dto : dtoList) {
                obList.add(
                        new RawMaterialDto(
                                dto.getRawMaterial_ID(),
                                dto.getMaterialName(),
                                dto.getQty(),
                                dto.getSupplier_ID()

                       )
                );
            }
          tableRawMaterial.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    ///////

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        boolean isValidated=isRawMaterialValidated();
        if(isValidated) {
            String RawMaterial_ID = txtRawMaterial_ID.getText();
            String name = txtMaterial_Name.getText();
            Integer Qty= Integer.parseInt(txtQty.getText());
            String Supplier_ID = cmbSupplier_ID.getValue();

            var dto= new RawMaterialDto(RawMaterial_ID,name,Qty,Supplier_ID);
           // var model = new RawMaterialModel();

            try {
              //  boolean isSaved = model.saveRawMaterials(dto);
                boolean isSaved = rawMaterialsDAO.save(dto);

                //////
               /* List<RawMaterialDto> RawMaterialDto=new ArrayList<>();
                List<SupplierDto> SupplierDto=new ArrayList<>();
                boolean isStockUpdated=supplierDetailsModel.updateSupplierDetails(RawMaterialDto,SupplierDto);*/

                if (isSaved ) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Material saved").showAndWait();
                    ////
                 Parent root= FXMLLoader.load(this.getClass().getResource("/view/RawMaterialsForm.fxml"));
                    Scene scene=new Scene(root);
                    Stage stage=new Stage();
                    stage.setScene(scene);
                    stage.show();

                    Stage stage1=(Stage)RawMaterialsPane.getScene().getWindow();
                    stage1.close();

                    ////
                }
            } catch (SQLException|IOException e ) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
                new Alert(Alert.AlertType.ERROR, "something went wrong ").show();
            }
        }else{
            new Alert(Alert.AlertType.ERROR, "Raw material details are invalid ").show();
        }

    }

    private boolean isRawMaterialValidated() {
//1)
       String RawMaterial_ID=  txtRawMaterial_ID.getText();
       boolean isIdValidated=Pattern.matches("[R][0-9]{3,}",RawMaterial_ID);

 //2)
        String name=txtMaterial_Name.getText();
        boolean isNameValidated=Pattern.matches("[A-Za-z]{1,}",name);



       if(!isIdValidated){
           new Alert(Alert.AlertType.ERROR,"invalid material id").show();
           txtRawMaterial_ID.requestFocus();
           return  false;
       }


       else if(!isNameValidated){
           new Alert(Alert.AlertType.ERROR,"invalid material  name").show();
           txtMaterial_Name.requestFocus();
           return  false;
       }

       else {
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

        Stage stage1=(Stage)RawMaterialsPane.getScene().getWindow();
        stage1.close();


    }

@FXML
    void btnUpdateOnAction(ActionEvent event) {
    boolean isValidated=isRawMaterialValidated();
    if(isValidated) {
        String RawMaterial_ID = txtRawMaterial_ID.getText();
        String name = txtMaterial_Name.getText();
        Integer QTY= Integer.parseInt(txtQty.getText());
        String Supplier_ID = cmbSupplier_ID.getValue();

        var dto = new RawMaterialDto(RawMaterial_ID, name,QTY, Supplier_ID);
        //var model = new RawMaterialModel();

        try {
           // boolean isUpdated = model.updateMaterials(dto);

            boolean isUpdated = rawMaterialsDAO.update(dto);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "material updated").showAndWait();

                /////

                Parent root= FXMLLoader.load(this.getClass().getResource("/view/RawMaterialsForm.fxml"));
                Scene scene=new Scene(root);
                Stage stage=new Stage();
                stage.setScene(scene);
                stage.show();

                Stage stage1=(Stage)RawMaterialsPane.getScene().getWindow();
                stage1.close();

                /////

            }
        } catch (SQLException | IOException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }else{
        new Alert(Alert.AlertType.ERROR, "can't update,invalid material details").show();
    }

    }

    @FXML
    void cmbSupplier_IDOnAction(ActionEvent event) {

    }

    @FXML
    void txtMaterial_NameOnAction(ActionEvent event) {

    }

    @FXML
    void txtRawMaterial_IDOnAction(ActionEvent event) {
        String id = txtRawMaterial_ID.getText();

       // var model = new RawMaterialModel();
        try {
          //  RawMaterialDto dto = model.searchMaterial(id);

            RawMaterialDto dto = rawMaterialsDAO.search(id);

            if(dto != null) {
                fillFields(dto);
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Material not found!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    private void fillFields(RawMaterialDto dto) {
       txtRawMaterial_ID.setText(dto.getRawMaterial_ID());
        txtMaterial_Name.setText(dto.getMaterialName());
        txtQty.setText(String.valueOf(dto.getQty()));

    }


    @FXML
    void txtQtyOnAction(ActionEvent event) {
    }

    @FXML
    void txtSupplier_IDOnAction(ActionEvent event) {
    }

    @FXML
    void btnReportOnAction(ActionEvent event) {
    }

}

