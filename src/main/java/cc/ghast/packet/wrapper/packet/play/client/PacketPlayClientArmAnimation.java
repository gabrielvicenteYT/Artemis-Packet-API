package cc.ghast.packet.wrapper.packet.play.client;

import cc.ghast.packet.nms.ProtocolVersion;
import cc.ghast.packet.buffer.ProtocolByteBuf;
import cc.ghast.packet.wrapper.packet.ClientPacket;
import cc.ghast.packet.wrapper.packet.ReadableBuffer;
import cc.ghast.packet.wrapper.packet.Packet;

import java.util.UUID;

public class PacketPlayClientArmAnimation extends Packet<ClientPacket> implements ReadableBuffer {
    public PacketPlayClientArmAnimation(UUID player, ProtocolVersion version) {
        super("PacketPlayInArmAnimation", player, version);
    }

    @Override
    public void read(ProtocolByteBuf byteBuf) {
        // Lolz this is empty
    }
}
