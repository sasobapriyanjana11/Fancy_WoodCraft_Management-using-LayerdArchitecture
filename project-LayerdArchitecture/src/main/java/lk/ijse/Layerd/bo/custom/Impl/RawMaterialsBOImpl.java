package lk.ijse.Layerd.bo.custom.Impl;

import lk.ijse.Layerd.bo.custom.RawMaterialsBO;
import lk.ijse.Layerd.dao.DAOFactory;
import lk.ijse.Layerd.dao.custom.Impl.RawMaterialModel;
import lk.ijse.Layerd.dao.custom.RawMaterialsDAO;
import lk.ijse.Layerd.dto.RawMaterialDto;
import lk.ijse.Layerd.entity.RawMaterial;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RawMaterialsBOImpl implements RawMaterialsBO {
    RawMaterialsDAO rawMaterialsDAO= (RawMaterialsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.getTypes.RAWMATERIALS);
    @Override
    public boolean saveRawMaterials(RawMaterialDto dto) throws SQLException {
        return rawMaterialsDAO.save(new RawMaterial(dto.getRawMaterial_ID(),dto.getMaterialName(),dto.getQty(),dto.getSupplier_ID()));
    }

    @Override
    public boolean updateMaterials(RawMaterialDto dto) throws SQLException {
        return rawMaterialsDAO.update(new RawMaterial(dto.getRawMaterial_ID(),dto.getMaterialName(),dto.getQty(),dto.getSupplier_ID()));
    }

    @Override
    public boolean deleteMaterial(String RawMaterial_ID) throws SQLException {
        return rawMaterialsDAO.delete(RawMaterial_ID);
    }

    @Override
    public RawMaterialDto searchMaterial(String id) throws SQLException {
        RawMaterial rawMaterial=rawMaterialsDAO.search(id);
        RawMaterialDto dto=new RawMaterialDto(rawMaterial.getRawMaterial_ID(),rawMaterial.getMaterialName(),rawMaterial.getQty(),rawMaterial.getSupplier_ID());
        return dto;
    }

    @Override
    public List<RawMaterialDto> getAllMaterials() throws SQLException {
        List<RawMaterial>rawMaterials=rawMaterialsDAO.getAll();
        List<RawMaterialDto> rawMaterialDtos=new ArrayList<>();
        for (RawMaterial rawmaterial:rawMaterials) {
            rawMaterialDtos.add(new RawMaterialDto(
                    rawmaterial.getRawMaterial_ID(),
                    rawmaterial.getMaterialName(),
                    rawmaterial.getQty(),
                    rawmaterial.getSupplier_ID()
            ));
        }
        return rawMaterialDtos;
    }

    @Override
    public boolean isStockUpdated(List<RawMaterialDto> tmList) throws SQLException {
       return  false;
    }
}
