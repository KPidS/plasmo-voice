package su.plo.voice.client;

import lombok.Getter;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fmlclient.registry.ClientRegistry;
import org.lwjgl.glfw.GLFW;
import su.plo.voice.client.event.ClientInputEvent;
import su.plo.voice.client.event.ClientNetworkEvent;
import su.plo.voice.client.event.RenderEvent;
import su.plo.voice.client.event.VoiceChatCommandEvent;
import su.plo.voice.client.network.ClientNetworkHandlerForge;

public class VoiceClientForge extends VoiceClient {
    @Getter
    private static final ClientNetworkHandlerForge network = new ClientNetworkHandlerForge();

    public VoiceClientForge() {
        MinecraftForge.EVENT_BUS.register(new ClientInputEvent());
        MinecraftForge.EVENT_BUS.register(new ClientNetworkEvent());
        MinecraftForge.EVENT_BUS.register(new RenderEvent());
        MinecraftForge.EVENT_BUS.register(new VoiceChatCommandEvent());
    }

    @Override
    public void initialize() {
        super.initialize();

        menuKey = new KeyMapping("key.plasmo_voice.settings", GLFW.GLFW_KEY_V, "key.plasmo_voice");
        ClientRegistry.registerKeyBinding(menuKey);

        soundEngine.init();
    }
}
