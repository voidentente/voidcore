package voidentente.voidcore.extras;

import java.util.*;
import javax.annotation.Nullable;
import com.google.common.collect.Maps;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public final class PlayerHelper {

    public enum Player {
        VOIDENTENTE("bba9902b-3d7b-41f3-9867-8326a60457bb"),
        AEGIS("406f78b9-507b-4439-8434-c48b1087a293"),
        DAVEIATOR("243005dd-2169-4afb-9880-3509b5924103"),
        SEIKO("bcd49016-d6fd-4d4e-9f5c-e1c19c987160"),
        NANDEMOYA("35ebd06e-2779-4edc-84c1-48c84c67e8bc"),
        LUKE("049b07d3-c2b9-44ab-b20e-9b59fa4f6fc1");

        public final UUID uuid;

        public static final Random rng = new Random();

        private static final Map<UUID, Player> lookup = Maps.uniqueIndex(Arrays.asList(Player.values()), Player::getUUID);

        public static final HashMap<Player, String[]> aliases = new HashMap() {{
            put(VOIDENTENTE, new String[] {"leicht gebingondert", "kein deutschc abitus"});
            put(AEGIS, new String[] {"schlagfjanfall", "🅱"});
            put(DAVEIATOR, new String[] {"gkleiucvh", "I'm laz"});
            put(SEIKO, new String[] {"laquil", "bingus", "hugscheise", "bing bing bong", "gelbschuechtern", "Waveform Audio File Format"});
            put(NANDEMOYA, new String[] {});
            put(LUKE, new String[] {});
        }};

        /*
         *
         */

        Player(String uuid) {
            this.uuid = UUID.fromString(uuid);
        }

        public UUID getUUID() {
            return uuid;
        }

        @Nullable
        public static Player fromUUID(UUID uuid) {
            return lookup.get(uuid);
        }

        public String getRandomAlias() {
            return getRandomAlias(this);
        }

        public static String getRandomAlias(Player player) {
            String[] playerAliases = aliases.get(player);
            return playerAliases[rng.nextInt(playerAliases.length)];
        }

        public boolean isPlayer(EntityPlayer ep) {
            return ep.getUniqueID().equals(uuid);
        }

        @SideOnly(Side.CLIENT)
        public boolean isPlayer() {
            return isPlayer(Minecraft.getMinecraft().thePlayer);
        }

    }

}
