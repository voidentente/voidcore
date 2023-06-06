package voidentente.voidcore;

import java.io.File;
import java.net.URL;
import java.net.MalformedURLException;

import net.minecraft.event.ClickEvent;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;

import Reika.DragonAPI.Base.DragonAPIMod;
import Reika.DragonAPI.Instantiable.IO.ModLogger;
import Reika.DragonAPI.Exception.RegistrationException;
import Reika.DragonAPI.Instantiable.Event.Client.GameFinishedLoadingEvent;
import Reika.DragonAPI.Instantiable.Event.Client.ClientLoginEvent;

import voidentente.voidcore.blocks.BlockVoidCore;
import voidentente.voidcore.extras.PlayerHelper;
import voidentente.voidcore.tileentities.TileEntityVoidCore;

@Mod(modid = "VoidCore", version = "v@MAJOR_VERSION@@MINOR_VERSION@", dependencies = "@DEPENDENCIES@")
public class VoidCore extends DragonAPIMod {

    public VoidCore() {
        super();
    }

    public static ModLogger logger;

    @Instance("VoidCore")
    public static VoidCore instance = new VoidCore();

    @SidedProxy(clientSide = "voidentente.voidcore.ClientProxy", serverSide = "voidentente.voidcore.CommonProxy")
    public static CommonProxy proxy;

    /*
     *
     */

    @Override
    public String getDisplayName() {
        return "VoidCore";
    }

    @Override
    public String getModAuthorName() {
        return "Voidentente";
    }

    @Override
    public URL getDocumentationSite() {
        try {
            // The code shall be your documentation..
            return new URL("https://github.com/voidentente/voidcore");
        } catch(MalformedURLException e) {
            throw new RegistrationException(this, "Provided malformed documentation site URL");
        }
    }

    @Override
    public URL getBugSite() {
        try {
            return new URL("https://github.com/voidentente/voidcore/issues");
        } catch(MalformedURLException e) {
            throw new RegistrationException(this, "Provided malformed bug site URL");
        }
    }

    @Override
    public String getWiki() {
        return null;
    }

    @Override
    public File getConfigFolder() {
        return null;
    }

    @Override
    public ModLogger getModLogger() {
        return logger;
    }

    @Override
    public String getUpdateCheckURL() {
        return "https://raw.githubusercontent.com/voidentente/voidcore/main/src/main/resources/versions";
    }

    /*
     *
     */

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onGameLoadedEvent(GameFinishedLoadingEvent event) {
        proxy.registerSidedHandlersGameLoaded();
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onClientLoginEvent(ClientLoginEvent event) {
        //Minecraft.getMinecraft().thePlayer.boundingBox.setBounds(10, 10, 10, 10, 10, 10);
    }

    @SubscribeEvent
    //@SideOnly(Side.SERVER)
    public void onChatEvent(ServerChatEvent event) {
        /*
        PlayerHelper.Player player = PlayerHelper.Player.fromUUID(event.player.getUniqueID());

        if (player != null) {
            ChatComponentText chatcomponenttext = new ChatComponentText(ScorePlayerTeam.formatPlayerName(event.player.getTeam(), player.getRandomAlias()));
            chatcomponenttext.getChatStyle().setChatClickEvent(
                    new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/msg " + event.player.getCommandSenderName() + " "));
            event.component = new ChatComponentTranslation("chat.type.text", chatcomponenttext, event.message);
        }
         */
    }

    /*
     *
     */

    @Override
    @EventHandler
    /* Item and Block init and register, config */
    public void preload(FMLPreInitializationEvent event) {
        this.startTiming(LoadProfiler.LoadPhase.PRELOAD);

        logger = new ModLogger(instance, false);

        this.basicSetup(event);

        //GameRegistry.registerBlock(BlockVoidCore.instance, BlockVoidCore.instance.getUnlocalizedName());

        this.finishTiming();
    }

    @Override
    @EventHandler
    /* Entity, TileEntity, GUI, Packet Register */
    public void load(FMLInitializationEvent event) {
        this.startTiming(LoadProfiler.LoadPhase.LOAD);

        //GameRegistry.registerTileEntity(TileEntityVoidCore.class, "TileEntityVoidCore");

        this.finishTiming();
    }

    @Override
    @EventHandler
    /* Remainder */
    public void postload(FMLPostInitializationEvent event) {
        this.startTiming(LoadProfiler.LoadPhase.POSTLOAD);

        // ...

        this.finishTiming();
    }
}
