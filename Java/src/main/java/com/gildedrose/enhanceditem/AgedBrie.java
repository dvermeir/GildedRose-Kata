package com.gildedrose.enhanceditem;

import com.gildedrose.Item;

public class AgedBrie extends CommonItem {

    protected AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        increaseQuality(isSellInDatePassed() ? 2 : 1);
    }

}
