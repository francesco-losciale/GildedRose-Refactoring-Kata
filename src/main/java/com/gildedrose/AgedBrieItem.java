package com.gildedrose;

public class AgedBrieItem extends ItemDecorator {

    public AgedBrieItem(Item item) {
        super(item);
    }

    @Override
    public void changeQuality() {
        if (super.item.quality < 50) {
            super.item.quality = super.item.quality + 1;
        }
    }

    @Override
    public void changeSellIn() {
        super.item.sellIn = super.item.sellIn - 1;
    }
}
