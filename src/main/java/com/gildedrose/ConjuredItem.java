package com.gildedrose;

public class ConjuredItem extends ItemDecorator {

    public ConjuredItem(Item item) {
        super(item);
    }

    @Override
    public void changeQuality() {
        super.item.quality = super.item.quality - 2;
    }

    @Override
    public void changeSellIn() {
        super.item.sellIn = super.item.sellIn - 1;
    }
}
