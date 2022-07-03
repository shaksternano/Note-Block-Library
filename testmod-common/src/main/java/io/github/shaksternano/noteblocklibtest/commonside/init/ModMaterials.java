package io.github.shaksternano.noteblocklibtest.commonside.init;

import io.github.shaksternano.noteblocklib.commonside.InstrumentMaterial;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;

public class ModMaterials {

    public static final Material CAT_MATERIAL = new InstrumentMaterial(new Material.Builder(MapColor.GRAY).build(), ModCustomInstruments.CAT_INSTRUMENT);
    public static final Material WOLF_MATERIAL = new InstrumentMaterial(new Material.Builder(MapColor.GRAY).build(), ModCustomInstruments.WOLF_INSTRUMENT);
}
