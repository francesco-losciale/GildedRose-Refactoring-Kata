package com.gildedrose;

public class ItemWrapper {
    private Item item;

    public ItemWrapper(Item item) {
        this.item = item;
    }

    public boolean isAgedBrie() {
        return this.item.name.equals("Aged Brie");
    }

    public boolean isBackstagePasses() {
        return this.item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    public boolean isSulfuras() {
        return this.item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    public void changeQuality() {

        if (isAgedBrie()) {
            if (this.item.quality < 50) {
                this.item.quality = this.item.quality + 1;
            }
        } else if (isBackstagePasses()) {
            if (this.item.sellIn < 0) {
                this.item.quality = 0;
            } else if (this.item.sellIn < 6) {
                if (this.item.quality < 48) {
                    this.item.quality = this.item.quality + 3;
                }
            } else if (this.item.sellIn < 11) {
                if (this.item.quality < 49) {
                    this.item.quality = this.item.quality + 2;
                }
            }
        } else {
            this.item.quality = this.item.quality - 1;
        }
    }
}
