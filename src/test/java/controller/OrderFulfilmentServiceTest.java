package controller;

import domain.Category;
import domain.Customer;
import domain.ItemRequest;
import domain.OrderRequest;
import exceptions.OrderReservationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import repository.WarehouseRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static staticDataProviders.CategoryStaticData.CATEGORY_1;
import static staticDataProviders.CategoryStaticData.CATEGORY_2;

@RunWith(MockitoJUnitRunner.class)
public class OrderFulfilmentServiceTest {


    OrderFulfilmentService underTest;
    OrderRequest orderRequest;

    @Before
    public void setUp() {
        underTest = new OrderFulfillmentServiceImpl();
        String customerId = "10001";
        String date = "2020-10-13";
        String warehouseId = "100";
        List<ItemRequest> itemRequests = new ArrayList<>();
        itemRequests.add(new ItemRequest(1, "Washington Apple (1 pc)", "F_N_V", 3));
        itemRequests.add(new ItemRequest(2, "Banana (0.5kg)", "F_N_V", 1));
        itemRequests.add(new ItemRequest(3, "Parle-G Biscuit (200g)", "Grocery", 1));
         this.orderRequest = new OrderRequest(customerId, warehouseId, Date.valueOf(date), itemRequests);
    }

    @Test
    public void checkOrderReserveService() {
        underTest.reserveOrder(orderRequest);
        Map<Category,Integer> categoryItemsMap= WarehouseRepository.getWareHouseById(orderRequest.getWarehouseId()).getMaxThresholdItemsByDate(orderRequest.getDeliveryDate());
        Assert.assertTrue(categoryItemsMap.get(CATEGORY_1)==1);
        Assert.assertTrue(categoryItemsMap.get(CATEGORY_2)==4);
    }

    @Test
    public void checkCanOrderBeFulfilledService() {
        boolean result = underTest.canFulfilOrder(orderRequest);
        Assert.assertTrue(result);
    }

    @Test(expected = OrderReservationException.class)
    public void checkOrderReserveServiceInvalidRequest() {
        orderRequest.getItems().add(new ItemRequest(3, "Banana (0.5kg)", "F_N_V", 5));
        underTest.reserveOrder(orderRequest);

    }
    @Test
    public void checkCanOrderBeFulfilledServiceInvalidCase() {
        orderRequest.getItems().add(new ItemRequest(2, "Banana (0.5kg)", "F_N_V", 9));
        boolean result = underTest.canFulfilOrder(orderRequest);
        Assert.assertFalse(result);
    }
}