package com.gildedrose;

public class AgedBrieItemHandler extends ItemHandler {
	public AgedBrieItemHandler(Item item) {
		super(item);
	}

	@Override
	public void updateItemQuality() {
		decreaseSellIn();
		increaseQuality();
	}

	protected void increaseQuality() {
		if (item.quality < getMaximumQuality()) {
			item.quality++;
		}
	}
}
