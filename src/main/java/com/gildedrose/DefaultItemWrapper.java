package com.gildedrose;

public class DefaultItemWrapper extends ItemWrapper {
    public DefaultItemWrapper(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (item.quality > 0) {
            item.quality--;
        }
        item.sellIn--;

        if (item.sellIn < 0 && item.quality > 0) {
            item.quality--;
        }
    }
}
