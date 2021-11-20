package staticDataProviders;

import domain.Category;
import domain.Warehouse;

import java.sql.Date;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static staticDataProviders.CategoryStaticData.*;

public class WarehouseData {

    public static final Warehouse WAREHOUSE_1 = new Warehouse("100", getMaxAvailableItemsByCategoryForEachDateForFirstWareHouse());

    private static Map<Date, Map<Category, Integer>> getMaxAvailableItemsByCategoryForEachDateForFirstWareHouse() {
        List<Date> dates = Arrays.asList(DateData.DATE_1, DateData.DATE_2);
        Map<Date, Map<Category, Integer>> maxAvailableItemsByDate = new HashMap<>();
        Map<Category, Integer> maxItemsByCategory = new HashMap<>();
        maxItemsByCategory.put(CATEGORY_1, 5);
        maxItemsByCategory.put(CATEGORY_2, 5);
        maxItemsByCategory.put(CATEGORY_3, 2);
        for (Date date : dates) {
            maxAvailableItemsByDate.put(date, maxItemsByCategory);
        }
        return maxAvailableItemsByDate;
    }
}
