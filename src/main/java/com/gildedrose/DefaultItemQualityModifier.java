package com.gildedrose;

import static com.gildedrose.ItemQualityHelper.*;

public class DefaultItemQualityModifier implements ItemQualityModifier {
    @Override
    public void update(Item item) {

        if (hasPositiveQuality(item)) {
            item.quality -= 1;
        }

        item.sellIn -= 1;

        if (hasNegativeSellIn(item) && hasPositiveQuality(item)) {
            item.quality -= 1;
        }

    }
}
