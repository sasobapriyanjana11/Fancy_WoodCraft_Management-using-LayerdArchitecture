package lk.ijse.Layerd.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode

public class SupplierDto {
    private  String Supplier_ID;
    private  String  name;
    private String address;
    private  String tel;
}
