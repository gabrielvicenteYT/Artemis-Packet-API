package cc.ghast.packet.wrapper.packet.play.client;

import cc.ghast.packet.nms.ProtocolVersion;
import cc.ghast.packet.buffer.ProtocolByteBuf;
import cc.ghast.packet.wrapper.packet.ClientPacket;
import cc.ghast.packet.wrapper.packet.ReadableBuffer;
import cc.ghast.packet.wrapper.packet.Packet;
import lombok.Getter;

import java.util.UUID;

@Getter
public class PacketPlayClientResourcePackStatus extends Packet<ClientPacket> implements ReadableBuffer {
    public PacketPlayClientResourcePackStatus(UUID player, ProtocolVersion version) {
        super("PacketPlayInResourcePackStatus", player, version);
    }

    private String url;
    private ResourcePackStatus status;

    @Override
    public void read(ProtocolByteBuf byteBuf) {
        this.url = byteBuf.readStringBuf(40);
        this.status = ResourcePackStatus.values()[byteBuf.readVarInt()];
    }

    public enum ResourcePackStatus {

        SUCCESSFULLY_LOADED, DECLINED, FAILED_DOWNLOAD, ACCEPTED;

    }
}
