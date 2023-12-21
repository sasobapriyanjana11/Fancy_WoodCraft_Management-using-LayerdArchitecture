package lk.ijse.Layerd.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode

public class RawMaterialDto {
    private String RawMaterial_ID;
    private String MaterialName;
    private int Qty;
    private String Supplier_ID;
}
