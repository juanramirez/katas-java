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
    public void thatGenericItemSellInDegradesWhenBeingGreaterThanZero() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality("foo", 15, 15);
        assertEquals(14, app.items[0].sellIn);
    }

    @Test
    public void thatGenericItemsQualityDegradesWhenBeingGreaterThanZero() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality("foo", 15, 15);
        assertEquals(14, app.items[0].quality);
    }

    @Test
    public void thatGenericItemsQualityDegradesByTwoWhenSellInIsZero() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality("foo", 0, 15);
        assertEquals(13, app.items[0].quality);
    }

    @Test
    public void thatGenericItemsQualityDegradesByTwoWhenSellInIsMinusOne() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality("foo", -1, 15);
        assertEquals(13, app.items[0].quality);
    }

    @Test
    public void thatGenericItemsQualityDoesNotBecomeNegative() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality("foo", 15, 0);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void thatGenericItemsQualityDoesNotBecomeNegativeEvenWhenItShouldBeDegradedByTwo() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality("foo", 15, 1);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void thatAgedBrieQualityIncreasesWhenBeingLessThan50() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality("Aged Brie", 15, 15);
        assertEquals(16, app.items[0].quality);
    }

    @Test
    public void thatAgedBrieQualityDoesNotBecomeGreaterThan50() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality("Aged Brie", 15, 50);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void thatSulfurasSellInDoesNotChange() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality("Sulfuras, Hand of Ragnaros", 15, 80);
        assertEquals(15, app.items[0].sellIn);
    }

    @Test
    public void thatSulfurasQualityDoesNotChange() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality("Sulfuras, Hand of Ragnaros", 15, 80);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    public void thatBackstagePassesQualityIncreasesWhenSellInIsGreaterThan10() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality("Backstage passes to a TAFKAL80ETC concert", 11, 15);
        assertEquals(16, app.items[0].quality);
    }

    @Test
    public void thatBackstagePassesQualityIncreasesByTwoWhenSellInIsGreaterThan5ButNotGreaterThan10() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality("Backstage passes to a TAFKAL80ETC concert", 6, 15);
        assertEquals(17, app.items[0].quality);
    }

    @Test
    public void thatBackstagePassesQualityIncreasesByThreeWhenSellInIsPositiveButNotGreaterThan5() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality("Backstage passes to a TAFKAL80ETC concert", 1, 15);
        assertEquals(18, app.items[0].quality);
    }

    @Test
    public void thatBackstagePassesQualityDropsToZeroWhenSellInIsZero() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality("Backstage passes to a TAFKAL80ETC concert", 0, 15);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void thatBackstagePassesQualityDoesNotBecomeGreaterThan50IfItIsIncreasedByOne() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality("Backstage passes to a TAFKAL80ETC concert", 11, 50);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void thatBackstagePassesQualityDoesNotBecomeGreaterThan50IfItIsIncreasedByTwo() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality("Backstage passes to a TAFKAL80ETC concert", 6, 49);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void thatBackstagePassesQualityDoesNotBecomeGreaterThan50IfItIsIncreasedByThree() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality("Backstage passes to a TAFKAL80ETC concert", 1, 48);
        assertEquals(50, app.items[0].quality);
    }
}
