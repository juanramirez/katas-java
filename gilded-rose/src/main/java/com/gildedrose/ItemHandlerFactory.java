package com.gildedrose;

public class ItemHandlerFactory {
	static ItemHandler create(Item item) {
		switch (item.name) {
			case "Sulfuras, Hand of Ragnaros":
				return new SulfurasItemHandler(item);
			case "Backstage passes to a TAFKAL80ETC concert":
				return new BackstagePassesItemHandler(item);
			case "Aged Brie":
				return new AgedBrieItemHandler(item);
			default:
				return new ItemHandler(item);
		}
	}
}
