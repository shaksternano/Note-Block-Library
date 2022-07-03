package io.github.shaksternano.noteblocklib.commonside;

import org.jetbrains.annotations.ApiStatus;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

/**
 * Where {@link CustomInstrument}s are registered.
 */
public class CustomInstrumentRegistry {

    private static final Collection<CustomInstrument> CUSTOM_INSTRUMENTS = new LinkedHashSet<>();

    public static void registerInstrument(CustomInstrument instrument) {
        if (CUSTOM_INSTRUMENTS.contains(instrument)) {
            NoteBlockLib.LOGGER.error(
                    "A custom instrument with mod ID \"{}\" and name \"{}\" has already been registered, skipping it!",
                    instrument.getModId(),
                    instrument.getNameWithoutPrefix()
            );
        } else {
            CUSTOM_INSTRUMENTS.add(instrument);
        }
    }

    /**
     * Registers {@code CustomInstrument}s.
     *
     * @param instruments The {@code CustomInstrument}s to register.
     */
    public static void registerInstruments(Iterable<CustomInstrument> instruments) {
        for (CustomInstrument instrument : instruments) {
            registerInstrument(instrument);
        }
    }

    /**
     * Registers {@code CustomInstrument}s.
     *
     * @param instruments The {@code CustomInstrument}s to register.
     */
    public static void registerInstruments(CustomInstrument... instruments) {
        for (CustomInstrument instrument : instruments) {
            registerInstrument(instrument);
        }
    }

    /**
     * Gets an unmodifiable view of the registered {@code CustomInstrument}s.
     *
     * @return An unmodifiable view of the registered {@code CustomInstrument}s.
     */
    @ApiStatus.Internal
    public static Iterable<CustomInstrument> getRegisteredInstruments() {
        return Collections.unmodifiableCollection(CUSTOM_INSTRUMENTS);
    }
}
