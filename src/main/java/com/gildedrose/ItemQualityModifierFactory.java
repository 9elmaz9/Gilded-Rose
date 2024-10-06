package com.gildedrose;

import static java.util.Objects.requireNonNull;

public class ItemQualityModifierFactory {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    private static SulfurasItemQualityModifier sulfurasItemQualityModifier = new SulfurasItemQualityModifier();

    private static DefaultItemQualityModifier defaultItemQualityModifier = new DefaultItemQualityModifier();

    private static BackstageItemQualityModifier backstageItemQualityModifier = new BackstageItemQualityModifier();

    private static AgedBrieItemQualityModifier agedBrieItemQualityModifier = new AgedBrieItemQualityModifier();

    static ItemQualityModifier get(Item item) {

        requireNonNull(item, "Item cannot be null");
        requireNonNull(item.name, "Item name cannot be null");

        switch (item.name) {
            case TAFKAL_80_ETC_CONCERT:
                return backstageItemQualityModifier;
            case AGED_BRIE:
                return agedBrieItemQualityModifier;
            case SULFURAS_HAND_OF_RAGNAROS:
                return sulfurasItemQualityModifier;
            default:
                return defaultItemQualityModifier;
        }
    }

}
