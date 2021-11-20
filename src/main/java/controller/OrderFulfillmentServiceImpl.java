package controller;

import domain.OrderRequest;
import exceptions.OrderRequestNullException;
import exceptions.OrderReservationException;
import service.CanOrderBePlacedCheckService;
import service.ReserveOrderService;

import java.util.Objects;

public class OrderFulfillmentServiceImpl implements OrderFulfilmentService {

    private ReserveOrderService reserveOrderService;
    private CanOrderBePlacedCheckService checkService;
    OrderFulfillmentServiceImpl()
    {
      super();
      this.checkService=new CanOrderBePlacedCheckService();
      this.reserveOrderService=new ReserveOrderService();

    }
    @Override
    public Boolean canFulfilOrder(OrderRequest orderRequest) {
        if(Objects.isNull(orderRequest))
            throw  new OrderRequestNullException("Order request sent is invalid");
        return checkService.canOrderBeFulfilled(orderRequest);
    }

    @Override
    public void reserveOrder(OrderRequest orderRequest) throws OrderReservationException {
        if(Objects.isNull(orderRequest))
            throw  new OrderRequestNullException("Order request sent is invalid");
    boolean canReserveOrder=reserveOrderService.reserveOrder(orderRequest);
    if(canReserveOrder)
        System.out.println("Success!!");
    }
}
