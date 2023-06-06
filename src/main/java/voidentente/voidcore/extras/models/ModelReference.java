package voidentente.voidcore.extras.models;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import Reika.DragonAPI.DragonAPICore;
import Reika.DragonAPI.Extras.ModifiedPlayerModel;
import Reika.DragonAPI.Libraries.IO.ReikaTextureHelper;

/** These were mostly used for learning purposes...
 *  will probably remove them in the future.
 */
@SideOnly(Side.CLIENT)
public final class ModelReference {

    /** From Reika.DragonAPI.Extras.ReikaModel */
    public static final class Reika extends ModifiedPlayerModel {

        private final boolean tailMod = Loader.isModLoaded("Tails");

        public ModelRenderer hornL;
        public ModelRenderer hornR;
        public ModelRenderer wingL;
        public ModelRenderer wingR;
        public ModelRenderer tail;
        public ModelRenderer tail2;
        public ModelRenderer tail3;
        public ModelRenderer back;
        public ModelRenderer back2;
        public ModelRenderer back3;

        public float getHornY() {
            return -9F;
        }

        public float getHornX() {
            return -1F;
        }

        public float getWingAngle() {
            return 0.7853982F;
        }

        public float getHornZ() {
            return -3F;
        }

        public Reika() {
            super();
        }

        /*
        public void renderAll(Entity e, float par2, float par3, float par4, float par5, float par6, float par7) {
            super.render(e, par2, par3, par4, par5, par6, par7);
            this.renderBodyParts((EntityPlayer)e, 0);
        }
        */

        @Override
        public void render(Entity e, float par2, float par3, float par4, float par5, float par6, float par7) {
            super.render(e, par2, par3, par4, par5, par6, par7);
        }

        @Override
        public void bindTexture() {
            ReikaTextureHelper.bindFinalTexture(DragonAPICore.class, "/Reika/DragonAPI/Resources/voidentente_tex.png");
        }

        @Override
        public void renderBodyParts(EntityPlayer ep, float tick) {
            /*
            if (ep.equals(Minecraft.getMinecraft().thePlayer) && !ReikaPlayerAPI.isReika(Minecraft.getMinecraft().thePlayer))
                return;
            */
            this.setPartAngles(ep, tick);
            float f5 = 0.0625F;

            GL11.glPushMatrix();
            GL11.glTranslated(0, 0, -0.042);

            if (this.renderTail()) {
                tail.render(f5);
                tail3.render(f5);
                tail2.render(f5);
            }

            back.render(f5);
            back2.render(f5);
            back3.render(f5);

            /*
            if (ep.isSneaking()) {
                GL11.glRotated(this.getWingAngle()*180/3.14, 0, 1, 0);
                GL11.glRotated(-20, 0, 0, 1);
            }
            */
            wingR.render(f5);

            /*
            if (ep.isSneaking()) {
                GL11.glRotated(20, 0, 0, 1);
                GL11.glRotated(-2*this.getWingAngle()*180/3.14, 0, 1, 0);
                GL11.glRotated(20, 0, 0, 1);
            }
            */
            wingL.render(f5);

            /*
            if (ep.isSneaking()) {
                GL11.glRotated(-20, 0, 0, 1);
                GL11.glRotated(this.getWingAngle()*180/3.14, 0, 1, 0);
            }
            */

            GL11.glPopMatrix();
            GL11.glPushMatrix();

            double d = 0.25;
            if (ep.isSneaking())
                d = 0.3125;
            GL11.glTranslated(0, d, 0);
            hornL.render(f5);
            hornR.render(f5);

            GL11.glPopMatrix();
        }

        private boolean renderTail() {
            return !tailMod;
        }

        @Override
        protected void setPartAngles(EntityPlayer ep, float tick) {
            float pitch = -ep.rotationPitch;
            float yawHead = -ep.rotationYaw%360-tick*(ep.rotationYaw-ep.prevRotationYaw);
            float yaw = -ep.renderYawOffset%360-tick*(ep.renderYawOffset-ep.prevRenderYawOffset)+180;

            pc = pitch*RADIAN;
            yc = yaw*RADIAN;
            yhc = yawHead*RADIAN;

            this.compensateAngles(tick);

            hornL.rotateAngleX = pc;
            //hornR.rotateAngleY = yawBody / (180F / (float)Math.PI);
            hornR.rotateAngleX = pc;


            hornR.rotateAngleY = yhc-yc;
            hornL.rotateAngleY = yhc-yc;
            /*
            tail.rotateAngleY = yc;
            tail3.rotateAngleY = yc;
            tail2.rotateAngleY = yc;
            back.rotateAngleY = yc;
            back2.rotateAngleY = yc;
            back3.rotateAngleY = yc;
            wingL.rotateAngleY = this.getWingAngle()+yc;
            wingR.rotateAngleY = -this.getWingAngle()+yc;
             */
            //this.init();
        }

        @Override
        protected void init() {
            hornR = new ModelRenderer(this, 32, 12);
            hornR.addBox(this.getHornX()-2F, this.getHornY(), this.getHornZ(), 2, 1, 3);
            hornR.setTextureSize(64, 32);
            hornR.mirror = true;

            hornL = new ModelRenderer(this, 32, 12);
            hornL.addBox(this.getHornX()+2F, this.getHornY(), this.getHornZ(), 2, 1, 3);
            hornL.setTextureSize(64, 32);
            hornL.mirror = true;


            tail = new ModelRenderer(this, 32, 0);
            tail.addBox(-1.5F, 10F, 2F, 3, 5, 3);
            tail.setTextureSize(64, 32);
            tail.mirror = true;

            tail2 = new ModelRenderer(this, 32, 0);
            tail2.addBox(-1.5F, 15.8F, -3.4F, 3, 5, 3);
            tail2.setTextureSize(64, 32);
            tail2.mirror = true;

            tail3 = new ModelRenderer(this, 32, 0);
            tail3.addBox(-1.5F, 16.6F, -15.5F, 3, 5, 3);
            tail3.setTextureSize(64, 32);
            tail3.mirror = true;


            back = new ModelRenderer(this, 32, 8);
            back.addBox(-0.5F, 7F, 2F, 1, 2, 1);
            back.setTextureSize(64, 32);
            back.mirror = true;

            back2 = new ModelRenderer(this, 32, 8);
            back2.addBox(-0.5F, 1F, 2F, 1, 2, 1);
            back2.setTextureSize(64, 32);
            back2.mirror = true;

            back3 = new ModelRenderer(this, 32, 8);
            back3.addBox(-0.5F, 4F, 2F, 1, 2, 1);
            back3.setTextureSize(64, 32);
            back3.mirror = true;


            wingL = new ModelRenderer(this, 44, 0);
            wingL.addBox(0F, 1F, 3F, 1, 12, 7);
            wingL.setTextureSize(64, 32);
            wingL.mirror = true;

            wingR = new ModelRenderer(this, 44, 0);
            wingR.addBox(-1F, 1F, 3F, 1, 12, 7);
            wingR.setTextureSize(64, 32);
            wingR.mirror = true;

            this.setPositions();
        }

        @Override
        public void setPositions() {
            hornR.setRotationPoint(0, 0, 0);
            this.setRotation(hornR, 0F, 0F, 0F);

            hornL.setRotationPoint(0, 0, 0);
            this.setRotation(hornL, 0F, 0F, 0F);


            tail.setRotationPoint(0F, 0F, 0F);
            this.setRotation(tail, 0.0698132F, 0F, 0F);

            tail2.setRotationPoint(0F, 0F, 0F);
            this.setRotation(tail2, 0.418879F, 0F, 0F);

            tail3.setRotationPoint(0F, 0F, 0F);
            this.setRotation(tail3, 1.047198F, 0F, 0F);


            back.setRotationPoint(0F, 0F, 0F);
            this.setRotation(back, 0F, 0F, 0F);

            back2.setRotationPoint(0F, 0F, 0F);
            this.setRotation(back2, 0F, 0F, 0F);

            back3.setRotationPoint(0F, 0F, 0F);
            this.setRotation(back3, 0F, 0F, 0F);


            wingL.setRotationPoint(0F, 0F, 0F);
            this.setRotation(wingL, 0F, this.getWingAngle(), 0F);

            wingR.setRotationPoint(0F, 0F, 0F);
            this.setRotation(wingR, 0F, -this.getWingAngle(), 0F);
        }

    }

    /** From Reika.DragonAPI.Extras.SamakiModel */
    public static final class Samaki extends ModifiedPlayerModel {

        ModelRenderer earR;
        ModelRenderer earL;
        ModelRenderer tail;

        public Samaki() {
            super();
        }

        @Override
        protected void setPositions() {
            earL.setRotationPoint(0F, 0F, 0F);
            earR.setRotationPoint(0F, 0F, 0F);
            tail.setRotationPoint(0F, 0F, 0F);

            this.setRotation(earL, 0F, 0F, 0.7853982F);
            this.setRotation(earR, 0F, 0F, 0.7853982F);
            this.setRotation(tail, 0.1745329F, 0F, 0F);
        }

        @Override
        protected void init() {
            earL = new ModelRenderer(this, 48, 0);
            earL.addBox(-5.7F, -8.3F, -2F, 3, 3, 1);
            earL.setTextureSize(64, 32);
            earL.mirror = true;

            earR = new ModelRenderer(this, 48, 0);
            earR.addBox(-8.3F, -5.7F, -2F, 3, 3, 1);
            earR.setTextureSize(64, 32);
            earR.mirror = true;

            tail = new ModelRenderer(this, 32, 0);
            tail.addBox(-1.5F, 10F, 0F, 3, 11, 3);
            tail.setTextureSize(64, 32);
            tail.mirror = true;

            this.setPositions();
        }

        @Override
        protected void setPartAngles(EntityPlayer ep, float tick) {
            float pitch = -ep.rotationPitch;
            float yawHead = -ep.rotationYaw%360-tick*(ep.rotationYaw-ep.prevRotationYaw);
            float yaw = -ep.renderYawOffset%360-tick*(ep.renderYawOffset-ep.prevRenderYawOffset)+180;

            pc = pitch*RADIAN;
            yc = yaw*RADIAN;

            //this.compensateAngles(tick);
            yhc = yawHead*RADIAN;

            Tessellator.instance.startDrawing(GL11.GL_LINE_LOOP);
            Tessellator.instance.addVertex(0, 0, 0);
            Tessellator.instance.addVertex(0, 2, 0);
            Tessellator.instance.draw();
            //earL.rotateAngleX = 0;
            //earR.rotateAngleX = 0;
            //earL.rotateAngleY = 0;//yhc-yc;
            //earR.rotateAngleY = 0;//yhc-yc;
            //earL.rotateAngleZ = 0;//45*RADIAN;
            //earR.rotateAngleZ = 0;//45*RADIAN;

            //earR.rotateAngleY = yhc-yc;
            //earL.rotateAngleY = yhc-yc;

            //tail.rotateAngleY = yc;
        }

        @Override
        public void bindTexture() {
            ReikaTextureHelper.bindFinalTexture(DragonAPICore.class, "/Reika/DragonAPI/Resources/samaki_tex.png");
        }

        @Override
        public void renderBodyParts(EntityPlayer ep, float tick) {
            //this.setPartAngles(ep, tick);

            float pitch = ep.rotationPitch;
            float yawHead = -ep.rotationYaw%360-tick*(ep.rotationYaw-ep.prevRotationYaw);

            if (tick == 1.0F) {
                yawHead = yhc-6;
            }
            yc = ep.rotationYaw;
            yhc = ep.rotationYawHead;
            pc = ep.rotationPitch;
            float rc = ep.renderYawOffset-yc;

            float f5 = 0.0625F;

            double d = 0.1825;

            tail.render(f5);

            if (ep.isSneaking()) {
                d = 0.25;

                GL11.glTranslated(0.02, -0.1, 0.05);
                GL11.glRotated(-22.5, 1, 0, 0);
            }
            GL11.glTranslated(0, d, 0);
            GL11.glRotated(rc, 0, 1, 0);
            GL11.glRotated(pc, 1, 0, 0);
            earL.render(f5);
            earR.render(f5);
            GL11.glRotated(-pc, 1, 0, 0);
            GL11.glRotated(-rc, 0, 1, 0);
            GL11.glTranslated(0, -d, 0);
        }

    }

}
