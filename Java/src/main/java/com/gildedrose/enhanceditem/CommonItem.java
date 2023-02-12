package com.gildedrose.enhanceditem;

import com.gildedrose.Item;

public class CommonItem {

    public static final int ITEM_MAX_QUANTITY = 50;
    private static final int ITEM_MIN_QUANTITY = 0;

    private final Item item;

    public static boolean isValid(Item item) {
        return (item!= null && item.name != null && item.quality >= 0);
    }

    protected CommonItem(Item item) {
        this.item = item;
    }

    public void update() {
        updateQuality();
        updateSellIn();
    }

    protected void updateQuality() {
        decreaseQuality(isSellInDatePassed() ? 2 : 1);
    }

    protected void updateSellIn() {
        item.sellIn = item.sellIn - 1;
    }

    protected boolean isSellInDatePassed() {
        return item.sellIn <= 0;
    }

    protected boolean isSellInLessThen(int days) {
        return item.sellIn < days;
    }

    protected void decreaseQuality(int quantity) {
        item.quality = Math.max(ITEM_MIN_QUANTITY, item.quality - quantity);
    }

    protected void resetQualityToMinimum() {
        item.quality= CommonItem.ITEM_MIN_QUANTITY;
    }

    protected void increaseQuality(int quantity) {
        item.quality = Math.min(ITEM_MAX_QUANTITY,item.quality + quantity);
    }
}
