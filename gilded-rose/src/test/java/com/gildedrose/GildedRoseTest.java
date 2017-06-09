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

}
