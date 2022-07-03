# Note Block Library
A library for adding custom note block instruments.

## Gradle setup
Add the JitPack repository:
```groovy
repositories {
    maven {
        name = "JitPack"
        url = "https://jitpack.io"
    }
}
```

Fabric:
```groovy
dependencies {
    modCompileOnly("com.github.ShaksterNano.Note-Block-Library:note-block-lib:VERSION")
    modRuntimeOnly("com.github.ShaksterNano.Note-Block-Library:note-block-lib-fabric:VERSION")
}
```

Forge (ForgeGradle):
```groovy
dependencies {
    compileOnly(fg.deobf("com.github.ShaksterNano.Note-Block-Library:note-block-lib:VERSION"))
    runtimeOnly(fg.deobf("com.github.ShaksterNano.Note-Block-Library:note-block-lib-forge:VERSION"))
}
```

Forge (Architectury Loom):
```groovy
dependencies {
    modCompileOnly("com.github.ShaksterNano.Note-Block-Library:note-block-lib:VERSION")
    modRuntimeOnly("com.github.ShaksterNano.Note-Block-Library:note-block-lib-forge:VERSION")
}
```

Architectury:
```groovy
// Common
dependencies {
    modCompileOnly("com.github.ShaksterNano.Note-Block-Library:note-block-lib:VERSION")
}

// Fabric
dependencies {
    modRuntimeOnly("com.github.ShaksterNano.Note-Block-Library:note-block-lib-fabric:VERSION")
}

// Forge
dependencies {
    modRuntimeOnly("com.github.ShaksterNano.Note-Block-Library:note-block-lib-forge:VERSION")
}
```

## Usage
Create `CustomInstrument`s:
```java
public static final CustomInstrument CAT_INSTRUMENT = new CustomInstrument("examplemodid", "cat", () -> SoundEvents.ENTITY_CAT_AMBIENT);
public static final CustomInstrument WOLF_INSTRUMENT = new CustomInstrument("examplemodid", "wolf", () -> SoundEvents.ENTITY_WOLF_AMBIENT);
```

Register them in the `onLoad` method in an [IMixinConfigPlugin](https://github.com/SpongePowered/Mixin/blob/master/src/main/java/org/spongepowered/asm/mixin/extensibility/IMixinConfigPlugin.java "IMixinConfigPlugin"):
```java
@Override
public void onLoad(String mixinPackage) {
    CustomInstrumentRegistry.registerInstruments(
            ModCustomInstruments.CAT_INSTRUMENT,
            ModCustomInstruments.WOLF_INSTRUMENT
    );
}
```
(If you're not using the `shouldApplyMixin` method in the plugin make sure it is set to return `true`)

Create `InstrumentMaterial`s with the `CustomInstrument`s:
```java
public static final Material CAT_MATERIAL = new InstrumentMaterial(new Material.Builder(MapColor.GRAY).build(), ModCustomInstruments.CAT_INSTRUMENT);
public static final Material WOLF_MATERIAL = new InstrumentMaterial(new Material.Builder(MapColor.GRAY).build(), ModCustomInstruments.WOLF_INSTRUMENT);
```

Assign those `InstrumentMaterial`s to blocks:
```java
public static final Block CAT_BLOCK = new Block(AbstractBlock.Settings.of(ModMaterials.CAT_MATERIAL).strength(1));
public static final Block WOLF_BLOCK = new Block(AbstractBlock.Settings.of(ModMaterials.WOLF_MATERIAL).strength(1));
```
