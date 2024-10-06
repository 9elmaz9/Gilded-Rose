package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static com.gildedrose.ItemQualityModifierFactory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;




public class GildedRoseTest {



        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3, 4, 5})
        void whenBasicItemThenDecrementQuality(int quality) {
            Item simpleItem = new Item("bar", 10, quality);
            Item[] items = new Item[]{simpleItem};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(quality - 1, simpleItem.quality);
        }

        @ParameterizedTest
        @MethodSource("qualityBelow50AndSellInPositive")
        void whenAgedItemThenIncreaseQuality(int quality, int sellIn) {
            Item specialItem = new Item(AGED_BRIE, sellIn, quality);
            Item[] items = new Item[]{specialItem};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(quality + 1, specialItem.quality);
        }

        @ParameterizedTest
        @MethodSource("qualityUnder50AndSellInAbove11")
        void whenConcertItemThenQualityIncreases(int quality, int sellIn) {
            Item concertItem = new Item(TAFKAL_80_ETC_CONCERT, sellIn, quality);
            Item[] items = new Item[]{concertItem};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(quality + 1, concertItem.quality);
        }

        @ParameterizedTest
        @MethodSource("quality49AndSellInBelow11")
        void whenConcertItemAndSellInBelow11ThenIncreaseQualityByOne(int quality, int sellIn) {
            Item concertItem = new Item(TAFKAL_80_ETC_CONCERT, sellIn, quality);
            Item[] items = new Item[]{concertItem};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(quality + 1, concertItem.quality);
        }

        @ParameterizedTest
        @MethodSource("qualityLessThan49AndSellInBetween6And11")
        void whenConcertItemAndSellInBetween6And11ThenIncreaseQualityByTwo(int quality, int sellIn) {
            Item concertItem = new Item(TAFKAL_80_ETC_CONCERT, sellIn, quality);
            Item[] items = new Item[]{concertItem};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(quality + 2, concertItem.quality);
        }

        @ParameterizedTest
        @MethodSource("quality48AndSellInBelow6")
        void whenConcertItemAndSellInBelow6ThenIncreaseQualityByTwo(int quality, int sellIn) {
            Item concertItem = new Item(TAFKAL_80_ETC_CONCERT, sellIn, quality);
            Item[] items = new Item[]{concertItem};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(quality + 2, concertItem.quality);
        }

        @ParameterizedTest
        @MethodSource("qualityLessThan48AndSellInLessThan6")
        void whenConcertItemThenIncreaseQualityByThree() {
            Item concertItem = new Item(TAFKAL_80_ETC_CONCERT, 5, 12);
            Item[] items = new Item[]{concertItem};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(15, concertItem.quality);
        }

        @Test
        void whenItemWithNegativeSellInThenDecreasesQualityByOne() {
            Item otherItem = new Item("random item", -1, 1);
            Item[] items = new Item[]{otherItem};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(0, otherItem.quality);
        }

        @Test
        void whenItemWithNegativeSellInAndQualityAboveOneThenDecreasesQualityByTwo() {
            Item otherItem = new Item("random item", -1, 2);
            Item[] items = new Item[]{otherItem};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(0, otherItem.quality);
        }

        @ParameterizedTest
        @MethodSource("randomItemNegativeSellIn")
        void whenConcertItemWithNegativeSellInThenQualityIsZero(int quality, int sellIn) {
            Item concertItem = new Item(TAFKAL_80_ETC_CONCERT, sellIn, quality);
            Item[] items = new Item[]{concertItem};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(0, concertItem.quality);
        }

        @Test
        void whenAgedItemWithNegativeSellInThenIncreasesQualityToMax() {
            Item brieItem = new Item(AGED_BRIE, -1, 49);
            Item[] items = new Item[]{brieItem};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(50, brieItem.quality);
        }

        @ParameterizedTest
        @ValueSource(ints = {4, 5, 6, 37, 48})
        void whenAgedItemWithNegativeSellInThenIncreasesQualityByTwo(int quality) {
            Item brieItem = new Item(AGED_BRIE, -1, quality);
            Item[] items = new Item[]{brieItem};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(quality + 2, brieItem.quality);
        }

        @Test
        void whenNotSulfurasThenDecreasesSellInByOne() {
            Item otherItem = new Item("not sulfuras", 2, 1);
            Item[] items = new Item[]{otherItem};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(1, otherItem.sellIn);
        }

        @ParameterizedTest
        @MethodSource("positiveQualityAndSellIn")
        void whenSulfurasThenQualityAndSellInRemainUnchanged(int quality, int sellIn) {
            Item sulfurasItem = new Item(SULFURAS_HAND_OF_RAGNAROS, sellIn, quality);
            Item[] items = new Item[]{sulfurasItem};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(quality, sulfurasItem.quality);
            assertEquals(sellIn, sulfurasItem.sellIn);
        }

        @Test
        void whenItemWithNegativeSellInThenQualityDecreasesByOne() {
            Item randomItem = new Item("random", -1, 1);
            Item[] items = new Item[]{randomItem};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(0, randomItem.quality);
        }

        @ParameterizedTest
        @ValueSource(ints = {2, 3, 4, 5, 6, 7})
        void whenItemWithNegativeSellInAndQualityAboveOneThenQualityDecreasesByTwo(int quality) {
            Item randomItem = new Item("random", -1, quality);
            Item[] items = new Item[]{randomItem};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(quality - 2, randomItem.quality);
        }

        private static Stream<Arguments> positiveQualityAndSellIn() {
            return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(12, 15),
                Arguments.of(22, 100)
            );
        }

        private static Stream<Arguments> qualityBelow50AndSellInPositive() {
            return Stream.of(
                Arguments.of(1, 3),
                Arguments.of(3, 3),
                Arguments.of(5, 10),
                Arguments.of(49, 49),
                Arguments.of(49, 49)
            );
        }

        private static Stream<Arguments> qualityUnder50AndSellInAbove11() {
            return Stream.of(
                Arguments.of(29, 12),
                Arguments.of(39, 13),
                Arguments.of(40, 14),
                Arguments.of(48, 22),
                Arguments.of(49, 49)
            );
        }

        private static Stream<Arguments> quality49AndSellInBelow11() {
            return Stream.of(
                Arguments.of(49, 10),
                Arguments.of(49, 9),
                Arguments.of(49, 8),
                Arguments.of(49, 7),
                Arguments.of(49, 6),
                Arguments.of(49, 5),
                Arguments.of(49, 4),
                Arguments.of(49, 3),
                Arguments.of(49, 2),
                Arguments.of(49, 1)
            );
        }

        private static Stream<Arguments> qualityLessThan49AndSellInBetween6And11() {
            return Stream.of(
                Arguments.of(3, 6),
                Arguments.of(3, 7),
                Arguments.of(10, 8),
                Arguments.of(48, 9),
                Arguments.of(48, 10)
            );
        }

        private static Stream<Arguments> quality48AndSellInBelow6() {
            return Stream.of(
                Arguments.of(48, 1),
                Arguments.of(48, 2),
                Arguments.of(48, 3),
                Arguments.of(48, 4),
                Arguments.of(48, 5)
            );
        }

        private static Stream<Arguments> qualityLessThan48AndSellInLessThan6() {
            return Stream.of(
                Arguments.of(3, 1),
                Arguments.of(3, 2),
                Arguments.of(10, 3),
                Arguments.of(46, 4),
                Arguments.of(47, 5)
            );
        }

        private static Stream<Arguments> randomItemNegativeSellIn() {
            return Stream.of(
                Arguments.of(12, -1),
                Arguments.of(1, -2),
                Arguments.of(2, -3),
                Arguments.of(3, -3),
                Arguments.of(4, -19),
                Arguments.of(5, -13),
                Arguments.of(12, -3),
                Arguments.of(9, -3),
                Arguments.of(-1, -3)
            );
        }
    }








