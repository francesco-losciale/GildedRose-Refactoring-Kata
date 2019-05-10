package com.gildedrose;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class GildedRoseTest {

    @Test
    public void testWhenItemIsCreatedThenSellInDateIsCorrect() {
        assertEquals(1, new Item("test", 1, 1).sellIn);
    }
    
    @Test
    public void testWhenItemIsCreatedThenQualityIsCorrect() {
        assertEquals(1, new Item("test", 1,1).quality);
    }

    @Test
    public void testWhenEndOfDayThenQualityIsLowered() {
        int initialQuality = 10;
        Item item = new Item("test", 1, initialQuality);
        GildedRose gildedRose = new GildedRose(new Item[]{ item });
        gildedRose.updateQuality();
        assertEquals(initialQuality - 1, item.quality);
    }

    @Test
    public void testWhenEndOfDayThenSellInDateIsLowered() {
        int sellInDate = 10;
        Item item = new Item("test", sellInDate, 1);
        GildedRose gildedRose = new GildedRose(new Item[]{ item });
        gildedRose.updateQuality();
        assertEquals(sellInDate - 1, item.sellIn);
    }

    @Test
    public void testWhenSellInDateHasPassedThenQualityDegradesTwiceAsFast() {
        int initialQuality = 10;
        Item item = new Item("test", 0, initialQuality);
        GildedRose gildedRose = new GildedRose(new Item[]{ item });
        gildedRose.updateQuality();
        assertEquals(8, item.quality);
    }

    @Test
    public void testWhenQualityIsZeroThenNotDecreasesMore() {
        int initialQuality = 0;
        Item item = new Item("test", 1, initialQuality);
        GildedRose gildedRose = new GildedRose(new Item[]{ item });
        gildedRose.updateQuality();
        assertEquals(0, item.quality);
    }

    @Test
    public void testWhenItemIsAgedBrieThenQualityIncreases() {
        int initialQuality = 10;
        Item item = new Item("Aged Brie", 1, initialQuality);
        GildedRose gildedRose = new GildedRose(new Item[]{ item });
        gildedRose.updateQuality();
        assertEquals(11, item.quality);
    }

    @Test
    public void testWhenQualityOfItemIsFiftyThenNeverIncreasesMore() {
        int initialQuality = 50;
        Item item = new Item("Aged Brie", 1, initialQuality);
        GildedRose gildedRose = new GildedRose(new Item[]{ item });
        gildedRose.updateQuality();
        assertEquals(50, item.quality);
    }

    @Test
    public void testWhenItemSulfurasThenNeverDecreasesInQuality() {
        int initialQuality = 10;
        Item item = new Item("Sulfuras, Hand of Ragnaros", 1, initialQuality);
        GildedRose gildedRose = new GildedRose(new Item[]{ item });
        gildedRose.updateQuality();
        assertEquals(initialQuality, item.quality);
    }

    @Test
    @Parameters({
            "6, 20, 22",
            "8, 20, 22",
            "10, 20, 22",
            "3, 20, 23",
            "5, 20, 23"
    })
    public void testWhenItemBackstagePassesThenQualityIncreases(int sellIn, int initialQuality, int expectedQuality) {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, initialQuality);
        GildedRose gildedRose = new GildedRose(new Item[]{ item });
        gildedRose.updateQuality();
        assertEquals(expectedQuality, item.quality);
    }

}
