package io.github.shaksternano.noteblocklibtest.commonside.fabric;

import io.github.shaksternano.noteblocklibtest.commonside.NoteBlockLibTest;
import net.fabricmc.api.ModInitializer;

public class NoteBlockLibTestFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        NoteBlockLibTest.init();
    }
}
