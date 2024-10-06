package com.gildedrose;

import static com.gildedrose.ItemQualityHelper.*;

public class AgedBrieItemQualityModifier implements ItemQualityModifier {
    @Override
    public void update(Item item) {


        if (isQualityBelowThreshold(item)) {
            item.quality += 1;
        }

        item.sellIn -= 1;

        if (hasNegativeSellIn(item) && isQualityBelowThreshold(item)) {
            item.quality += 1;
        }
    }

}

