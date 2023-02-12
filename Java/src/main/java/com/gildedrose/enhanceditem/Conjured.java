package com.gildedrose.enhanceditem;

import com.gildedrose.Item;

public class Conjured extends CommonItem {

    protected Conjured(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        decreaseQuality(isSellInDatePassed() ? 4 : 2);
    }
}
