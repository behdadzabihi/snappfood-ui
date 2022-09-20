package krd.bootcamp.snappfood.category;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-20T04:52:07-0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category toCategory(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoryDTO.getId() );
        category.setVersion( categoryDTO.getVersion() );
        category.setCreatedData( categoryDTO.getCreatedData() );
        category.setCreatedBy( categoryDTO.getCreatedBy() );
        category.setLastModifiedData( categoryDTO.getLastModifiedData() );
        category.setLastModifiedBy( categoryDTO.getLastModifiedBy() );
        category.setTitle( categoryDTO.getTitle() );
        category.setLogo( categoryDTO.getLogo() );

        return category;
    }

    @Override
    public CategoryDTO toCategoryDTo(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId( category.getId() );
        categoryDTO.setVersion( category.getVersion() );
        categoryDTO.setCreatedData( category.getCreatedData() );
        categoryDTO.setCreatedBy( category.getCreatedBy() );
        categoryDTO.setLastModifiedData( category.getLastModifiedData() );
        categoryDTO.setLastModifiedBy( category.getLastModifiedBy() );
        categoryDTO.setTitle( category.getTitle() );
        categoryDTO.setLogo( category.getLogo() );

        return categoryDTO;
    }

    @Override
    public List<Category> toCategories(List<CategoryDTO> categoryDTOS) {
        if ( categoryDTOS == null ) {
            return null;
        }

        List<Category> list = new ArrayList<Category>( categoryDTOS.size() );
        for ( CategoryDTO categoryDTO : categoryDTOS ) {
            list.add( toCategory( categoryDTO ) );
        }

        return list;
    }

    @Override
    public List<CategoryDTO> toCategoryDTOs(List<Category> categories) {
        if ( categories == null ) {
            return null;
        }

        List<CategoryDTO> list = new ArrayList<CategoryDTO>( categories.size() );
        for ( Category category : categories ) {
            list.add( toCategoryDTo( category ) );
        }

        return list;
    }
}
