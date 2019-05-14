package com.gildedrose;

public class SulfurasItem extends ItemDecorator {

    public SulfurasItem(Item item) {
        super(item);
    }

    @Override
    public void changeQuality() {
        super.item.quality = 80;
    }

    @Override
    public void changeSellIn() {
    }
}
