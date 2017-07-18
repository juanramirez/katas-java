package com.gildedrose;

class GildedRose {
	public static final int minimumQuality = 0;
	public static final int maximumQuality = 50;
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			if (!items[i].name.equals("Aged Brie")
					&& !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
				if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
					decreaseQuality(items[i]);
				}
			} else {
				if (items[i].quality < maximumQuality) {
					items[i].quality = items[i].quality + 1;

					if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
						if (items[i].sellIn < 11) {
							increaseQuality(items[i]);
						}

						if (items[i].sellIn < 6) {
							increaseQuality(items[i]);
						}
					}
				}
			}

			if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
				items[i].sellIn = items[i].sellIn - 1;
			}

			if (items[i].sellIn < 0) {
				if (!items[i].name.equals("Aged Brie")) {
					if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
						if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
							decreaseQuality(items[i]);
						}
					} else {
						items[i].quality = minimumQuality;
					}
				} else {
					increaseQuality(items[i]);
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
