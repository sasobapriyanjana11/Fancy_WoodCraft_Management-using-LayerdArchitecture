package lk.ijse.Layerd.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode

public class RawMaterial {
    private String RawMaterial_ID;
    private String MaterialName;
    private int Qty;
    private String Supplier_ID;
}
