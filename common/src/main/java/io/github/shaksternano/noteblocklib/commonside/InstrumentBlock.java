package io.github.shaksternano.noteblocklib.commonside;

import net.minecraft.block.Block;
import net.minecraft.block.enums.Instrument;

/**
 * A {@code Block} that contains an {@link Instrument} which is played by note blocks placed over it.
 */
public class InstrumentBlock extends Block implements InstrumentContainer {

    private final Instrument instrument;

    /**
     * Creates a new {@code InstrumentBlock}.
     *
     * @param instrument The {@code Instrument} to be played by note blocks placed over this block.
     * @param settings   The block settings.
     */
    public InstrumentBlock(Instrument instrument, Settings settings) {
        super(settings);
        this.instrument = instrument;
    }

    /**
     * Creates a new {@code InstrumentBlock}.
     *
     * @param customInstrument The {@code CustomInstrument} whose corresponding {@link Instrument} is
     *                         to be played by note blocks placed over this block.
     * @param settings         The block settings.
     */
    public InstrumentBlock(CustomInstrument customInstrument, Settings settings) {
        this(customInstrument.getInstrument(), settings);
    }

    @Override
    public Instrument getInstrument() {
        return instrument;
    }
}
