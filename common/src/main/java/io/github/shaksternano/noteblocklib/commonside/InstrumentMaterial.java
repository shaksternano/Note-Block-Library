package io.github.shaksternano.noteblocklib.commonside;

import net.minecraft.block.Material;
import net.minecraft.block.enums.Instrument;

/**
 * A block with a material of this class will play the specified
 * instrument when a note block placed over the block is played.
 */
public class InstrumentMaterial extends Material {

    private final Instrument INSTRUMENT;

    /**
     * Creates a new {@code InstrumentMaterial} from a {@code Material}.
     *
     * @param material   The {@code Material} to base this {@code InstrumentMaterial} on.
     * @param instrument The {@code Instrument} of this {@code InstrumentMaterial}.
     */
    public InstrumentMaterial(Material material, Instrument instrument) {
        super(
                material.getColor(),
                material.isLiquid(),
                material.isSolid(),
                material.blocksMovement(),
                material.blocksLight(),
                material.isBurnable(),
                material.isReplaceable(),
                material.getPistonBehavior()
        );
        INSTRUMENT = instrument;
    }

    /**
     * Creates a new {@code InstrumentMaterial} from a {@code Material}.
     *
     * @param material         The {@code Material} to base this {@code InstrumentMaterial} on.
     * @param customInstrument The {@code CustomInstrument} representing the {@link Instrument} of this {@code InstrumentMaterial}.
     */
    public InstrumentMaterial(Material material, CustomInstrument customInstrument) {
        this(material, customInstrument.getInstrument());
    }

    /**
     * Gets the {@code Instrument} of this {@code InstrumentMaterial}.
     *
     * @return The {@code Instrument} of this {@code InstrumentMaterial}.
     */
    public Instrument getInstrument() {
        return INSTRUMENT;
    }
}
