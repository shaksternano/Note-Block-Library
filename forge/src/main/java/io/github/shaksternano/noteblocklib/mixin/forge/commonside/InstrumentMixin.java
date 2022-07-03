package io.github.shaksternano.noteblocklib.mixin.forge.commonside;

import io.github.shaksternano.noteblocklib.commonside.CustomInstrument;
import io.github.shaksternano.noteblocklib.commonside.CustomInstrumentRegistry;
import io.github.shaksternano.noteblocklib.commonside.NoteBlockLib;
import net.minecraft.block.enums.Instrument;
import net.minecraft.sound.SoundEvent;
import net.minecraftforge.common.IExtensibleEnum;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * {@link IExtensibleEnum} is implemented onto {@link Instrument} to allow for
 * extra enum values to be added via {@link #create(String, String, SoundEvent)}
 */
@Mixin(Instrument.class)
abstract class InstrumentMixin implements IExtensibleEnum {

    /**
     * Adds custom {@link Instrument} enum values.
     * Fabric equivalent is {@code io.github.shaksternano.noteblocklib.commonside.fabric.NoteBlockLibEarlyRiser#run}
     */
    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void noteBlockLib$addCustomInstruments(CallbackInfo ci) {
        for (CustomInstrument instrument : CustomInstrumentRegistry.getRegisteredInstruments()) {
            create(instrument.getEnumName(), instrument.getInstrumentName(), instrument.getInstrumentSound());
            NoteBlockLib.logInstrumentAdded(instrument);
        }
    }

    /**
     * Adds a custom {@link Instrument} enum value.
     * The contents of this method will be replaced by Forge at runtime.
     */
    @SuppressWarnings({"SameParameterValue", "unused", "UnusedReturnValue"})
    private static Instrument create(String enumName, String instrumentName, SoundEvent sound) {
        throw new IllegalStateException("Enum not extended");
    }
}
