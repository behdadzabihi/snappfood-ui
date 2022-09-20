package krd.bootcamp.snappfood.suplier_category;

import krd.bootcamp.snappfood.supplier.SupplierMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {SupplierMapper.class})
public interface SupplierCategoryMapper {

    SupplierCategory toSupplierCategory(SupplierCategoryDTO supplierCategoryDTO);

    SupplierCategoryDTO toSupplierCategoryDTO(SupplierCategory supplierCategory);

    List<SupplierCategory> toSupplierCategories(List<SupplierCategoryDTO> supplierCategoryDTOS);

    List<SupplierCategoryDTO> toSupplierCategoryDTOs(List<SupplierCategory> supplierCategories);
}
