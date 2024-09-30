package com.gildedrose;

public class ConjuredItemWrapper extends ItemWrapper {
    public ConjuredItemWrapper(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (item.quality > 0) {
            item.quality -= 2;

        }
        item.sellIn--;

        if (item.sellIn < 0 && item.quality > 0) {
            item.quality -= 2;

            if (item.quality < 0) {
                item.quality = 0;
            }
        }
    }
}
