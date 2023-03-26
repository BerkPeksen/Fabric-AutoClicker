package net.teost.autoclickera;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.input.KeyboardInput;
import net.teost.autoclickera.event.KeyImputs;

public class ClickerClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyImputs.register();


    }
}
