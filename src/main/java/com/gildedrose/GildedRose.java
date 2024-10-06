package com.gildedrose;

class GildedRose {

    Item[] items;
    private ItemQualityModifierFactory itemQualityModifierFactory;


    public GildedRose(Item[] items) {
        this.items = items;
        this.itemQualityModifierFactory = new ItemQualityModifierFactory();
    }

    public GildedRose(Item[] items, ItemQualityModifierFactory itemQualityUpdaterFactory) {
        this.items = items;
        this.itemQualityModifierFactory = itemQualityUpdaterFactory;
    }

    public void updateQuality() {

        for (Item item : items) {
            ItemQualityModifierFactory.get(item).update(item);
        }
    }

}

