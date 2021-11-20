package service;

import domain.*;
import repository.CategoryRepository;
import repository.CustomerRepository;
import repository.ItemRepository;
import repository.WarehouseRepository;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

public class CanOrderBePlacedCheckService {
    Logger LOGGER=Logger.getLogger(CanOrderBePlacedCheckService.class.getName());
    public Boolean canOrderBeFulfilled( OrderRequest orderRequest) {
        Customer customer = CustomerRepository.getCustomerById(orderRequest.getCustomerId());
        Warehouse warehouse = WarehouseRepository.getWareHouseById(orderRequest.getWarehouseId());
        Date deliveryDate = orderRequest.getDeliveryDate();
        List<ItemRequest> items = orderRequest.getItems();
        Map<Category, Integer> maxAvailableItemOfEachCategoryByDate = warehouse.getMaxThresholdItemsByDate(deliveryDate);
        for (ItemRequest itemRequest : items) {
            Item item = ItemRepository.findItemById(itemRequest.getItemId());
            Category category = CategoryRepository.findCategoryByName(itemRequest.getCategory());
            Integer maxItemForCategory = maxAvailableItemOfEachCategoryByDate.get(category);
            if (Objects.isNull(maxItemForCategory) || maxItemForCategory <
                    itemRequest.getQuantity()) {
                return false;
            }
        }
       return true;
    }
}
