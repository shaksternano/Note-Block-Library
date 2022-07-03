package io.github.shaksternano.noteblocklib.commonside.fabric;

import com.chocohead.mm.api.ClassTinkerers;
import io.github.shaksternano.noteblocklib.commonside.CustomInstrument;
import io.github.shaksternano.noteblocklib.commonside.CustomInstrumentRegistry;
import io.github.shaksternano.noteblocklib.commonside.NoteBlockLib;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;
import net.minecraft.block.enums.Instrument;
import org.jetbrains.annotations.ApiStatus;

public class NoteBlockLibEarlyRiser implements Runnable {

    /**
     * Adds custom {@link Instrument} enum values.
     * Forge equivalent is
     * {@code io.github.shaksternano.noteblocklib.mixin.forge.commonside.InstrumentMixin#noteBlockLib$addCustomInstruments}
     */
    @ApiStatus.Internal
    @Override
    public void run() {
        MappingResolver remapper = FabricLoader.getInstance().getMappingResolver();
        String instrumentClassName = remapper.mapClassName("intermediary", "net.minecraft.class_2766");
        String soundEventInternalClassName = 'L' + remapper.mapClassName("intermediary", "net.minecraft.class_3414") + ';';

        for (CustomInstrument instrument : CustomInstrumentRegistry.getRegisteredInstruments()) {
            ClassTinkerers.enumBuilder(instrumentClassName, String.class, soundEventInternalClassName)
                    .addEnum(instrument.getEnumName(), () -> new Object[]{instrument.getInstrumentName(), instrument.getInstrumentSound()})
                    .build();
            NoteBlockLib.logInstrumentAdded(instrument);
        }
    }
}
