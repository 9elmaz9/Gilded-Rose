package com.gildedrose;

public class BackstagePassesWrapper extends ItemWrapper {

    public BackstagePassesWrapper(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (item.quality < 50) {
            item.quality++;

            if (item.sellIn <= 10 && item.quality < 50) {
                item.quality++;
            }

            if (item.sellIn <= 5 && item.quality < 50) {
                item.quality++;
            }
        }
        item.quality--;

        if (item.sellIn < 0) {
            item.quality = 0;
        }

    }
}
