package domain;

import java.sql.Date;
import java.util.Map;

public class Warehouse {
    private String warehouseId;
    Map<Date,Map<Category,Integer>> maxItemsAvailableByCategoryForEachDate;

    public Warehouse(String warehouseId, Map<Date, Map<Category, Integer>> maxItemsAvailableByCategoryForEachDate) {
        this.warehouseId = warehouseId;
        this.maxItemsAvailableByCategoryForEachDate = maxItemsAvailableByCategoryForEachDate;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Map<Category,Integer> getMaxThresholdItemsByDate(Date date)
    {
        return maxItemsAvailableByCategoryForEachDate.get(date);
    }
    public Map<Date, Map<Category, Integer>> getMaxItemsAvailableByCategoryForEachDate() {
        return maxItemsAvailableByCategoryForEachDate;
    }

    public void setMaxItemsAvailableByCategoryForEachDate(Map<Date, Map<Category, Integer>> maxItemsAvailableByCategoryForEachDate) {
        this.maxItemsAvailableByCategoryForEachDate = maxItemsAvailableByCategoryForEachDate;
    }
}
//
// CategoryOnDate (
// date+category=>
//)

