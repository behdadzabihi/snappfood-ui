package krd.bootcamp.snappfood.supplier;

import krd.bootcamp.snappfood.category.CategoryMapper;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometries;
import org.geolatte.geom.Point;
import org.geolatte.geom.crs.CoordinateReferenceSystems;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring",uses = {CategoryMapper.class})
public interface SupplierMapper {

    @Mappings({
            @Mapping(source = "locationDTO", target = "location", qualifiedByName = "locationDtoToLocation")})
    Supplier toSupplier(SupplierDTO supplierDTO);

    @Mappings({
            @Mapping(source = "location", target = "locationDTO", qualifiedByName = "locationToLocationDTO")})
    SupplierDTO toSupplierDTO(Supplier supplier);

    List<Supplier> toSuppliers(List<SupplierDTO> supplierDTOS);

    List<SupplierDTO> toSupplierDTOs(List<Supplier> suppliers);





    @Named("locationDtoToLocation")
    default Point<G2D> convertLocationDtoToLocation(LocationDTO locationDTO) {
        Point<G2D> candidPoint= Geometries.mkPoint(new G2D(locationDTO.getLng(), locationDTO.getLat()), CoordinateReferenceSystems.WGS84);
        return  candidPoint;
    }

    @Named("locationToLocationDTO")
    default  LocationDTO  convertlLocationToLocationDTO(Point<G2D> point) {
        G2D g2D=   point.getPosition();
        LocationDTO locationDTO=new LocationDTO();
        locationDTO.setLat(g2D.getLat());
        locationDTO.setLng(g2D.getLon());
        return  locationDTO;
    }
}
