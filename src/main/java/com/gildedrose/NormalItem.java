package com.gildedrose;

public class NormalItem extends ItemDecorator {

    public NormalItem(Item item) {
        super(item);
    }

    @Override
    public void changeQuality() {
        if (super.item.sellIn < 0) {
            super.item.quality = super.item.quality - 1;
        }
        super.item.quality = super.item.quality - 1;
    }

    @Override
    public void changeSellIn() {
        super.item.sellIn = super.item.sellIn - 1;
    }
}
