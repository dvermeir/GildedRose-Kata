package com.gildedrose;

import com.gildedrose.enhanceditem.CommonItemFactory;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            CommonItemFactory.create(item).update();
        }
    }

}
