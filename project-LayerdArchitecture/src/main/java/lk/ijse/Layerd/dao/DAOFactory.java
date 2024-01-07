package lk.ijse.Layerd.dao;

import lk.ijse.Layerd.dao.custom.Impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){}

    public static DAOFactory getDaoFactory(){
        return (daoFactory==null)?daoFactory=new DAOFactory():daoFactory;
    }
    public enum  getTypes{
        CUSTOMER,DELIVERY,EMPLOYEE,EMPLOYEESALARY,ORDERS,PRODUCT,RAWMATERIALS,SUPPLIER
    }
    public SuperDAO getDAO(getTypes getTypes){
        switch (getTypes){
            case CUSTOMER:
                return new CustomerModel();
            case DELIVERY:
                return new DeliveryModel();
            case EMPLOYEE:
                return new EmployeeModel();
            case EMPLOYEESALARY:
                return  new EmployeeSalaryModel();
            case ORDERS:
                return new OrdersModel();
            case PRODUCT:
                return new ProductModel();
            case RAWMATERIALS:
                return new RawMaterialModel();
            case SUPPLIER:
                return new SupplierModel();
            default:
                return  null;
        }
    }
}
