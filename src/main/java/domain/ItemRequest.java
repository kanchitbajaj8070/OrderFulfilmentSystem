package domain;

public class ItemRequest {
        Integer itemId;
        String itemName;
        String category;
        Integer quantity;

        public ItemRequest(Integer itemId, String itemName, String category, Integer quantity) {
                this.itemId = itemId;
                this.itemName = itemName;
                this.category = category;
                this.quantity = quantity;
        }

        public Integer getItemId() {
                return itemId;
        }

        public void setItemId(Integer itemId) {
                this.itemId = itemId;
        }

        public String getItemName() {
                return itemName;
        }

        public void setItemName(String itemName) {
                this.itemName = itemName;
        }

        public String getCategory() {
                return category;
        }

        public void setCategory(String category) {
                this.category = category;
        }

        public Integer getQuantity() {
                return quantity;
        }

        public void setQuantity(Integer quantity) {
                this.quantity = quantity;
        }
}
