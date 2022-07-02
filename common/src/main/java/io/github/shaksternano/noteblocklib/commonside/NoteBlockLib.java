package io.github.shaksternano.noteblocklib.commonside;

import net.minecraft.block.enums.Instrument;
import org.jetbrains.annotations.ApiStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class NoteBlockLib {

    @ApiStatus.Internal
    public static final String MOD_ID = "noteblocklib";
    @ApiStatus.Internal
    public static final Logger LOGGER = LoggerFactory.getLogger("Note Block Library");

    /**
     * Logs information about added {@link Instrument} enum vales.
     *
     * @param customInstruments The {@code CustomInstrument}s corresponding
     *                          to the added {@code Instrument} enum values.
     */
    @ApiStatus.Internal
    public static void logInstrumentsAdded(Collection<CustomInstrument> customInstruments) {
        int customInstrumentCount = customInstruments.size();
        if (customInstrumentCount > 0) {
            Set<String> modIds = new HashSet<>();
            for (CustomInstrument customInstrument : customInstruments) {
                modIds.add(customInstrument.getModId());
            }

            String message = "Added " + customInstrumentCount + " custom note block instrument";
            if (customInstrumentCount > 1) {
                message += "s";
            }
            message += " from " + modIds.size() + " mod";
            if (modIds.size() > 1) {
                message += "s";
            }
            NoteBlockLib.LOGGER.info(message);
        } else {
            NoteBlockLib.LOGGER.warn("No custom note block instruments added");
        }
    }
}
