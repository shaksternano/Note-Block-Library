package io.github.shaksternano.noteblocklib.commonside;

import com.google.common.base.Enums;
import net.minecraft.block.enums.Instrument;
import net.minecraft.sound.SoundEvent;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Represents a custom {@link Instrument}. Values added here are automatically added to the {@code Instrument} enum.
 */
public class CustomInstrument {

    private final String modId;
    private final String nameWithoutPrefix;
    private final Supplier<SoundEvent> instrumentSoundSupplier;
    @Nullable
    private Instrument instrument;

    /**
     * Constructs a new {@code CustomInstrument}.
     *
     * @param modId                   The mod ID of the mod that added this {@code CustomInstrument},
     *                                used to prefix the {@code name} to prevent conflicts.
     * @param name                    The name of the instrument.
     * @param instrumentSoundSupplier The {@code Supplier} for the sound event for the instrument.
     *                                A {@code Supplier} is needed to prevent premature classloading
     *                                of the {@code SoundEvent} class.
     */
    @SuppressWarnings("SameParameterValue")
    public CustomInstrument(String modId, String name, Supplier<SoundEvent> instrumentSoundSupplier) {
        this.modId = modId;
        nameWithoutPrefix = name;
        this.instrumentSoundSupplier = instrumentSoundSupplier;
    }

    /**
     * Gets the {@code Instrument} enum value corresponding to this custom instrument.
     *
     * @return The {@code Instrument} enum value corresponding to this custom instrument.
     */
    public Instrument getInstrument() {
        if (instrument == null) {
            instrument = retrieveInstrument();
        }
        return instrument;
    }

    /**
     * Gets the instrument from the instrument enum name.
     * If there is no instrument with the enum name, {@link Instrument#HARP} is returned.
     *
     * @return The instrument from the instrument enum name.
     */
    private Instrument retrieveInstrument() {
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
        return modId;
    }

    /**
     * Gets the name of the instrument without the mod ID prefix.
     *
     * @return The name of the instrument without the mod ID prefix.
     */
    @ApiStatus.Internal
    public String getNameWithoutPrefix() {
        return nameWithoutPrefix;
    }

    /**
     * Gets the name of the {@link Instrument} enum value corresponding to this custom instrument.
     *
     * @return The name of the {@code Instrument} enum value corresponding to this custom instrument.
     */
    @ApiStatus.Internal
    public String getEnumName() {
        return modId.toUpperCase() + '$' + nameWithoutPrefix.toUpperCase();
    }

    /**
     * Gets the name of the instrument.
     *
     * @return The name of the instrument.
     */
    @ApiStatus.Internal
    public String getInstrumentName() {
        return modId.toLowerCase() + '_' + nameWithoutPrefix.toLowerCase();
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
        return instrumentSoundSupplier.get();
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                modId,
                nameWithoutPrefix
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj instanceof CustomInstrument other) {
            return Objects.equals(modId, other.modId)
                    && Objects.equals(nameWithoutPrefix, other.nameWithoutPrefix);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{MOD_ID=" + modId + ", NAME=" + nameWithoutPrefix + '}';
    }
}
