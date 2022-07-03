package io.github.shaksternano.noteblocklib.commonside;

import com.google.common.base.Enums;
import net.minecraft.block.enums.Instrument;
import net.minecraft.sound.SoundEvent;
import org.jetbrains.annotations.ApiStatus;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * Represents a custom {@link Instrument}. Values added here are automatically added to the {@code Instrument} enum.
 */
public class CustomInstrument {

    private final String MOD_ID;
    private final String NAME_WITHOUT_PREFIX;
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
        NAME_WITHOUT_PREFIX = name;
        INSTRUMENT_SOUND_SUPPLIER = instrumentSoundSupplier;
    }

    /**
     * Gets the {@code Instrument} enum value corresponding to this custom instrument.
     *
     * @return The {@code Instrument} enum value corresponding to this custom instrument.
     */
    public Instrument getInstrument() {
        String enumName = getEnumName();
        Optional<Instrument> instrumentOptional = Enums.getIfPresent(Instrument.class, enumName).toJavaUtil();
        Instrument fallBack = Instrument.HARP;
        if (instrumentOptional.isEmpty()) {
            NoteBlockLib.LOGGER.error("Could not find enum value \"{}\" in enum {}, using fallback enum value {} instead!", enumName, Instrument.class.getName(), fallBack);
        }
        return instrumentOptional.orElse(fallBack);
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
     * Gets the name of the instrument without the mod ID prefix.
     *
     * @return The name of the instrument without the mod ID prefix.
     */
    @ApiStatus.Internal
    public String getNameWithoutPrefix() {
        return NAME_WITHOUT_PREFIX;
    }

    /**
     * Gets the name of the {@link Instrument} enum value corresponding to this custom instrument.
     *
     * @return The name of the {@code Instrument} enum value corresponding to this custom instrument.
     */
    @ApiStatus.Internal
    public String getEnumName() {
        return MOD_ID.toUpperCase() + '$' + NAME_WITHOUT_PREFIX.toUpperCase();
    }

    /**
     * Gets the name of the instrument.
     *
     * @return The name of the instrument.
     */
    @ApiStatus.Internal
    public String getInstrumentName() {
        return MOD_ID.toLowerCase() + '_' + NAME_WITHOUT_PREFIX.toLowerCase();
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
