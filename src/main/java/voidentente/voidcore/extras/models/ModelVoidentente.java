package voidentente.voidcore.extras.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public final class ModelVoidentente extends ModelBiped {

    public ModelRenderer bipedRightArmAuxiliary;
    public ModelRenderer bipedLeftArmAuxiliary;

    public ModelVoidentente() {
        this(0.0F);
    }

    public ModelVoidentente(float par1) {
        this(par1, 0.0F, 64, 32);
    }

    public ModelVoidentente(float par1, float par2, int textureWidth, int textureHeight) {
        super(par1, par2, textureWidth, textureHeight);

        bipedRightArm = new ModelRenderer(this, 40, 16);
        bipedRightArm.addBox(-2.0F, -2.0F, -1.5F, 3, 12, 3, par1);
        bipedRightArm.rotationPointY = 2.0F + par2;

        bipedLeftArm = new ModelRenderer(this, 40, 16);
        bipedLeftArm.mirror = true;
        bipedLeftArm.addBox(-1.0F, -2.0F, -1.5F, 3, 12, 3, par1);
        bipedLeftArm.rotationPointY = 2.0F + par2;

        bipedRightArmAuxiliary = new ModelRenderer(this, 40, 16);
        bipedRightArmAuxiliary.addBox(0.0F, -2.0F, -1.0F, 2, 10, 2, par1);
        bipedRightArmAuxiliary.rotationPointY = 6.0F + par2;

        bipedLeftArmAuxiliary = new ModelRenderer(this, 40, 16);
        bipedLeftArmAuxiliary.mirror = true;
        bipedLeftArmAuxiliary.addBox(-2.0F, -2.0F, -1.0F, 2, 10, 2, par1);
        bipedLeftArmAuxiliary.rotationPointY = 6.0F + par2;
    }

    @Override
    public void render(Entity e, float par2, float par3, float par4, float par5, float par6, float par7) {
        super.render(e, par2, par3, par4, par5, par6, par7);

        this.bipedRightArmAuxiliary.render(par7);
        this.bipedLeftArmAuxiliary.render(par7);
    }

    @Override
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity e) {
        super.setRotationAngles(par1, par2, par3, par4, par5, par6, e);

        // Having the auxiliary arms move inversely to the main arms kind of obscures the visual shape too much..
        //this.bipedLeftArmAuxiliary.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 2.0F * par2 * 0.5F;
        //this.bipedRightArmAuxiliary.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
        // However, the maximum swing is still smaller, so it doesn't clip (since it's partially inside the main body)
        this.bipedRightArmAuxiliary.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 2.0F * (par2 * 0.6F) * 0.5F;
        this.bipedLeftArmAuxiliary.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 2.0F * (par2 * 0.6F) * 0.5F;

        this.bipedRightArmAuxiliary.rotateAngleZ = 0;
        this.bipedLeftArmAuxiliary.rotateAngleZ = 0;
        this.bipedRightArmAuxiliary.rotateAngleY = 0;
        this.bipedLeftArmAuxiliary.rotateAngleY = 0;
        this.bipedRightArmAuxiliary.offsetZ = 0;
        this.bipedLeftArmAuxiliary.offsetZ = 0;
        this.bipedRightArm.offsetZ = 0;
        this.bipedLeftArm.offsetZ = 0;

        if (this.isRiding) {
            this.bipedRightArmAuxiliary.rotateAngleX -= ((float) Math.PI / 5F);
            this.bipedLeftArmAuxiliary.rotateAngleX -= ((float) Math.PI / 5F);
        }

        if (this.onGround > -9990.0F) {
            this.bipedRightArmAuxiliary.rotationPointZ = MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0F;
            this.bipedRightArmAuxiliary.rotationPointX = -MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0F;
            this.bipedLeftArmAuxiliary.rotationPointZ = -MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0F;
            this.bipedLeftArmAuxiliary.rotationPointX = MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0F;
            this.bipedRightArmAuxiliary.rotateAngleY += this.bipedBody.rotateAngleY;
            this.bipedLeftArmAuxiliary.rotateAngleY += this.bipedBody.rotateAngleY;
            this.bipedLeftArmAuxiliary.rotateAngleX += this.bipedBody.rotateAngleY;
        }

        if (this.isSneak) {
            this.bipedRightArmAuxiliary.rotateAngleX += 0.4F;
            this.bipedLeftArmAuxiliary.rotateAngleX += 0.4F;

            this.bipedRightArm.offsetZ += 0.05F;
            this.bipedRightArmAuxiliary.offsetZ += 0.2F;

            this.bipedLeftArm.offsetZ += 0.05F;
            this.bipedLeftArmAuxiliary.offsetZ += 0.2F;
        }

        this.bipedRightArmAuxiliary.rotateAngleZ += MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
        this.bipedLeftArmAuxiliary.rotateAngleZ -= MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
        this.bipedRightArmAuxiliary.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.05F;
        this.bipedLeftArmAuxiliary.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.05F;

        this.bipedRightArm.rotateAngleZ += 0.2F;
        this.bipedLeftArm.rotateAngleZ -= 0.2F;
        this.bipedRightArmAuxiliary.rotateAngleZ += 0.1F;
        this.bipedLeftArmAuxiliary.rotateAngleZ -= 0.1F;
    }
}