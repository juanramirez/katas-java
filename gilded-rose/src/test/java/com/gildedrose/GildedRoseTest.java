package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {
    private GildedRose createSingleItemGildedRoseAndUpdateQuality(String name, int sellIn, int quality) {
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        return app;
    }

    @Test
    public void thatAGenericItemDegradesSellInValueWhenBeingGreaterThanZero() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality("foo", 1, 0);
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    public void thatAGenericItemDegradesQualityValueWhenBeingGreaterThanZero() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality("foo", 1, 1);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void thatTheQualityOfAGenericItemDoesNotBecomeNegative() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality("foo", 1, 0);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void thatTheQualityOfAGenericItemDegradesByTwoWhenSellInValueIsZero() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality("foo", 0, 2);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void thatAgedBrieIncreasesQualityValueWhenBeingLessThan50() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality("Aged Brie", 1, 0);

        assertEquals(1, app.items[0].quality);
    }

    @Test
    public void thatTheQualityOfAgedBrieDoesNotBecomeGreaterThan50() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality("Aged Brie", 1, 50);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void thatSulfurasDoesNotChangeItsSellInValue() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality("Sulfuras, Hand of Ragnaros", 1, 1);
        assertEquals(1, app.items[0].sellIn);
    }

    @Test
    public void thatSulfurasDoesNotChangeItsQualityValue() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality("Sulfuras, Hand of Ragnaros", 1, 1);
        assertEquals(1, app.items[0].quality);
    }

    @Test
    public void thatBackstagePassesIncreasesQualityValueWhenSellInValueIsGreaterThan10() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality("Backstage passes to a TAFKAL80ETC concert", 11, 1);
        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void thatBackstagePassesIncreasesQualityValueByTwoWhenSellInValueIsGreaterThan5ButNotGreaterThan10() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality("Backstage passes to a TAFKAL80ETC concert", 6, 1);
        assertEquals(3, app.items[0].quality);
    }

    @Test
    public void thatBackstagePassesIncreasesQualityValueByThreeWhenSellInValueIsPositiveButNotGreaterThan5() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality("Backstage passes to a TAFKAL80ETC concert", 1, 1);
        assertEquals(4, app.items[0].quality);
    }

    @Test
    public void thatBackstagePassesDropsQualityToZeroWhenSellInValueIsZero() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality("Backstage passes to a TAFKAL80ETC concert", 0, 1);
        assertEquals(0, app.items[0].quality);
    }
}
