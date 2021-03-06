package cc.ghast.packet.wrapper.packet.play.client;

import cc.ghast.packet.nms.ProtocolVersion;
import cc.ghast.packet.buffer.ProtocolByteBuf;
import cc.ghast.packet.wrapper.packet.ClientPacket;
import cc.ghast.packet.wrapper.packet.ReadableBuffer;
import cc.ghast.packet.wrapper.packet.Packet;
import lombok.Getter;

import java.util.UUID;

@Getter
public class PacketPlayClientSteerVehicle extends Packet<ClientPacket> implements ReadableBuffer {
    public PacketPlayClientSteerVehicle(UUID player, ProtocolVersion version) {
        super("PacketPlayInSteerVehicle", player, version);
    }

    private float moveForward;
    private float moveStrafing;
    private boolean jumping;
    private boolean sneaking;

    @Override
    public void read(ProtocolByteBuf byteBuf) {
        this.moveForward = byteBuf.readFloat();
        this.moveStrafing = byteBuf.readFloat();
        byte b0 = byteBuf.readByte();

        this.jumping = (b0 & 1) > 0;
        this.sneaking = (b0 & 2) > 0;
    }
}
