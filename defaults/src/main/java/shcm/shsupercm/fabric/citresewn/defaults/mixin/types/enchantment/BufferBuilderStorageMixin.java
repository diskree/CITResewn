package shcm.shsupercm.fabric.citresewn.defaults.mixin.types.enchantment;

import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferBuilderStorage;
import net.minecraft.client.render.RenderLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import shcm.shsupercm.fabric.citresewn.defaults.cit.types.TypeEnchantment;

import java.util.Map;
import java.util.SortedMap;

@Mixin(BufferBuilderStorage.class)
abstract class BufferBuilderStorageMixin implements TypeEnchantment.CITBufferBuilderStorage {
    @Unique
    private Map<RenderLayer, BufferBuilder> citresewn$entityBuilders;

    @ModifyArg(
            method = "<init>",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/VertexConsumerProvider;immediate(Ljava/util/Map;Lnet/minecraft/client/render/BufferBuilder;)Lnet/minecraft/client/render/VertexConsumerProvider$Immediate;"))
    private Map<RenderLayer, BufferBuilder> citresewn$setEntityBuilders(Map<RenderLayer, BufferBuilder> original) {
        citresewn$entityBuilders = original;
        return original;
    }

    @Override
    public Map<RenderLayer, BufferBuilder> citresewn$getEntityBuilders() {
        return citresewn$entityBuilders;
    }
}
