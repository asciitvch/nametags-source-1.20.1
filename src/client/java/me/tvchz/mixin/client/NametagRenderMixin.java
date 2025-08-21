package me.tvchz.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import me.tvchz.NametagsClient;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntityRenderer.class)
public abstract class NametagRenderMixin {
    @ModifyReturnValue(method = "hasLabel(Lnet/minecraft/entity/LivingEntity;)Z", at = @At("HEAD"))
    private boolean shouldRenderNametag(boolean original) {
        return NametagsClient.NAMETAGS_ENABLED && original;
    }
}