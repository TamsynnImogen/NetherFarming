package com.tamsynnimogen.netherfarming.tileentity;

import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

public class ModStandingSignBlock extends StandingSignBlock implements IModSign {

   public ModStandingSignBlock(Properties properties, WoodType woodType) {
      super(properties, woodType);
   }

   @Override
   public boolean hasTileEntity(BlockState state) {
      return true;
   }

   @Override
   public TileEntity createTileEntity(BlockState state, IBlockReader world) {
      return ModTileEntities.SIGN.get().create();
   }
}