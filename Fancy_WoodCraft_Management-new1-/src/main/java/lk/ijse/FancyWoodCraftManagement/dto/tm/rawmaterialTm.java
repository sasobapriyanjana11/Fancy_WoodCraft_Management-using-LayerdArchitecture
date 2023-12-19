package lk.ijse.FancyWoodCraftManagement.dto.tm;

import lombok.*;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Setter
@Getter

public class rawmaterialTm {
    private String RawMaterial_ID;
    private String MaterialName;
    private String Supplier_ID;
}