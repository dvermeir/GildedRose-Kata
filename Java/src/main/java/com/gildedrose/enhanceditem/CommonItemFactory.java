package com.gildedrose.enhanceditem;

import com.gildedrose.Item;

public class CommonItemFactory {

    public static CommonItem create(Item item) {
        if (CommonItem.isValid(item)) {
            return switch (item.name) {
                case "Sulfuras, Hand of Ragnaros" -> new Legendary(item);
                case "Aged Brie" -> new AgedBrie(item);
                case "Backstage passes to a TAFKAL80ETC concert" -> new BackstagePass(item);
                case "Conjured Mana Cake" -> new Conjured(item);
                default -> new CommonItem(item);
            };
        } else {
            throw new IllegalArgumentException("Invalid item. Item and item name should be non NULL and item quality should not be negative");
        }
    }
}
