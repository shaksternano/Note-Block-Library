# Note Block Library

## Usage
Create `CustomInstrument`s:
```java
public static final CustomInstrument CAT = new CustomInstrument(NoteBlockLibTest.MOD_ID, "cat", () -> SoundEvents.ENTITY_CAT_AMBIENT);
public static final CustomInstrument WOLF = new CustomInstrument(NoteBlockLibTest.MOD_ID, "wolf", () -> SoundEvents.ENTITY_WOLF_AMBIENT);
```

Register them in the `onLoad` method in an [IMixinConfigPlugin](https://github.com/SpongePowered/Mixin/blob/master/src/main/java/org/spongepowered/asm/mixin/extensibility/IMixinConfigPlugin.java "IMixinConfigPlugin"):
```java
@Override
public void onLoad(String mixinPackage) {
    CustomInstrumentRegistry.registerInstruments(
            ModCustomInstruments.CAT,
            ModCustomInstruments.WOLF
    );
}
```
(If you're not using the `shouldApplyMixin` method in the plugin make sure it is set to return `true`!)

Create `InstrumentMaterial`s with the `CustomInstrument`s:
```java
public static final Material CAT = new InstrumentMaterial(new Material.Builder(MapColor.GRAY).build(), ModCustomInstruments.CAT);
public static final Material WOLF = new InstrumentMaterial(new Material.Builder(MapColor.GRAY).build(), ModCustomInstruments.WOLF);
```

Assign those `InstrumentMaterial`s to blocks:
```java
public static final Block CAT = new Block(AbstractBlock.Settings.of(ModMaterials.CAT).strength(1));
public static final Block WOLF = new Block(AbstractBlock.Settings.of(ModMaterials.WOLF).strength(1));
```
