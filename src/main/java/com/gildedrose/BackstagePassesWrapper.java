package com.gildedrose;

public class BackstagePassesWrapper extends ItemWrapper {

    private static final int MAX_QUALITY = 50;
    private static final int NEAR_CONCERT_DAYS = 10;
    private static final int VERY_CLOSE_CONCERT_DAYS = 5;

    public BackstagePassesWrapper(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (item.quality < MAX_QUALITY) {
            item.quality++;
        }

        if (item.sellIn <= NEAR_CONCERT_DAYS && item.quality < MAX_QUALITY) {
            item.quality++;
        }

        if (item.sellIn <= VERY_CLOSE_CONCERT_DAYS && item.quality < MAX_QUALITY) {
            item.quality++;
        }

        item.quality--;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
