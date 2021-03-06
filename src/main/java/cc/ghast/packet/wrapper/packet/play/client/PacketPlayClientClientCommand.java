package cc.ghast.packet.wrapper.packet.play.client;

import cc.ghast.packet.nms.ProtocolVersion;
import cc.ghast.packet.buffer.ProtocolByteBuf;
import cc.ghast.packet.wrapper.packet.ClientPacket;
import cc.ghast.packet.wrapper.packet.ReadableBuffer;
import cc.ghast.packet.wrapper.packet.Packet;
import lombok.Getter;

import java.util.UUID;

@Getter
public class PacketPlayClientClientCommand extends Packet<ClientPacket> implements ReadableBuffer {
    public PacketPlayClientClientCommand(UUID player, ProtocolVersion version) {
        super("PacketPlayInClientCommand", player, version);
    }

    private ClientCommand command;

    @Override
    public void read(ProtocolByteBuf byteBuf) {
        this.command = ClientCommand.values()[byteBuf.readVarInt()];
    }

    public enum ClientCommand {
        PERFORM_RESPAWN, REQUEST_STATS, OPEN_INVENTORY_ACHIEVEMENT;
    }
}
