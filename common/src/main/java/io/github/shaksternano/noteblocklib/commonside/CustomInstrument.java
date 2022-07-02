package io.github.shaksternano.noteblocklib.commonside;

import net.minecraft.block.enums.Instrument;
import net.minecraft.sound.SoundEvent;
import org.jetbrains.annotations.ApiStatus;

import java.util.function.Supplier;

/**
 * Represents a custom {@link Instrument}. Values added here are automatically added to the {@code Instrument} enum.
 */
public class CustomInstrument {

    private final String MOD_ID;
    private final String ENUM_NAME;
    private final String INSTRUMENT_NAME;
    private final Supplier<SoundEvent> INSTRUMENT_SOUND_SUPPLIER;

    /**
     * Constructs a new {@code CustomInstrument}.
     *
     * @param name                    The name of the instrument.
     * @param instrumentSoundSupplier The {@code Supplier} for the sound event for the instrument.
     *                                A {@code Supplier} is needed to prevent premature classloading
     *                                of the {@code SoundEvent} class.
     */
    @SuppressWarnings("SameParameterValue")
    public CustomInstrument(String modId, String name, Supplier<SoundEvent> instrumentSoundSupplier) {
        MOD_ID = modId;
        ENUM_NAME = modId.toUpperCase() + '$' + name.toUpperCase();
        INSTRUMENT_NAME = modId.toLowerCase() + '_' + name.toLowerCase();
        INSTRUMENT_SOUND_SUPPLIER = instrumentSoundSupplier;
    }

    /**
     * Gets the {@code Instrument} enum value corresponding to this custom instrument.
     *
     * @return The {@code Instrument} enum value corresponding to this custom instrument.
     */
    @ApiStatus.Internal
    public Instrument getInstrument() {
        return Instrument.valueOf(ENUM_NAME);
    }

    /**
     * Gets the ID of the mod that added this custom instrument.
     *
     * @return The ID of the mod that added this custom instrument.
     */
    @ApiStatus.Internal
    public String getModId() {
        return MOD_ID;
    }

    /**
     * Gets the name of the {@link Instrument} enum value corresponding to this custom instrument.
     *
     * @return The name of the {@code Instrument} enum value corresponding to this custom instrument.
     */
    @ApiStatus.Internal
    public String getEnumName() {
        return ENUM_NAME;
    }

    /**
     * Gets the name of the instrument.
     *
     * @return The name of the instrument.
     */
    @ApiStatus.Internal
    public String getInstrumentName() {
        return INSTRUMENT_NAME;
    }

    /**
     * Gets the {@code SoundEvent} that will be played when a note block
     * plays the {@link Instrument} corresponding to this custom instrument.
     *
     * @return The {@code SoundEvent} that will be played when a note block
     * plays the {@code Instrument} corresponding to this custom instrument.
     */
    @ApiStatus.Internal
    public SoundEvent getInstrumentSound() {
        return INSTRUMENT_SOUND_SUPPLIER.get();
    }
}
