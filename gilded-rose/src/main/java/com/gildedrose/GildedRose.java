package com.gildedrose;

class GildedRose {
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (Item item : items) {
			if (!isSulfuras(item)) {
				decreaseSellIn(item);

				if (!isAgedBrie(item) && !isBackstagePass(item)) {
					decreaseQuality(item);
				} else {
					if (item.quality < getMaximumQuality(item)) {
						increaseQuality(item);

						if (isBackstagePass(item)) {
							if (item.sellIn < 10) {
								increaseQuality(item);
							}

							if (item.sellIn < 5) {
								increaseQuality(item);
							}
						}
					}
				}

				if (item.sellIn < 0) {
					if (!isAgedBrie(item)) {
						if (!isBackstagePass(item)) {
							decreaseQuality(item);
						} else {
							setMinimumQuality(item);
						}
					} else {
						increaseQuality(item);
					}
				}
			}
		}
	}

	private void decreaseSellIn(Item item) {
		item.sellIn--;
	}

	private void decreaseQuality(Item item) {
		if (item.quality > getMinimumQuality(item)) {
			item.quality--;
		}
	}

	private void increaseQuality(Item item) {
		if (item.quality < getMaximumQuality(item)) {
			item.quality++;
		}
	}

	private void setMinimumQuality(Item item) {
		item.quality = getMinimumQuality(item);
	}

	private int getMinimumQuality(Item item) {
		if (isSulfuras(item)) {
			return 80;
		} else {
			return 0;
		}
	}

	private int getMaximumQuality(Item item) {
		if (isSulfuras(item)) {
			return 80;
		} else {
			return 50;
		}
	}

	private boolean isSulfuras(Item item) {
		return item.name.equals("Sulfuras, Hand of Ragnaros");
	}

	private boolean isAgedBrie(Item item) {
		return item.name.equals("Aged Brie");
	}

	private boolean isBackstagePass(Item item) {
		return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
	}
}
