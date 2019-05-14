package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            ItemWrapper itemWrapper = new ItemWrapper(items[i]);

            if (items[i].quality <= 0 || itemWrapper.isSulfuras()) {
                continue;
            }

            itemWrapper.changeQuality();

            items[i].sellIn = items[i].sellIn - 1;

            if (items[i].sellIn < 0) {
                itemWrapper.changeQuality();
            }
        }
    }

}