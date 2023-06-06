package voidentente.voidcore.extras.renders;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraftforge.classloading.FMLForgePlugin;

import voidentente.voidcore.extras.PlayerHelper;
import voidentente.voidcore.extras.PlayerSpecificRenderer;
import voidentente.voidcore.extras.models.ModelVoidentente;

import java.util.function.Function;

@SideOnly(Side.CLIENT)
public final class RendererVoidentente extends PlayerSpecificRenderer {

    public RendererVoidentente(RenderPlayer original) {
        this(original, DefaultCondition());
    }

    public RendererVoidentente(RenderPlayer original, Function<Entity, Boolean> condition) {
        super(original);

        this.condition = condition;
        this.mainModel = new ModelVoidentente();
        // Using ModelBiped here to prevent armor models from spazzing out
        this.modelBipedMain = (ModelBiped) this.mainModel;
        this.modelArmorChestplate = new ModelBiped(1.0F);
        this.modelArmor = new ModelBiped(0.5F);
        this.renderManager = RenderManager.instance;
        this.shadowSize = 0.5F;
    }

    private static Function<Entity, Boolean> DefaultCondition() {
        // This might or might not make much sense. Still thinking about it.
        if (FMLForgePlugin.RUNTIME_DEOBF)
            return (entity -> entity.getUniqueID().equals(PlayerHelper.Player.VOIDENTENTE.uuid));
        else return (entity -> true);
    }

}
