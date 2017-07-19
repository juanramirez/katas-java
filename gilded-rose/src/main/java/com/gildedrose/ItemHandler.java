package com.gildedrose;

class ItemHandler {
	Item item;

	public ItemHandler(Item item) {
		this.item = item;
	}

	public void updateItemQuality() {
		decreaseSellIn();
		decreaseQuality();

		if (item.sellIn < 0) {
			decreaseQuality();
		}
	}

	protected void decreaseSellIn() {
		item.sellIn--;
	}

	private void decreaseQuality() {
		if (item.quality > getMinimumQuality()) {
			item.quality--;
		}
	}

	protected int getMinimumQuality() {
		return 0;
	}

	protected int getMaximumQuality() {
		return 50;
	}

}
