package lk.ijse.Layerd.dao.custom;

import lk.ijse.Layerd.dao.CrudDAO;
import lk.ijse.Layerd.dao.sqlUtil;
import lk.ijse.Layerd.dto.RawMaterialDto;
import lk.ijse.Layerd.entity.RawMaterial;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface RawMaterialsDAO extends CrudDAO<RawMaterial> {
  /*  boolean saveRawMaterials(final RawMaterialDto dto) throws SQLException;
    boolean updateMaterials(final RawMaterialDto dto) throws SQLException ;

     boolean deleteMaterial(String RawMaterial_ID) throws SQLException ;

    RawMaterialDto  searchMaterial(String id) throws SQLException ;

     List<RawMaterialDto> getAllMaterials() throws SQLException ;*/

    boolean isStockUpdated( List<RawMaterial> tmList) throws SQLException ;


}
