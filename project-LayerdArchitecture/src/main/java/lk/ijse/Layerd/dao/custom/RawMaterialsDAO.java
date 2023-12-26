package lk.ijse.Layerd.dao.custom;

import lk.ijse.Layerd.dao.CrudDAO;
import lk.ijse.Layerd.dao.sqlUtil;
import lk.ijse.Layerd.dto.RawMaterialDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface RawMaterialsDAO extends CrudDAO<RawMaterialDto> {
  /*  boolean saveRawMaterials(final RawMaterialDto dto) throws SQLException;
    boolean updateMaterials(final RawMaterialDto dto) throws SQLException ;

     boolean deleteMaterial(String RawMaterial_ID) throws SQLException ;

    RawMaterialDto  searchMaterial(String id) throws SQLException ;

     List<RawMaterialDto> getAllMaterials() throws SQLException ;*/

    boolean isStockUpdated( List<RawMaterialDto> tmList) throws SQLException ;


}
