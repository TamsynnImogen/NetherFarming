package com.tamsynnimogen.netherfarming.tileentity;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.annotation.Nullable;

import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

public class ModWallSignBlock extends WallSignBlock implements IModSign {

   public ModWallSignBlock(Properties properties, WoodType woodType) {
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