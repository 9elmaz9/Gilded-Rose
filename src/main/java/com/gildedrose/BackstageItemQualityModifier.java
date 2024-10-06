package com.gildedrose;

import static com.gildedrose.ItemQualityHelper.*;

public class BackstageItemQualityModifier implements ItemQualityModifier {

    @Override
    public void update(Item item) {
        if (isQualityBelowThreshold(item)) {
            item.quality += 1;
        }

        if (item.sellIn < 11 && isQualityBelowThreshold(item)) {
            item.quality = item.quality + 1;
        }

        if (item.sellIn < 6 && isQualityBelowThreshold(item)) {
            item.quality = item.quality + 1;
        }

        item.sellIn -= 1;

        if (hasNegativeSellIn(item)) {
            item.quality = 0;
        }

    }
}
