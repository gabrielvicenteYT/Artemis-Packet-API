package cc.ghast.packet.wrapper.packet.play.server;

import cc.ghast.packet.nms.ProtocolVersion;
import cc.ghast.packet.buffer.ProtocolByteBuf;
import cc.ghast.packet.wrapper.packet.Packet;
import cc.ghast.packet.wrapper.packet.ServerPacket;
import cc.ghast.packet.wrapper.packet.ReadableBuffer;
import lombok.Getter;

import java.util.UUID;

@Getter
public class PacketPlayServerAnimation extends Packet<ServerPacket> implements ReadableBuffer {
    public PacketPlayServerAnimation(UUID player, ProtocolVersion version) {
        super("PacketPlayOutAnimation", player, version);
    }

    private int entityId;
    private int animationId;

    @Override
    public void read(ProtocolByteBuf byteBuf) {
        this.entityId = byteBuf.readVarInt();
        this.animationId = byteBuf.readUnsignedByte();
    }
}
