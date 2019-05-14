package com.gildedrose;

abstract public class ItemDecorator {

    protected Item item;

    public ItemDecorator(Item item) {
        this.item = item;
    }

    abstract public void changeQuality();

    abstract public void changeSellIn();

}
