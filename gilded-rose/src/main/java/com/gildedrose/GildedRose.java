package com.gildedrose;

import java.util.Arrays;

class GildedRose {
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		ItemHandler[] itemHandlers = Arrays.stream(items).map(ItemHandlerFactory::create).toArray(ItemHandler[]::new);
		for (ItemHandler itemHandler : itemHandlers) {
			itemHandler.updateItemQuality();
		}
	}
}
