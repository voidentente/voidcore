package voidentente.voidcore.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import voidentente.voidcore.auxiliary.TabVoidCore;
import voidentente.voidcore.tileentities.TileEntityVoidCore;

public class BlockVoidCore extends Block implements ITileEntityProvider {

    public static BlockVoidCore instance = new BlockVoidCore();

    public BlockVoidCore() {
        super(Material.portal);
        this.setBlockName("voidcore");
        this.setBlockTextureName("voidcore:voidcore");
        this.setHardness(-1);
        this.setCreativeTab(TabVoidCore.instance);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileEntityVoidCore();
    }
}
