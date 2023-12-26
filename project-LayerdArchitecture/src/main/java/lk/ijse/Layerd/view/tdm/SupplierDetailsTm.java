package lk.ijse.Layerd.view.tdm;

import lk.ijse.Layerd.dto.RawMaterialDto;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode

public class SupplierDetailsTm {
    private String RawMaterial_ID;
    private String Supplier_ID;
    private LocalDate date;
    private String qty;
    private  double Price;

    private List<RawMaterialDto> tmList = new ArrayList<>();
}
