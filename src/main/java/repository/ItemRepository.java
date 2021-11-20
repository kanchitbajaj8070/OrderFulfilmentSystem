package repository;

import domain.Item;
import exceptions.ItemIdNotFoundException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static staticDataProviders.ItemData.*;

public class ItemRepository {

    private static List<Item> itemsList = Arrays.asList(ITEM_1, ITEM_2, ITEM_3);

    public static List<Item> getAllItems() {
        return itemsList;
    }

    public static Item findItemById(Integer itemId) {

        Optional<Item> matchingItem = itemsList.stream().filter(item -> item.getItemId().equals(itemId)).findFirst();
        if (matchingItem.isPresent())
            return matchingItem.get();
        else
           throw new ItemIdNotFoundException("Item with id "+ itemId+" was not found");
    }
}

