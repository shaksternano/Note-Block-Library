package io.github.shaksternano.noteblocklib.commonside;

import net.minecraft.block.enums.Instrument;

/**
 * Contains an {@link Instrument}.
 */
public interface InstrumentContainer {

    /**
     * Gets the contained {@code Instrument}.
     *
     * @return The contained {@code Instrument}.
     */
    Instrument getInstrument();
}
