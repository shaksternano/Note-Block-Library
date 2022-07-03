package io.github.shaksternano.noteblocklib.commonside;

import net.minecraft.block.enums.Instrument;
import org.jetbrains.annotations.ApiStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoteBlockLib {

    @ApiStatus.Internal
    public static final String MOD_ID = "noteblocklib";
    @ApiStatus.Internal
    public static final Logger LOGGER = LoggerFactory.getLogger("Note Block Library");

    /**
     * Logs information about an added {@link Instrument} enum value.
     *
     * @param customInstrument The {@code CustomInstrument} corresponding to
     *                         the added {@code Instrument} enum value.
     */
    @ApiStatus.Internal
    public static void logInstrumentAdded(CustomInstrument customInstrument) {
        NoteBlockLib.LOGGER.info("Added custom note block instrument \"{}\" from {}", customInstrument.getNameWithoutPrefix(), customInstrument.getModId());
    }
}
