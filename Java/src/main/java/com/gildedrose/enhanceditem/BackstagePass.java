package com.gildedrose.enhanceditem;

import com.gildedrose.Item;

public class BackstagePass extends CommonItem {

    public BackstagePass(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (isSellInDatePassed()) {
            resetQualityToMinimum();
        } else if (isSellInLessThen(6)) {
            increaseQuality(3);
        } else if (isSellInLessThen(11)) {
            increaseQuality(2);
        } else {
            increaseQuality(1);
        }
    }
}


