package lk.ijse.Layerd.bo.custom;

import lk.ijse.Layerd.bo.SuperBO;
import lk.ijse.Layerd.dto.RawMaterialDto;

import java.sql.SQLException;
import java.util.List;

public interface RawMaterialsBO extends SuperBO {
      boolean saveRawMaterials(final RawMaterialDto dto) throws SQLException;
    boolean updateMaterials(final RawMaterialDto dto) throws SQLException ;

     boolean deleteMaterial(String RawMaterial_ID) throws SQLException ;

    RawMaterialDto  searchMaterial(String id) throws SQLException ;

     List<RawMaterialDto> getAllMaterials() throws SQLException ;

    boolean isStockUpdated( List<RawMaterialDto> tmList) throws SQLException;
}
