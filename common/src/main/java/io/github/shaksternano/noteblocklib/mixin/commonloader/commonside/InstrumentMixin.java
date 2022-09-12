package io.github.shaksternano.noteblocklib.mixin.commonloader.commonside;

import io.github.shaksternano.noteblocklib.commonside.InstrumentContainer;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.Instrument;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Instrument.class)
abstract class InstrumentMixin {

    /**
     * If the {@link BlockState}'s block is an instance of {@link InstrumentContainer}, the corresponding instrument will be played.
     */
    @Inject(method = "fromBlockState", at = @At("HEAD"), cancellable = true)
    private static void noteBlockLib$customMaterialNoteBlockInstrument(BlockState state, CallbackInfoReturnable<Instrument> cir) {
        if (state.getBlock() instanceof InstrumentContainer instrumentContainer) {
            cir.setReturnValue(instrumentContainer.getInstrument());
        }
    }
}
