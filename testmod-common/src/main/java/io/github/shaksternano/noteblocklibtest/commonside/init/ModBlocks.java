package io.github.shaksternano.noteblocklibtest.commonside.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import io.github.shaksternano.noteblocklibtest.commonside.NoteBlockLibTest;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("unused")
public class ModBlocks {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(NoteBlockLibTest.MOD_ID, Registry.BLOCK_KEY);

    public static final RegistrySupplier<Block> CAT = BLOCKS.register(
            "cat",
            () -> new Block(AbstractBlock.Settings.of(ModMaterials.CAT).strength(6).requiresTool())
    );
    public static final RegistrySupplier<Block> WOLF = BLOCKS.register(
            "wolf",
            () -> new Block(AbstractBlock.Settings.of(ModMaterials.WOLF).strength(6).requiresTool())
    );

    public static void registerBlocks() {
        BLOCKS.register();
    }
}
