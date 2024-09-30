package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    public void testAgedBrieQualityIncreases() {
        Item[] items = new Item[]{
            new Item("Aged Brie", 2, 0)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(1, app.getInventory().getItems()[0].quality);
    }


    @Test
    public void testSulfurasConstant() {
        Item[] items = new Item[]{
            new Item("Sulfuras , Hand of Ragnaros", 0, 80)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.getInventory().getItems()[0].quality); // same quality
        assertEquals(0, app.getInventory().getItems()[0].sellIn);  //sellin doesnt change

    }

    @Test
    public void testBackstagePassesQualityIncreases() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 21)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, app.getInventory().getItems()[0].quality);  // quality >
    }

    @Test
    public void testNormalDefaultItemQualityDecreases() {
        Item[] items = new Item[]{new Item("Normal Item", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(19, app.getInventory().getItems()[0].quality);  //  quality -1
        assertEquals(9, app.getInventory().getItems()[0].sellIn);   // selin -1
    }

    @Test
    public void testConjuredItemsQualityDecreasesFaster() {
        Item[] items = new Item[]{new Item("Conjured Mana Cake", 3, 6)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.getInventory().getItems()[0].quality);  // quality -2
        assertEquals(2, app.getInventory().getItems()[0].sellIn);   // selin -1 1
    }

    // Limit cases for product quality

    @Test
    public void testQualityNotNegative() {
        Item[] items = new Item[]{new Item("Normal Item", 5, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.getInventory().getItems()[0].quality);
    }

    @Test
    public void testQualityNeverAboveFifty() {
        Item[] items = new Item[]{
            new Item("Aged Brie", 2, 50)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.getInventory().getItems()[0].quality);

    }

    //Limit cases for shelf life
    @Test
    public void testQualityDropsTwiceAsFastAfterSellIn() {
        Item[] items = new Item[]{new Item("Normal Item", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.getInventory().getItems()[0].quality);  //x2
    }


    //special cases
    @Test
    public void BackstagePassesQualityFallsToZeroAfterConcert() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22, app.getInventory().getItems()[0].quality);  // quality=0 nadefest
    }


}
