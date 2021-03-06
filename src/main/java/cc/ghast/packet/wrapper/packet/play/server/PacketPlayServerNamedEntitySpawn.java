package cc.ghast.packet.wrapper.packet.play.server;

import cc.ghast.packet.nms.ProtocolVersion;
import cc.ghast.packet.buffer.ProtocolByteBuf;
import cc.ghast.packet.wrapper.packet.Packet;
import cc.ghast.packet.wrapper.packet.ServerPacket;
import cc.ghast.packet.wrapper.packet.ReadableBuffer;
import lombok.Getter;

import java.util.UUID;

@Getter
public class PacketPlayServerNamedEntitySpawn extends Packet<ServerPacket> implements ReadableBuffer {
    public PacketPlayServerNamedEntitySpawn(UUID player, ProtocolVersion version) {
        super("PacketPlayOutNamedEntitySpawn", player, version);
    }


    private int entityId;
    private UUID objectUUID;
    private int type;
    private double x;
    private double y;
    private double z;
    private float pitch;
    private float yaw;
    private int data;

    @Override
    public void read(ProtocolByteBuf byteBuf) {
        this.entityId = byteBuf.readVarInt();
        this.objectUUID = byteBuf.readUUID();
        this.x = byteBuf.readInt() / 32.0D;
        this.y = byteBuf.readInt() / 32.0D;
        this.z = byteBuf.readInt() / 32.0D;
        this.pitch = byteBuf.readByte() / 256.0F * 360.0F;
        this.yaw = byteBuf.readByte() / 256.0F * 360.0F;
        this.type = byteBuf.readShort();
    }
}
