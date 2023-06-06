package voidentente.voidcore.auxiliary;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class TabVoidCore {
    public static final CreativeTabs instance = new CreativeTabs("TabVoidCore") {
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return Items.ender_eye;
        }
    };
}
