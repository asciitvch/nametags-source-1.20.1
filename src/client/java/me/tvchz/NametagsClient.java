package me.tvchz;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class NametagsClient implements ClientModInitializer {
    private static KeyBinding keyBinding;
    public static boolean NAMETAGS_ENABLED = true;
    @Override
    public void onInitializeClient() {
        keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "Toggle Nametags",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_R,
                "Nametags Mod"
        ));
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (keyBinding.wasPressed()) {
                NAMETAGS_ENABLED = !NAMETAGS_ENABLED;
                MinecraftClient.getInstance().player.sendMessage(Text.literal("Nametags toggled to " + NAMETAGS_ENABLED), false);
            }
        });
    }
}