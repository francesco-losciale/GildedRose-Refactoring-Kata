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
        assertEquals(989, new Item("test", 989, 1).sellIn);
    }
    
    @Test
    public void testWhenItemIsCreatedThenQualityIsCorrect() {
        assertEquals(989, new Item("test", 1,989).quality);
    }

    @Test
    public void testWhenEndDayUpdateThenQualityDecreases() {
        Item item = new Item("test", 1, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{ item });
        gildedRose.updateQuality();
        assertEquals(49, item.quality);
    }

    @Test
    public void testWhenEndDayUpdateThenSellInDecreases() {
        Item item = new Item("test", 999, 1);
        GildedRose gildedRose = new GildedRose(new Item[]{ item });
        gildedRose.updateQuality();
        assertEquals(998, item.sellIn);
    }

    @Test
    public void testWhenEndDayAndSellInDateHasPassedThenQualityDecreasesTwice() {
        Item item = new Item("test", 0, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{ item });
        gildedRose.updateQuality();
        assertEquals(48, item.quality);
    }

    @Test
    public void testWhenEndDayAndQualityIsNegativeOrZeroThenQualityIsIgnored() {
        Item item1 = new Item("test", 1, -1);
        Item item2 = new Item("test", 1, 0);
        GildedRose gildedRose = new GildedRose(new Item[]{ item1, item2 });
        gildedRose.updateQuality();
        assertEquals(-1, item1.quality);
        assertEquals(0, item2.quality);
    }

    @Test
    public void testWhenEndDayAndItemAgedBrieThenQualityIncreases() {
        Item item = new Item("Aged Brie", 10, 5);
        GildedRose gildedRose = new GildedRose(new Item[]{ item });
        gildedRose.updateQuality();
        assertEquals(6, item.quality);
    }

    @Test
    public void testWhenEndDayAndQualityIs50ThenQualityIsIgnored() {
        Item item = new Item("Aged Brie", 1, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{ item });
        gildedRose.updateQuality();
        assertEquals(50, item.quality);
    }

    @Test
    public void testWhenEndDayAndItemSulfurasThenNeverSold() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 1);
        GildedRose gildedRose = new GildedRose(new Item[]{ item });
        gildedRose.updateQuality();
        assertEquals(10, item.sellIn);
    }

    @Test
    public void testWhenEndDayAndItemSulfurasThenQualityIsAlways80() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 10);
        GildedRose gildedRose = new GildedRose(new Item[]{ item });
        gildedRose.updateQuality();
        assertEquals(80, item.quality);
    }

    @Test
    public void testWhenEndDayAndSellInPassedAndItemBackstageThenQualityDropToZero() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10);
        GildedRose gildedRose = new GildedRose(new Item[]{ item });
        gildedRose.updateQuality();
        assertEquals(0, item.quality);
    }

    @Test
    public void testWhenEndDayAndItemBackstagePassesAndSellInLessThanFiveThenQualityIncreasesByThree() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 10);
        GildedRose gildedRose = new GildedRose(new Item[]{ item });
        gildedRose.updateQuality();
        assertEquals(13, item.quality);
    }

    @Test
    public void testWhenEndDayAndItemBackstagePassesAndSellInLessThanTenThenQualityIncreasesByTwo() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 8, 10);
        GildedRose gildedRose = new GildedRose(new Item[]{ item });
        gildedRose.updateQuality();
        assertEquals(12, item.quality);
    }

}
