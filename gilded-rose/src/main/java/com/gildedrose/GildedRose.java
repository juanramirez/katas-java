package com.gildedrose;

class GildedRose {
	public static final int minimumQuality = 0;
	public static final int maximumQuality = 50;
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (Item item : items) {
			if (!item.name.equals("Aged Brie")
					&& !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
				if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
					decreaseQuality(item);
				}
			} else {
				if (item.quality < maximumQuality) {
					item.quality = item.quality + 1;

					if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
						if (item.sellIn < 11) {
							increaseQuality(item);
						}

						if (item.sellIn < 6) {
							increaseQuality(item);
						}
					}
				}
			}

			if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
				item.sellIn = item.sellIn - 1;
			}

			if (item.sellIn < 0) {
				if (!item.name.equals("Aged Brie")) {
					if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
						if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
							decreaseQuality(item);
						}
					} else {
						item.quality = minimumQuality;
					}
				} else {
					increaseQuality(item);
				}
			}
		}
	}

	private void decreaseQuality(Item item) {
		if (item.quality > minimumQuality) {
			item.quality = item.quality - 1;
		}
	}

	private void increaseQuality(Item item) {
		if (item.quality < maximumQuality) {
			item.quality = item.quality + 1;
		}
	}
}
