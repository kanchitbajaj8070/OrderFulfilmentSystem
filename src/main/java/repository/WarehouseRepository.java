package repository;

import domain.Customer;
import domain.Warehouse;
import exceptions.WarehouseIdNotFoundException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static staticDataProviders.WarehouseData.WAREHOUSE_1;

public class WarehouseRepository {

    private static List<Warehouse> warehouseList= Arrays.asList(WAREHOUSE_1);

    public static List<Warehouse> getAllWareHouses()
    {
        return warehouseList;
    }
    public static Warehouse getWareHouseById(String warehouseId)
    {
        Optional<Warehouse> matchingWarehouse = warehouseList.stream().filter(warehouse -> warehouse.getWarehouseId().equalsIgnoreCase(warehouseId)).findFirst();
        if(matchingWarehouse.isPresent())
            return matchingWarehouse.get();
        else
            throw new WarehouseIdNotFoundException("WareHouse with Id "+warehouseId+" was not found ");
    }


}
