package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void thatAGenericItemDegradesSellInValueWhenBeingGreaterThanZero() {
        Item[] items = new Item[] { new Item("foo", 1, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    public void thatAGenericItemDegradesQualityValueWhenBeingGreaterThanZero() {
        Item[] items = new Item[] { new Item("foo", 1, 1) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void thatTheQualityOfAGenericItemDoesNotBecomeNegative() {
        Item[] items = new Item[] { new Item("foo", 1, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void thatTheQualityOfAGenericItemDegradesByTwoWhenSellInValueIsZero() {
        Item[] items = new Item[] { new Item("foo", 0, 2) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void thatAgedBrieIncreasesQualityValueWhenBeingLessThan50() {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(1, app.items[0].quality);
    }

    @Test
    public void thatTheQualityOfAgedBrieDoesNotBecomeGreaterThan50() {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void thatSulfurasDoesNotChangeItsSellInValue() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 1) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(1, app.items[0].sellIn);
    }

    @Test
    public void thatSulfurasDoesNotChangeItsQualityValue() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 1) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(1, app.items[0].quality);
    }

    @Test
    public void thatBackstagePassesIncreasesQualityValueWhenSellInValueIsGreaterThan10() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 1) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void thatBackstagePassesIncreasesQualityValueByTwoWhenSellInValueIsGreaterThan5ButNotGreaterThan10() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 6, 1) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(3, app.items[0].quality);
    }

    @Test
    public void thatBackstagePassesIncreasesQualityValueByThreeWhenSellInValueIsPositiveButNotGreaterThan5() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 1, 1) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(4, app.items[0].quality);
    }

    @Test
    public void thatBackstagePassesDropsQualityToZeroWhenSellInValueIsZero() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 1) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }
}
