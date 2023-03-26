package net.teost.autoclickera.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.util.WindowProvider;
import net.minecraft.text.KeybindTextContent;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

import java.awt.event.KeyEvent;
import java.util.StringTokenizer;

public class KeyImputs {
    public static final String Key_Category = "key_category";
    public static final String Key_Start ="key_Start";


    public static KeyBinding Start;

    static int Flag = 0;
    static int TickCount = 1;

    public static void register(){
        Start = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                Key_Start,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_F6,
                Key_Category
        ));

        registerKey();
    }

    public static void registerKey() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {

            if(Flag %2 == 1 && TickCount > 20){
                KeyBinding.onKeyPressed(client.options.attackKey.getDefaultKey());
                TickCount =0;
            }

            if(Start.wasPressed()){
                Flag = Flag + 1 - 2*(Flag-1);
                TickCount = 0;
            }
            TickCount = TickCount+1;
        });
    }
}
