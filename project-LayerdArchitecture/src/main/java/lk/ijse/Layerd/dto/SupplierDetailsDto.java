package lk.ijse.Layerd.dto;

import lombok.*;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode

public class SupplierDetailsDto {
    private String RawMaterial_ID;
    private String Supplier_ID;
    private LocalDate date;
    private String qty;
    private  double Price;
}
