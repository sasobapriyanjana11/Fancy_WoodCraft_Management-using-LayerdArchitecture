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
                return new CustomerImpl();
            case DELIVERY:
                return new DeliveryImpl();
            case EMPLOYEE:
                return new EmployeeImpl();
            case EMPLOYEESALARY:
                return  new EmployeeSalaryImpl();
            case ORDERS:
                return new OrdersImpl();
            case PRODUCT:
                return new ProductImpl();
            case RAWMATERIALS:
                return new RawMaterialImpl();
            case SUPPLIER:
                return new SupplierImpl();
            default:
                return  null;
        }
    }
}
