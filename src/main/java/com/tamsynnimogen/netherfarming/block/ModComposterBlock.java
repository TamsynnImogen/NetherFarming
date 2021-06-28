package com.tamsynnimogen.netherfarming.block;

import com.tamsynnimogen.netherfarming.item.ModItems;
import it.unimi.dsi.fastutil.objects.Object2FloatMap;
import it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ComposterBlock;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Random;

public class ModComposterBlock extends ComposterBlock {
    public static final IntegerProperty LEVEL = BlockStateProperties.LEVEL_0_8;
    public static final Object2FloatMap<IItemProvider> CHANCES = new Object2FloatOpenHashMap<>();
    private static final VoxelShape OUT_SHAPE = VoxelShapes.fullCube();
    private static final VoxelShape[] SHAPE = Util.make(new VoxelShape[9], (shapes) -> {
        for(int i = 0; i < 8; ++i) {
            shapes[i] = VoxelShapes.combineAndSimplify(OUT_SHAPE, Block.makeCuboidShape(2.0D, (double)Math.max(2, 1 + i * 2), 2.0D, 14.0D, 16.0D, 14.0D), IBooleanFunction.ONLY_FIRST);
        }

        shapes[8] = shapes[7];
    });


    public static void init() {
        CHANCES.defaultReturnValue(-1.0F);
        float f = 0.3F;
        float f1 = 0.5F;
        float f2 = 0.65F;
        float f3 = 0.85F;
        float f4 = 1.0F;
        registerCompostable(0.3F, ModItems.CINDER_WHEAT.get());
    }

    private static void registerCompostable(float chance, IItemProvider itemIn) {
        CHANCES.put(itemIn.asItem(), chance);
    }

    public ModComposterBlock(Properties properties) {
        super(properties);
    }

    @OnlyIn(Dist.CLIENT)
    public static void playEvent(World world, BlockPos pos, boolean success) {
        BlockState blockstate = world.getBlockState(pos);
        world.playSound((double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), success ? SoundEvents.BLOCK_COMPOSTER_FILL_SUCCESS : SoundEvents.BLOCK_COMPOSTER_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
        double d0 = blockstate.getShape(world, pos).max(Direction.Axis.Y, 0.5D, 0.5D) + 0.03125D;
        double d1 = (double)0.13125F;
        double d2 = (double)0.7375F;
        Random random = world.getRandom();

        for(int i = 0; i < 10; ++i) {
            double d3 = random.nextGaussian() * 0.02D;
            double d4 = random.nextGaussian() * 0.02D;
            double d5 = random.nextGaussian() * 0.02D;
            world.addParticle(ParticleTypes.COMPOSTER, (double)pos.getX() + (double)0.13125F + (double)0.7375F * (double)random.nextFloat(), (double)pos.getY() + d0 + (double)random.nextFloat() * (1.0D - d0), (double)pos.getZ() + (double)0.13125F + (double)0.7375F * (double)random.nextFloat(), d3, d4, d5);
        }

    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE[state.get(LEVEL)];
    }

    public VoxelShape getRaytraceShape(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return OUT_SHAPE;
    }

    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE[0];
    }

    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (state.get(LEVEL) == 7) {
            worldIn.getPendingBlockTicks().scheduleTick(pos, state.getBlock(), 20);
        }

    }

    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        int i = state.get(LEVEL);
        ItemStack itemstack = player.getHeldItem(handIn);
        if (i < 8 && CHANCES.containsKey(itemstack.getItem())) {
            if (i < 7 && !worldIn.isRemote) {
                BlockState blockstate = attemptCompost(state, worldIn, pos, itemstack);
                worldIn.playEvent(1500, pos, state != blockstate ? 1 : 0);
                if (!player.abilities.isCreativeMode) {
                    itemstack.shrink(1);
                }
            }

            return ActionResultType.func_233537_a_(worldIn.isRemote);
        } else if (i == 8) {
            empty(state, worldIn, pos);
            return ActionResultType.func_233537_a_(worldIn.isRemote);
        } else {
            return ActionResultType.PASS;
        }
    }

    public static BlockState attemptFill(BlockState state, ServerWorld world, ItemStack stack, BlockPos pos) {
        int i = state.get(LEVEL);
        if (i < 7 && CHANCES.containsKey(stack.getItem())) {
            BlockState blockstate = attemptCompost(state, world, pos, stack);
            stack.shrink(1);
            return blockstate;
        } else {
            return state;
        }
    }

    public static BlockState empty(BlockState state, World world, BlockPos pos) {
        if (!world.isRemote) {
            float f = 0.7F;
            double d0 = (double)(world.rand.nextFloat() * 0.7F) + (double)0.15F;
            double d1 = (double)(world.rand.nextFloat() * 0.7F) + (double)0.060000002F + 0.6D;
            double d2 = (double)(world.rand.nextFloat() * 0.7F) + (double)0.15F;
            ItemEntity itementity = new ItemEntity(world, (double)pos.getX() + d0, (double)pos.getY() + d1, (double)pos.getZ() + d2, new ItemStack(Items.BONE_MEAL));
            itementity.setDefaultPickupDelay();
            world.addEntity(itementity);
        }

        BlockState blockstate = resetFillState(state, world, pos);
        world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_COMPOSTER_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
        return blockstate;
    }

    private static BlockState resetFillState(BlockState state, IWorld world, BlockPos pos) {
        BlockState blockstate = state.with(LEVEL, Integer.valueOf(0));
        world.setBlockState(pos, blockstate, 3);
        return blockstate;
    }

    private static BlockState attemptCompost(BlockState state, IWorld world, BlockPos pos, ItemStack stack) {
        int i = state.get(LEVEL);
        float f = CHANCES.getFloat(stack.getItem());
        if ((i != 0 || !(f > 0.0F)) && !(world.getRandom().nextDouble() < (double)f)) {
            return state;
        } else {
            int j = i + 1;
            BlockState blockstate = state.with(LEVEL, Integer.valueOf(j));
            world.setBlockState(pos, blockstate, 3);
            if (j == 7) {
                world.getPendingBlockTicks().scheduleTick(pos, state.getBlock(), 20);
            }

            return blockstate;
        }
    }

    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (state.get(LEVEL) == 7) {
            worldIn.setBlockState(pos, state.cycleValue(LEVEL), 3);
            worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_COMPOSTER_READY, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }

    }

    public boolean hasComparatorInputOverride(BlockState state) {
        return true;
    }

    public int getComparatorInputOverride(BlockState blockState, World worldIn, BlockPos pos) {
        return blockState.get(LEVEL);
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(LEVEL);
    }

    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        return false;
    }

    public ISidedInventory createInventory(BlockState state, IWorld world, BlockPos pos) {
        int i = state.get(LEVEL);
        if (i == 8) {
            return new ModComposterBlock.FullInventory(state, world, pos, new ItemStack(Items.BONE_MEAL));
        } else {
            return (ISidedInventory)(i < 7 ? new ModComposterBlock.PartialInventory(state, world, pos) : new ModComposterBlock.EmptyInventory());
        }
    }

    static class EmptyInventory extends Inventory implements ISidedInventory {
        public EmptyInventory() {
            super(0);
        }

        public int[] getSlotsForFace(Direction side) {
            return new int[0];
        }

        /**
         * Returns true if automation can insert the given item in the given slot from the given side.
         */
        public boolean canInsertItem(int index, ItemStack itemStackIn, @Nullable Direction direction) {
            return false;
        }

        /**
         * Returns true if automation can extract the given item in the given slot from the given side.
         */
        public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
            return false;
        }
    }

    static class FullInventory extends Inventory implements ISidedInventory {
        private final BlockState state;
        private final IWorld world;
        private final BlockPos pos;
        private boolean extracted;

        public FullInventory(BlockState state, IWorld world, BlockPos pos, ItemStack stack) {
            super(stack);
            this.state = state;
            this.world = world;
            this.pos = pos;
        }

        /**
         * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended.
         */
        public int getInventoryStackLimit() {
            return 1;
        }

        public int[] getSlotsForFace(Direction side) {
            return side == Direction.DOWN ? new int[]{0} : new int[0];
        }

        /**
         * Returns true if automation can insert the given item in the given slot from the given side.
         */
        public boolean canInsertItem(int index, ItemStack itemStackIn, @Nullable Direction direction) {
            return false;
        }

        /**
         * Returns true if automation can extract the given item in the given slot from the given side.
         */
        public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
            return !this.extracted && direction == Direction.DOWN && stack.getItem() == Items.BONE_MEAL;
        }

        /**
         * For tile entities, ensures the chunk containing the tile entity is saved to disk later - the game won't think
         * it hasn't changed and skip it.
         */
        public void markDirty() {
            ModComposterBlock.resetFillState(this.state, this.world, this.pos);
            this.extracted = true;
        }
    }

    static class PartialInventory extends Inventory implements ISidedInventory {
        private final BlockState state;
        private final IWorld world;
        private final BlockPos pos;
        private boolean inserted;

        public PartialInventory(BlockState state, IWorld world, BlockPos pos) {
            super(1);
            this.state = state;
            this.world = world;
            this.pos = pos;
        }

        /**
         * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended.
         */
        public int getInventoryStackLimit() {
            return 1;
        }

        public int[] getSlotsForFace(Direction side) {
            return side == Direction.UP ? new int[]{0} : new int[0];
        }

        /**
         * Returns true if automation can insert the given item in the given slot from the given side.
         */
        public boolean canInsertItem(int index, ItemStack itemStackIn, @Nullable Direction direction) {
            return !this.inserted && direction == Direction.UP && ComposterBlock.CHANCES.containsKey(itemStackIn.getItem());
        }

        /**
         * Returns true if automation can extract the given item in the given slot from the given side.
         */
        public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
            return false;
        }

        /**
         * For tile entities, ensures the chunk containing the tile entity is saved to disk later - the game won't think
         * it hasn't changed and skip it.
         */
        public void markDirty() {
            ItemStack itemstack = this.getStackInSlot(0);
            if (!itemstack.isEmpty()) {
                this.inserted = true;
                BlockState blockstate = ModComposterBlock.attemptCompost(this.state, this.world, this.pos, itemstack);
                this.world.playEvent(1500, this.pos, blockstate != this.state ? 1 : 0);
                this.removeStackFromSlot(0);
            }

        }
    }

}
