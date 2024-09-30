package com.gildedrose;

public class ItemWrapperFactory {
    public static ItemWrapper createItemWrapper(Item item) {

        ItemType type = ItemType.fromName(item.name);

        switch (type) {
            case AGED_BRIE:
                return new AgedBrieWrapper(item);

            case SULFURAS:
                return new SulfurasWrapper(item);

            case BACKSTAGE_PASSES:
                return new BackstagePassesWrapper(item);

            case CONJURED:
                return new ConjuredItemWrapper(item);

            default:
                return new DefaultItemWrapper(item);
        }
    }
}

