package com.gildedrose;

public class BackstagePassesItemHandler extends AgedBrieItemHandler {
	public BackstagePassesItemHandler(Item item) {
		super(item);
	}

	@Override
	public void updateItemQuality() {
		decreaseSellIn();

		if (item.sellIn < 0) {
			setMinimumQuality();
		} else {
			increaseQuality();
			if (item.sellIn < 10) {
				increaseQuality();
			}
			if (item.sellIn < 5) {
				increaseQuality();
			}
		}
	}

	private void setMinimumQuality() {
		item.quality = getMinimumQuality();
	}
}
