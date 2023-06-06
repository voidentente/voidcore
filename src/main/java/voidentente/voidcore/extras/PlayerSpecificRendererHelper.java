package voidentente.voidcore.extras;

import java.util.function.Function;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.player.EntityPlayer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class PlayerSpecificRendererHelper {

    public static RenderPlayer getCurrent() {
        return (RenderPlayer) RenderManager.instance.entityRenderMap.get(EntityPlayer.class);
    }

    public static void setCurrent(RenderPlayer render) {
        RenderManager.instance.entityRenderMap.put(EntityPlayer.class, render);
    }

    public static void push(Function<RenderPlayer, RenderPlayer> f) {
        setCurrent(f.apply(getCurrent()));
    }

}
