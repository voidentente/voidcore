package voidentente.voidcore.tileentities;

import java.util.ArrayList;

import Reika.RotaryCraft.API.Interfaces.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityVoidCore extends TileEntity implements Transducerable, EMPControl,
        EnvironmentalHeatSource, Laserable, Shockable, Screwdriverable {

    public TileEntityVoidCore() {}

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
    }

    /*
     * Screwdriverable
     */

    @Override
    public boolean onShiftRightClick(World world, int x, int y, int z, ForgeDirection side) {
        return false;
    }

    @Override
    public boolean onRightClick(World world, int x, int y, int z, ForgeDirection side) {
        return false;
    }

    /*
     * Transducerable
     */

    @Override
    public ArrayList<String> getMessages(World world, int x, int y, int z, int side) {
        ArrayList<String> ret = new ArrayList();
        ret.add("Hi Mom!");
        return ret;
    }

    /*
     * EMPControl
     */

    @Override
    public void onHitWithEMP(TileEntity te) {}

    /*
     * EnvironmentalHeatSource (or TemperatureTile?)
     */

    @Override
    public SourceType getSourceType(IBlockAccess iba, int x, int y, int z) {
        return null;
    }

    @Override
    public boolean isActive(IBlockAccess iba, int x, int y, int z) {
        return false;
    }

    /*
     * Laserable
     */

    @Override
    public void whenInBeam(World world, int x, int y, int z, long power, int range) {}

    @Override
    public boolean blockBeam(World world, int x, int y, int z, long power) {
        return false;
    }

    /*
     * Shockable
     */

    @Override
    public void onDischarge(int charge, double range) {

    }

    @Override
    public int getMinDischarge() {
        return 0;
    }

    @Override
    public boolean canDischargeLongRange() {
        return false;
    }

    @Override
    public float getAimX() {
        return 0;
    }

    @Override
    public float getAimY() {
        return 0;
    }

    @Override
    public float getAimZ() {
        return 0;
    }
}
