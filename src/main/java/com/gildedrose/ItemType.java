package com.gildedrose;

public enum ItemType {
    AGED_BRIE("Aged Brie"),
    SULFURAS("Sulfuras , Hand of Ragnaros"),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
    CONJURED("Conjured Mana Cake"),
    DEFAULT(" ");

    private final String name;

    ItemType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static ItemType fromName(String name) {
        for (ItemType type : ItemType.values()) {
            if (type.getName().equals(name)) {
                return type;
            }
        }
        return DEFAULT;
    }
}
