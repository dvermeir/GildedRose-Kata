package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class GildedRoseTest {

    /*
    Item[] items = new Item[] {
        new Item("+5 Dexterity Vest", 10, 20), //
        new Item("Aged Brie", 2, 0), //
        new Item("Elixir of the Mongoose", 5, 7), //
        new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
        new Item("Sulfuras, Hand of Ragnaros", -1, 80),
        new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
        new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
        new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
        // this conjured item does not work properly yet
        new Item("Conjured Mana Cake", 3, 6) };
*/

    @Test
    void item_quality_degrades_and_sellin_value_decreases() {
        fail();
    }

    @Test
    void item_quality_degrades_twice_after_sell_date() {
        fail();
    }

    @Test
    void item_quality_degrades_not_negative() {
        fail();
    }

    @Test
    void aged_brie_quality_increases() {
        fail();
    }

    @Test
    void item_quality_increases_not_more_then_50() {
        fail();
    }

    @Test
    void sulfuras_does_not_sell_or_decrease_quality() {
        fail();
    }

    @Test
    void sulfuras_quality_never_alters() {
        fail();
    }

    @Test
    void backstage_pass_quality_increases_when_more_then_10_days() {
        fail();
    }

    @Test
    void backstage_pass_quality_double_increase_when_10() {
        fail();
    }
    @Test
    void backstage_pass_quality_double_increase_when_less_then_10_days() {
        fail();
    }
    @Test
    void backstage_pass_quality_triple_increase_when_5_days() {
        fail();
    }

    @Test
    void backstage_pass_quality_triple_increase_when_less_then_5_days() {
        fail();
    }

    @Test
    void conjured_item_degrades_twice_as_fast() {
        fail();
    }


}
