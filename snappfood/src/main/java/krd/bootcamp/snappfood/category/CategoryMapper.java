package krd.bootcamp.snappfood.category;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toCategory(CategoryDTO categoryDTO);

    CategoryDTO toCategoryDTo(Category category);

    List<Category> toCategories(List<CategoryDTO> categoryDTOS);

    List<CategoryDTO> toCategoryDTOs(List<Category> categories);
}
