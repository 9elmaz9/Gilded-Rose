package com.gildedrose;

final public class ItemQualityHelper {

    public ItemQualityHelper() {
    }


    static boolean hasNegativeSellIn(Item item) {
        return item.sellIn < 0;
    }

    static boolean hasPositiveQuality(Item item) {
        return item.quality > 0;
    }

    static boolean isQualityBelowThreshold(Item item) {
        return item.quality < 50;
    }
}
