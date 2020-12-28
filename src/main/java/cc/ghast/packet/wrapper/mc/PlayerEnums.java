package cc.ghast.packet.wrapper.mc;

import lombok.Getter;

/**
 * @author Ghast
 * @since 31/10/2020
 * ArtemisPacket © 2020
 */
public class PlayerEnums {
    public enum DigType {
        // Start digging a block
        START_DESTROY_BLOCK,
        // Cancel the process of digging a block
        ABORT_DESTROY_BLOCK,
        // Finish digging the block
        STOP_DESTROY_BLOCK,
        // Drop item as a stack
        DROP_ALL_ITEMS,
        // Drop item as a singular
        DROP_ITEM,
        // Shoot arrow / finish eating
        RELEASE_USE_ITEM,
        // Swap from main-hand to off-hand
        SWAP_HELD_ITEMS;
    }

    public enum UseType {
        INTERACT,
        ATTACK,
        INTERACT_AT;
    }

    public enum Hand {
        MAIN_HAND,
        OFF_HAND;
    }

    public enum ClientCommand {
        PERFORM_RESPAWN, REQUEST_STATS, OPEN_INVENTORY_ACHIEVEMENT;
    }

    public enum PlayerAction {
        START_SNEAKING,
        STOP_SNEAKING,
        LEAVE_BED,
        START_SPRINTING,
        STOP_SPRINTING,
        JUMP_HORSE,
        OPEN_RIDE_INVENTORY
    }

    public enum ResourcePackStatus {
        SUCCESSFULLY_LOADED,
        DECLINED,
        FAILED_DOWNLOAD,
        ACCEPTED;
    }

    @Getter
    public enum ChatVisibility {

        FULL(0, "options.chat.visibility.full"),
        SYSTEM(1, "options.chat.visibility.system"),
        HIDDEN(2, "options.chat.visibility.hidden");

        private final int settingId;
        private final String settingPath;

        ChatVisibility(int i, String s) {
            this.settingId = i;
            this.settingPath = s;
        }
    }
}