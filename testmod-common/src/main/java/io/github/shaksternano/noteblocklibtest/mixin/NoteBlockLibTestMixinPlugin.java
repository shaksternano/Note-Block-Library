package io.github.shaksternano.noteblocklibtest.mixin;

import io.github.shaksternano.noteblocklib.commonside.CustomInstrumentRegistry;
import io.github.shaksternano.noteblocklibtest.commonside.init.ModCustomInstruments;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class NoteBlockLibTestMixinPlugin implements IMixinConfigPlugin {

    @Override
    public void onLoad(String mixinPackage) {
        CustomInstrumentRegistry.registerInstruments(
                ModCustomInstruments.CAT,
                ModCustomInstruments.WOLF,
                ModCustomInstruments.CAT_DUPLICATE
        );
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }
}
