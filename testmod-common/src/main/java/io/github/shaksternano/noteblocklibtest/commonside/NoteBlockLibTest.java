package io.github.shaksternano.noteblocklibtest.commonside;

import io.github.shaksternano.noteblocklibtest.commonside.init.ModBlocks;
import io.github.shaksternano.noteblocklibtest.commonside.init.ModItems;

public class NoteBlockLibTest {

    public static final String MOD_ID = "noteblocklibtest";

    public static void init() {
        ModBlocks.registerBlocks();
        ModItems.registerItems();
    }
}
