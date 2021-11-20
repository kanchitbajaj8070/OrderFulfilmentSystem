package repository;

import exceptions.CategoryIdNotFoundException;
import exceptions.CategoryNotFoundException;
import staticDataProviders.CategoryStaticData;
import domain.Category;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CategoryRepository {
    private static List<Category> categories= Arrays.asList(CategoryStaticData.CATEGORY_1,CategoryStaticData.CATEGORY_2,CategoryStaticData.CATEGORY_3);

    public static List<Category> getAllCategory()
    {
        return categories;
    }

    public static Category findCategoryByName(String categoryName)
    {
        Optional<Category> matchingCategory = categories.stream().filter(category -> category.getCategoryName().equalsIgnoreCase(categoryName)).findFirst();
    if(matchingCategory.isPresent())
        return matchingCategory.get();
    else
        throw new CategoryNotFoundException("Category With name "+categoryName+" could not be found");
    }

    public static Category findCategoryById(Integer categoryId)
    {
        Optional<Category> matchingCategory = categories.stream().filter(category -> category.getCategoryId().equals(categoryId)).findFirst();
        if(matchingCategory.isPresent())
            return matchingCategory.get();
        else
            throw new CategoryIdNotFoundException("Category With Id "+ categoryId+" was not found ");
    }
}
