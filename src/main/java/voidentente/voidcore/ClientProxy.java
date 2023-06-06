package voidentente.voidcore;

import voidentente.voidcore.extras.PlayerSpecificRendererHelper;
import voidentente.voidcore.extras.renders.RendererVoidentente;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerSidedHandlersGameLoaded() {
        PlayerSpecificRendererHelper.push(RendererVoidentente::new);

        //RenderManager.debugBoundingBox = true;
        //Minecraft.getMinecraft().thePlayer.boundingBox.maxX = 10;
        //Minecraft.getMinecraft().thePlayer.boundingBox.minX = 10;
    }

}
