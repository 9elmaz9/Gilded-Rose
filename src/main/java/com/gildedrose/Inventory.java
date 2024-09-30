package com.gildedrose;

public class Inventory {
    private Item[] items;

    public Inventory(Item[] items) {
        this.items = items;
    }

    public void updateItems() {
        for (Item item : items) {
            ItemWrapper itemWrapper = ItemWrapperFactory.createItemWrapper(item);
            itemWrapper.updateQuality();
        }
    }

    public Item[] getItems() {
        return items;
    }
}
