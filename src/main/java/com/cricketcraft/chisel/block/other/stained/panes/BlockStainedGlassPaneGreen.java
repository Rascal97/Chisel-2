package com.cricketcraft.chisel.block.other.stained.panes;

import com.cricketcraft.chisel.init.ChiselProperties;
import com.cricketcraft.chisel.util.BlockVariant;
import com.cricketcraft.chisel.util.IBlockWithSubtypes;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class BlockStainedGlassPaneGreen extends BlockPane implements IBlockWithSubtypes {
    public BlockStainedGlassPaneGreen() {
        super(Material.glass, true);
        setDefaultState(this.getBlockState().getBaseState().withProperty(ChiselProperties.STAINED_GLASS_PANE_GREEN_VARIANTS, ChiselProperties.STAINED_GLASS_PANE_GREEN_VARIANTS.fromMeta(0)));
    }

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
        for (BlockVariant variant : ChiselProperties.STAINED_GLASS_PANE_GREEN_VARIANTS.getAllowedValues()) {
            list.add(new ItemStack(itemIn, 1, variant.getMeta()));
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(ChiselProperties.STAINED_GLASS_PANE_GREEN_VARIANTS, ChiselProperties.STAINED_GLASS_PANE_GREEN_VARIANTS.fromMeta(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return ((BlockVariant) state.getValue(ChiselProperties.STAINED_GLASS_PANE_GREEN_VARIANTS)).getMeta();
    }

    @Override
    public String getSubtypeUnlocalizedName(ItemStack stack) {
        return ChiselProperties.STAINED_GLASS_PANE_GREEN_VARIANTS.fromMeta(stack.getMetadata()).getName();
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, ChiselProperties.STAINED_GLASS_PANE_GREEN_VARIANTS);
    }
}
