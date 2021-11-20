package service;

import domain.*;
import exceptions.OrderReservationException;
import repository.CategoryRepository;
import repository.CustomerRepository;
import repository.ItemRepository;
import repository.WarehouseRepository;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

public class ReserveOrderService {
    Logger LOGGER = Logger.getLogger(ReserveOrderService.class.getName());

    public boolean reserveOrder(OrderRequest orderRequest) {
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
                LOGGER.warning("Customer with customer Id " + customer.getCustomerId() + " and name " + customer.getCustomerName() +
                        " was not able to place order as enough item of category" + category.getCategoryName() + " were not present");
                throw new OrderReservationException("Insufficient quantities!!");
            } else {
                maxAvailableItemOfEachCategoryByDate.put(category, maxItemForCategory - itemRequest.getQuantity());
            }
        }
        LOGGER.info("Customer with customer Id " + customer.getCustomerId() + " and name " + customer.getCustomerName() + " was able to place order successfully");
        return true;

    }
}
