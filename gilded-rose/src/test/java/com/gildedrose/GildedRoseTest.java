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
        Item[] items = new Item[] { new Item("foo", 0, 1) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void thatTheQualityOfAGenericItemDoesNotBecomeNegative() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }
}
