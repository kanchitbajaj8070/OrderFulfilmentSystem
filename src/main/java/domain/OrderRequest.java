package domain;

import java.sql.Date;
import java.util.List;

public class OrderRequest {
    String customerId;
    String warehouseId;
    Date deliveryDate;
    List<ItemRequest> items;

    public OrderRequest(String customerId, String warehouseId, Date deliveryDate, List<ItemRequest> items) {
        this.customerId = customerId;
        this.warehouseId = warehouseId;
        this.deliveryDate = deliveryDate;
        this.items = items;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public List<ItemRequest> getItems() {
        return items;
    }

    public void setItems(List<ItemRequest> items) {
        this.items = items;
    }
}
