package cc.ghast.packet.chain;

import cc.ghast.packet.profile.Profile;
import cc.ghast.packet.wrapper.packet.Packet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

/**
 * @author Ghast
 * @since 15/08/2020
 * Artemis © 2020
 */
public class ChainManager {
    private final List<PacketListener> packetListeners = new ArrayList<>();

    public void callPacket(Profile profile, Packet<?> packet){
        this.packetListeners.forEach(listener -> {
            Runnable exec = () -> listener.onPacket(profile, packet);

            if (listener.isAsync()) {
                CompletableFuture.runAsync(exec);
                return;
            }

            exec.run();
        });
    }

    public void injectListener(PacketListener listener) {
        packetListeners.add(listener);
    }
}
