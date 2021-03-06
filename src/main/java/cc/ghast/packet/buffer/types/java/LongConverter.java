package cc.ghast.packet.buffer.types.java;

import cc.ghast.packet.buffer.BufConverter;
import cc.ghast.packet.wrapper.netty.MutableByteBuf;
import io.netty.buffer.ByteBuf;

/**
 * @author Ghast
 * @since 01-May-20
 */
public class LongConverter extends BufConverter<Long> {

    public LongConverter() {
        super("Long", Long.class);
    }

    @Override
    public void write(MutableByteBuf buffer, Long value) {
        buffer.writeLong(value);
    }

    @Override
    public Long read(MutableByteBuf buffer, Object... args) {
        return buffer.readLong();
    }
}
