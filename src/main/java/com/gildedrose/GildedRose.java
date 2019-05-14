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

            // decrease sellIn days
            items[i].sellIn = items[i].sellIn - 1;

            // update quality
            itemWrapper.changeQuality();
        }
    }

}