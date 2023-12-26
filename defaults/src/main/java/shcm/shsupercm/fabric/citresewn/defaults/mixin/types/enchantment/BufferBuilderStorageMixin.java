package shcm.shsupercm.fabric.citresewn.defaults.mixin.types.enchantment;

import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferBuilderStorage;
import net.minecraft.client.render.RenderLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import shcm.shsupercm.fabric.citresewn.defaults.cit.types.TypeEnchantment;

import java.util.SortedMap;

@Mixin(BufferBuilderStorage.class)
abstract class BufferBuilderStorageMixin implements TypeEnchantment.CITBufferBuilderStorage {
    @Unique
    private static SortedMap<RenderLayer, BufferBuilder> citresewn$entityBuilders;

    @ModifyVariable(method = "<init>", at = @At("STORE"))
    private SortedMap<RenderLayer, BufferBuilder> citresewn$setEntityBuilders(SortedMap<RenderLayer, BufferBuilder> original) {
        citresewn$entityBuilders = original;
        return original;
    }

    @Override
    public SortedMap<RenderLayer, BufferBuilder> citresewn$getEntityBuilders() {
        return citresewn$entityBuilders;
    }
}
