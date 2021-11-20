package domain;

public class Item {
    private Integer itemId;
    private Category category;

    public Item(Integer itemId, Category category) {
        this.itemId = itemId;
        this.category = category;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
