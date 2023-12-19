package lk.ijse.FancyWoodCraftManagement.dto.tm;

import lk.ijse.FancyWoodCraftManagement.dto.CustomerDto;
import lk.ijse.FancyWoodCraftManagement.model.CustomerModel;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class LoyaltyStatusTm {

  /*  private final CustomerModel model = new CustomerModel();
    ///////
    private int orderCount;
    private boolean isLoyaltyCustomer;

    private List<CustomerDto> customers;

    public void CustomerDto() {

        this.customers = new ArrayList<>();
    }

    public void addCustomer(CustomerDto customer) {
        if (getCustomerById(customer.getC_ID()) == null) {
            customers.add(customer);
        }
    }

    public void placeOrder(String C_ID) {
        CustomerDto customer = getCustomerById(C_ID);
        if (customer != null) {
            // Simulate placing an order
            customer.incrementOrderCount();
        }
    }

    public String getLoyaltyStatus(String C_ID) {
        CustomerDto customer = getCustomerById(C_ID);
        if (customer != null) {
            return customer.isLoyaltyCustomer() ? "Loyalty Customer" : "Regular Customer";
        }
        return "Customer not found";
    }

    private CustomerDto getCustomerById(String customerId) {
        for (CustomerDto:customers) {
            if (customerId.equals(getCustomerById(customers))) {
                return new CustomerDto();
            }
        }
        return null;
    }


    // Method to increment order count
    public void incrementOrderCount() {
        this.orderCount++;
        checkLoyaltyStatus();        // Check if the customer becomes a loyalty customer

    }

    private void checkLoyaltyStatus() {
        // Set the customer as a loyalty customer if the order count reaches a certain threshold
        if (orderCount >= 3) {
            isLoyaltyCustomer = true;
            // LoyaltyStatus = "Loyalty Customer";

        }
    }
}

////////

//customerDto ekata enna ona

     /*   private  final LoyaltyStatusTm Tm = new LoyaltyStatusTm();

    public void incrementOrderCount() {
        Tm.incrementOrderCount();

    }

    public boolean isLoyaltyCustomer() {
        Tm.getLoyaltyStatus(getC_ID());
        LoyaltyStatus = "Loyalty Customer";
        return  false;
    }*/
}
    
