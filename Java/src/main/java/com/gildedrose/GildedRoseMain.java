package com.gildedrose;

public class GildedRoseMain {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20), //
            new Item("Aged Brie", 2, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        for (int i = 0; i < getDays(args); i++) {
            printCurrentDay(items, i);
            app.updateQuality();
        }
    }

    private static void printCurrentDay(Item[] items, int i) {
        String itemLineFormat = "%-45s%-7s%-8s%n";
        printDayHeader(i);
        printItemHeader(itemLineFormat);
        for (Item item : items) {
            printItem(itemLineFormat, item);
        }
    }

    private static void printDayHeader(int i) {
        System.out.printf(
            ("-").repeat(27)
                .concat("day %s")
                .concat(("-").repeat(27))
                .concat("%n")
            , i);
    }
    private static void printItemHeader(String itemLineFormat) {
        System.out.printf(itemLineFormat, "name", "sellIn", "quality");
    }

    private static void printItem(String itemLineFormat, Item item) {
        System.out.printf(itemLineFormat, item.name, item.sellIn, item.quality);
    }

    private static int getDays(String[] args) {
        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]);
        }
        return days;
    }

}
