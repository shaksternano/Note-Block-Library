package io.github.shaksternano.noteblocklibtest.commonside.init;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import io.github.shaksternano.noteblocklibtest.commonside.NoteBlockLibTest;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("unused")
public class ModItems {

    private static final ItemGroup TEST_GROUP = CreativeTabRegistry.create(
            new Identifier(NoteBlockLibTest.MOD_ID, "items"),
            () -> new ItemStack(ModItems.CAT_BLOCK.get())
    );

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(NoteBlockLibTest.MOD_ID, Registry.ITEM_KEY);

    // Block items

    public static final RegistrySupplier<Item> CAT_BLOCK = ITEMS.register(
            "cat",
            () -> new BlockItem(ModBlocks.CAT_BLOCK.get(), new Item.Settings().group(TEST_GROUP))
    );
    public static final RegistrySupplier<Item> WOLF_BLOCK = ITEMS.register(
            "wolf",
            () -> new BlockItem(ModBlocks.WOLF_BLOCK.get(), new Item.Settings().group(TEST_GROUP))
    );

    public static void registerItems() {
        ITEMS.register();
    }
}
