package com.gildedrose;

class GildedRose {

    private Inventory inventory;

    public Inventory getInventory() {
        return inventory;
    }

    public GildedRose(Item[] items) {
        this.inventory = new Inventory(items);
    }

    public void updateQuality() {
        inventory.updateItems();
    }

}

