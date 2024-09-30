package com.gildedrose;

public abstract class ItemWrapper {
    protected Item item;

    public ItemWrapper(Item item) {
        this.item = item;
    }

    public abstract void updateQuality();
}
