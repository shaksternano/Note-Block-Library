package io.github.shaksternano.noteblocklib.commonside;

import org.jetbrains.annotations.ApiStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Where {@link CustomInstrument}s are registered.
 */
public class CustomInstrumentRegistry {

    private static final List<CustomInstrument> CUSTOM_INSTRUMENTS = new ArrayList<>();

    /**
     * Registers {@code CustomInstrument}s.
     *
     * @param instruments The {@code CustomInstrument}s to register.
     */
    public static void registerInstruments(Iterable<CustomInstrument> instruments) {
        for (CustomInstrument instrument : instruments) {
            CUSTOM_INSTRUMENTS.add(instrument);
        }
    }

    /**
     * Registers {@code CustomInstrument}s.
     *
     * @param instruments The {@code CustomInstrument}s to register.
     */
    public static void registerInstruments(CustomInstrument... instruments) {
        CUSTOM_INSTRUMENTS.addAll(Arrays.asList(instruments));
    }

    /**
     * Gets an unmodifiable view of the registered {@code CustomInstrument}s.
     *
     * @return An unmodifiable view of the registered {@code CustomInstrument}s.
     */
    @ApiStatus.Internal
    public static List<CustomInstrument> getRegisteredInstruments() {
        return Collections.unmodifiableList(CUSTOM_INSTRUMENTS);
    }
}
