package com.gildedrose;

class GildedRose {
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			if (!items[i].name.equals("Aged Brie")
					&& !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
				if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
					dropGenericItemQuality(items[i]);
				}
			} else {
				if (items[i].quality < 50) {
					items[i].quality = items[i].quality + 1;

					if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
						if (items[i].sellIn < 11) {
							increaseNonLegendaryItemQuality(items[i]);
						}

						if (items[i].sellIn < 6) {
							increaseNonLegendaryItemQuality(items[i]);
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
							dropGenericItemQuality(items[i]);
						}
					} else {
						items[i].quality = 0;
					}
				} else {
					increaseNonLegendaryItemQuality(items[i]);
				}
			}
		}
	}

	private void dropGenericItemQuality(Item item) {
		if (item.quality > 0) {
			item.quality = item.quality - 1;
		}
	}

	private void increaseNonLegendaryItemQuality(Item item) {
		if (item.quality < 50) {
			item.quality = item.quality + 1;
		}
	}
}
