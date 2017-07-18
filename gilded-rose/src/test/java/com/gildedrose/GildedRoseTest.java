package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    private final String backstagePassesName = "Backstage passes to a TAFKAL80ETC concert";
    private final String genericName = "foo";
    private final String agedBrieName = "Aged Brie";
    private final String sulfurasName = "Sulfuras, Hand of Ragnaros";

    private GildedRose createSingleItemGildedRoseAndUpdateQuality(String name, int sellIn, int quality) {
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
	    return createGildedRoseAndUpdateQuality(items);
    }

	private GildedRose createGildedRoseAndUpdateQuality(Item[] items) {
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		return app;
	}

	@Test
    public void thatGenericItemSellInDegradesWhenBeingGreaterThanZero() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality(genericName, 15, 15);
        assertEquals(14, app.items[0].sellIn);
    }

    @Test
    public void thatGenericItemsQualityDegradesWhenBeingGreaterThanZero() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality(genericName, 15, 15);
        assertEquals(14, app.items[0].quality);
    }

    @Test
    public void thatGenericItemsQualityDegradesByTwoWhenSellInIsZero() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality(genericName, 0, 15);
        assertEquals(13, app.items[0].quality);
    }

    @Test
    public void thatGenericItemsQualityDegradesByTwoWhenSellInIsMinusOne() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality(genericName, -1, 15);
        assertEquals(13, app.items[0].quality);
    }

    @Test
    public void thatGenericItemsQualityDoesNotBecomeNegative() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality(genericName, 15, 0);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void thatGenericItemsQualityDoesNotBecomeNegativeEvenWhenItShouldBeDegradedByTwo() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality(genericName, 15, 1);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void thatAgedBrieQualityIncreasesWhenBeingLessThan50() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality(agedBrieName, 15, 15);
        assertEquals(16, app.items[0].quality);
    }

    @Test
    public void thatAgedBrieQualityDoesNotBecomeGreaterThan50() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality(agedBrieName, 15, 50);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void thatSulfurasSellInDoesNotChange() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality(sulfurasName, 15, 80);
        assertEquals(15, app.items[0].sellIn);
    }

    @Test
    public void thatSulfurasQualityDoesNotChange() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality(sulfurasName, 15, 80);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    public void thatBackstagePassesQualityIncreasesWhenSellInIsGreaterThan10() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality(backstagePassesName, 11, 15);
        assertEquals(16, app.items[0].quality);
    }

    @Test
    public void thatBackstagePassesQualityIncreasesByTwoWhenSellInIsGreaterThan5ButNotGreaterThan10() {
        Item rangeLowerEdge = new Item(backstagePassesName, 6, 15);
        Item rangeUpperEdge = new Item(backstagePassesName, 10, 15);
        createGildedRoseAndUpdateQuality(new Item[] {rangeLowerEdge, rangeUpperEdge});
        assertEquals(17, rangeLowerEdge.quality);
        assertEquals(17, rangeUpperEdge.quality);
    }

    @Test
    public void thatBackstagePassesQualityIncreasesByThreeWhenSellInIsPositiveButNotGreaterThan5() {
        Item rangeLowerEdge = new Item(backstagePassesName, 1, 15);
        Item rangeUpperEdge = new Item(backstagePassesName, 5, 15);
        createGildedRoseAndUpdateQuality(new Item[] {rangeLowerEdge, rangeUpperEdge});
        assertEquals(18, rangeLowerEdge.quality);
        assertEquals(18, rangeUpperEdge.quality);
    }

    @Test
    public void thatBackstagePassesQualityDropsToZeroWhenSellInIsZero() {
        GildedRose app = createSingleItemGildedRoseAndUpdateQuality(backstagePassesName, 0, 15);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void thatBackstagePassesQualityDoesNotBecomeGreaterThan50() {
        Item itemThatShouldBeIncreasedByOne = new Item(backstagePassesName, 11, 50);
        Item itemThatShouldBeIncreasedByTwo = new Item(backstagePassesName, 6, 49);
        Item itemThatShouldBeIncreasedByThree = new Item(backstagePassesName, 1, 48);
        createGildedRoseAndUpdateQuality(new Item[] {itemThatShouldBeIncreasedByOne, itemThatShouldBeIncreasedByTwo, itemThatShouldBeIncreasedByThree});
        assertEquals(50, itemThatShouldBeIncreasedByOne.quality);
        assertEquals(50, itemThatShouldBeIncreasedByTwo.quality);
        assertEquals(50, itemThatShouldBeIncreasedByThree.quality);
    }
}
