package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            ItemDecorator itemDecorator = ItemDecoratorFactory.create(items[i]);

            if (items[i].quality <= 0) {
                continue;
            }

            // decrease sellIn days
            itemDecorator.changeSellIn();

            // update quality
            itemDecorator.changeQuality();
        }
    }

}