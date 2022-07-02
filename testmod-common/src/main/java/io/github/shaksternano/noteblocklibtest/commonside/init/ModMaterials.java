package io.github.shaksternano.noteblocklibtest.commonside.init;

import io.github.shaksternano.noteblocklib.commonside.InstrumentMaterial;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;

public class ModMaterials {

    public static final Material CAT = new InstrumentMaterial(new Material.Builder(MapColor.GRAY).build(), ModCustomInstruments.CAT);
    public static final Material WOLF = new InstrumentMaterial(new Material.Builder(MapColor.GRAY).build(), ModCustomInstruments.WOLF);
}
