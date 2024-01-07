package lk.ijse.Layerd.bo;

import lk.ijse.Layerd.bo.custom.Impl.*;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){

    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)?boFactory=new BOFactory():boFactory;
    }
    public  enum BOTypes{
        CUSTOMER,DELIVERY,EMPLOYEE,EMPLOYEESALARY,ORDERS,PRODUCT,RAWMATERIALS,SUPPLIER

    }
    public SuperBO getBO(BOTypes boTypes) {
        switch (boTypes) {
            case CUSTOMER:
                return new CustomerBOImpl();
            case DELIVERY:
                return new DeliveryBOImpl();
            case EMPLOYEE:
                return new EmployeeBOImpl();
            case EMPLOYEESALARY:
                return new EmployeeSalaryBOImpl();
            case ORDERS:
                return new OrdersBOImpl();
            case PRODUCT:
                return new ProductBOImpl();
            case RAWMATERIALS:
                return new RawMaterialsBOImpl();
            case SUPPLIER:
                return new SupplierBOImpl();
            default:
              return   null;
        }
    }

}
