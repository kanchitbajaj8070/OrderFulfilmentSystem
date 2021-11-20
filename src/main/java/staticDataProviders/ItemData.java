package staticDataProviders;

import domain.Item;

import static staticDataProviders.CategoryStaticData.CATEGORY_1;
import static staticDataProviders.CategoryStaticData.CATEGORY_2;

public class ItemData {
    public static final Item ITEM_1=new Item(1,CATEGORY_1);
    public static final Item ITEM_2=new Item(2,CATEGORY_1);
    public static final Item ITEM_3=new Item(3,CATEGORY_2);
}
