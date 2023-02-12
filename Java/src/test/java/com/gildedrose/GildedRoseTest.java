package com.gildedrose;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GildedRoseTest {

    public static final String ELIXIR = "Elixir of the Mongoose";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    public static final String CONJURED = "Conjured Mana Cake";

    @Test
    void item_quality_degrades_and_sellin_value_decreases() {
        verifySingleItemUpdate(ELIXIR, 5, 7, 4,6);
    }

    @Test
    void item_with_quality_0_sellin_value_decreases_quality_remains() {
        verifySingleItemUpdate(ELIXIR, 0, 0, -1,0);
    }

    @Test
    void item_at_sellin_date_quality_degrades_twice_and_sellin_decreases() {
        verifySingleItemUpdate(ELIXIR, 0, 4, -1,2);
    }

    @Test
    void item_after_sellin_date_quality_degrades_twice_and_sellin_decreases() {
        verifySingleItemUpdate(ELIXIR, -1, 4, -2,2);
    }

    @Test
    void item_before_sellin_date_and_quality_0_doesnt_degrade() {
        verifySingleItemUpdate(ELIXIR, 5, 0, 4, 0);
    }

    @Test
    void item_after_sellin_date_and_quality_0_doesnt_degrade() {
        verifySingleItemUpdate(ELIXIR, -1, 0, -2, 0);
    }

    @Test
    void aged_brie_before_sellin_date_quality_increases() {
        verifySingleItemUpdate(AGED_BRIE, 2, 3, 1, 4);
    }

    @Test
    void aged_brie_at_sellin_date_quality_increases_twice() {
        verifySingleItemUpdate(AGED_BRIE, 0, 3, -1, 5);
    }

    // TODO check with Allison if increasing quality twice is expected behaviour or a bug.
    @Test
    void aged_brie_after_sellin_date_quality_increases_twice() {
        verifySingleItemUpdate(AGED_BRIE, -1, 3, -2, 5);
    }


    void age_brie_with_quality_50_does_not_increase() {
        verifySingleItemUpdate(AGED_BRIE, -1, 50, -2,50);
    }


    @Test
    void sulfuras_before_sellin_date_does_not_alter() {
        verifySingleItemUpdate(SULFURAS, 1, 80,1,80);
    }

    // test necessary?
    @Test
    void sulfuras_after_sellin_date_does_not_alter() {
        verifySingleItemUpdate(SULFURAS, -1, 80, -1, 80);
    }

    @Test
    void backstagepass_with_sellin_more_then_10_days_quality_increases() {
        verifySingleItemUpdate(BACKSTAGE_PASS, 15, 20, 14,21);
    }

    @Test
    void backstagepass_with_sellin_10_increases_qualtiy_double() {
        verifySingleItemUpdate(BACKSTAGE_PASS, 10, 36,  9,38);
    }
    @Test
    void backstagepass_with_sellin_less_then_10_increases_quality_double() {
        verifySingleItemUpdate(BACKSTAGE_PASS, 8, 20,7,22);
    }
    @Test
    void backstagepass_with_sellin_5_increases_quality_triple() {
        verifySingleItemUpdate(BACKSTAGE_PASS, 5, 10, 4, 13);
    }

    @Test
    void backstagepass_with_sellin_less_then_5_increases_quality_triple() {
        verifySingleItemUpdate(BACKSTAGE_PASS, 3, 11, 2, 14);
    }

    @Test
    void backstagepass_at_sellin_decreaeses_quality_to_zero() {
        verifySingleItemUpdate(BACKSTAGE_PASS, 0, 11, -1, 0);
    }

    @Test
    void backstagepass_after_sellin_decreases_quality_to_zero() {
        verifySingleItemUpdate(BACKSTAGE_PASS, -1, 11, -2, 0);
    }

    @Test
    void conjured_item_before_sellin_date_degrades_double() {
        verifySingleItemUpdate(CONJURED, 2,3,1,1);
    }

    @Test
    void conjured_item_after_sellin_date_degrades_4times() {
        verifySingleItemUpdate(CONJURED, -1,8,-2,4);
    }

    @Test
    void null_item_throws_exception() {
        GildedRose inn = new GildedRose(new Item[] {null});

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> inn.updateQuality());
    }
    @Test
    void item_with_negative_quality_throws_exception() {
        Item item = new Item(ELIXIR, 5, -2);

        GildedRose inn = new GildedRose(new Item[] {item});

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> inn.updateQuality());
    }

    @Test
    @Disabled
    void item_with_null_name_throws_exception() {
        Item item = new Item(null, 5, 5);

        GildedRose inn = new GildedRose(new Item[] {item});

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> inn.updateQuality());
    }

    @Test
    void multiple_items_quality_modifies_and_sellin_decrease() {
        Item vest = new Item("+5 Dexterity Vest", 10, 20);
        Item agedBrie = new Item(AGED_BRIE, 2, 0);
        Item elixir =  new Item(ELIXIR, 5, 7);
        Item sulfuras =  new Item(SULFURAS, 0, 80);

        GildedRose inn = new GildedRose(new Item[] {vest, agedBrie, elixir, sulfuras});
        inn.updateQuality();

        assertThat(vest.sellIn, is(9));
        assertThat(vest.quality, is(19));

        assertThat(agedBrie.sellIn, is(1));
        assertThat(agedBrie.quality, is(1));

        assertThat(elixir.sellIn, is(4));
        assertThat(elixir.quality, is(6));

        assertThat(sulfuras.sellIn, is(0));
        assertThat(sulfuras.quality, is(80));
    }

     private void verifySingleItemUpdate(String itemName, int itemSellIn, int itemQuality, int expectedItemSellIn, int expectedItemQuality) {
        Item item = new Item(itemName, itemSellIn, itemQuality);

        GildedRose inn = new GildedRose(new Item[] {item});
        inn.updateQuality();

        assertThat("Item sellIn incorrect", item.sellIn, is(expectedItemSellIn));
        assertThat("Item quality incorrect", item.quality, is(expectedItemQuality));

    }

}
