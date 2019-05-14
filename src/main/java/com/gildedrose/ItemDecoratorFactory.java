package com.gildedrose;

public class ItemDecoratorFactory {

    static public ItemDecorator create(Item item) {
        if (item.name.equals("Aged Brie")) {
            return new AgedBrieItem(item);
        }
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            return new BackstagePassesItem(item);
        }
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return new SulfurasItem(item);
        }
        if (item.name.equals("Conjured")) {
            return new ConjuredItem(item);
        }
        return new NormalItem(item);
    }
}
