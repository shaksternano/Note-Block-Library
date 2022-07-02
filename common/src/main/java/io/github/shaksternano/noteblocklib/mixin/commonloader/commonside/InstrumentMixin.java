package io.github.shaksternano.noteblocklib.mixin.commonloader.commonside;

import io.github.shaksternano.noteblocklib.commonside.InstrumentMaterial;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.Instrument;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Instrument.class)
abstract class InstrumentMixin {

    /**
     * If the {@link BlockState}'s material is an instance of {@link InstrumentMaterial}, the corresponding instrument will be played.
     */
    @Inject(method = "fromBlockState", at = @At("HEAD"), cancellable = true)
    private static void noteBlockLib$customMaterialNoteBlockInstrument(BlockState state, CallbackInfoReturnable<Instrument> cir) {
        if (state.getMaterial() instanceof InstrumentMaterial instrumentMaterial) {
            cir.setReturnValue(instrumentMaterial.getInstrument());
        }
    }
}
