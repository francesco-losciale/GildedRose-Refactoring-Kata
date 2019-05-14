package com.gildedrose;

public class BackstagePassesItem extends ItemDecorator {

    public BackstagePassesItem(Item item) {
        super(item);
    }

    @Override
    public void changeQuality() {
        if (super.item.sellIn < 0) {
            super.item.quality = 0;
        } else if (super.item.sellIn < 6) {
            if (super.item.quality < 48) {
                super.item.quality = super.item.quality + 3;
            }
        } else if (super.item.sellIn < 11) {
            if (super.item.quality < 49) {
                super.item.quality = super.item.quality + 2;
            }
        }
    }

    @Override
    public void changeSellIn() {
        super.item.sellIn = super.item.sellIn - 1;
    }
}
