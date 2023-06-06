package voidentente.voidcore.extras;

import java.util.function.Function;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderPlayer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/** This allows the addition of a specific render hook while otherwise calling the specified fallback renderer,
 *  so that (for example) the DragonAPI CustomPlayerRenderer *shouldn't* break.
 *  This is hacky and bound to break somehow!
 */
@SideOnly(Side.CLIENT)
public class PlayerSpecificRenderer extends RenderPlayer {

    public RenderPlayer fallback;

    public Function<Entity, Boolean> condition;

    public PlayerSpecificRenderer(RenderPlayer fallback) {
        this.fallback = fallback;
    }

    @Override
    public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        if (condition.apply(p_76986_1_))
            super.doRender(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
        else fallback.doRender(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    @Override
    public void doRender(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        if (condition.apply(p_76986_1_))
            super.doRender(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
        else fallback.doRender(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    @Override
    public void doRender(AbstractClientPlayer p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        if (condition.apply(p_76986_1_))
            super.doRender(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
        else fallback.doRender(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    @Override
    public void renderFirstPersonArm(EntityPlayer p_82441_1_) {
        if (condition.apply(p_82441_1_))
            super.renderFirstPersonArm(p_82441_1_);
        else fallback.renderFirstPersonArm(p_82441_1_);
    }

}
