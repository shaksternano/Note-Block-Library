package io.github.shaksternano.noteblocklibtest.commonside.forge;

import dev.architectury.platform.forge.EventBuses;
import io.github.shaksternano.noteblocklibtest.commonside.NoteBlockLibTest;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(NoteBlockLibTest.MOD_ID)
public class NoteBlockLibTestForge {

    public NoteBlockLibTestForge() {
        EventBuses.registerModEventBus(NoteBlockLibTest.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        NoteBlockLibTest.init();
    }
}
