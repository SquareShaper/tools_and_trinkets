package net.squareshaper.tools_and_trinkets.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.squareshaper.tools_and_trinkets.registry.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin extends Entity {

    public ItemEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Shadow public abstract ItemStack getStack();

    @Shadow public abstract void setStack(ItemStack stack);

    @Shadow public abstract BlockPos getVelocityAffectingPos();

    @Inject(method = "tryMerge(Lnet/minecraft/entity/ItemEntity;)V", at = @At(value = "HEAD"))
    private void makeFendorine(ItemEntity other, CallbackInfo ci) {
        BlockState blockState = this.getWorld().getBlockState(this.getBlockPos());
        if (blockState.getBlock() == Blocks.WATER_CAULDRON) {
            ItemStack itemStack = this.getStack();
            ItemStack itemStack1 = other.getStack();
            // Make Fendorine
            if ((itemStack.getItem() == Items.AMETHYST_SHARD && itemStack1.getItem() == Items.DIAMOND)
                    || (itemStack.getItem() == Items.DIAMOND && itemStack1.getItem() == Items.AMETHYST_SHARD)) {
                if (itemStack.getCount() < itemStack1.getCount()) {
                    int count = itemStack.getCount();
                    ItemStack newStack = new ItemStack(ModItems.FENDORINE_SHARD);
                    newStack.setCount(count);
                    this.setStack(newStack);
                    itemStack1.setCount(itemStack1.getCount() - count);
                    this.addVelocity(0, 0.4,0);
                } else {
                    int count = itemStack1.getCount();
                    ItemStack newStack = new ItemStack(ModItems.FENDORINE_SHARD);
                    newStack.setCount(count);
                    other.setStack(newStack);
                    itemStack.setCount(itemStack.getCount() - count);
                    other.addVelocity(0, 0.4,0);
                }
                return;
            }

            // Stabilize pearls
            if ((itemStack.getItem() == ModItems.FENDORINE_SHARD && itemStack1.getItem() == Items.ENDER_PEARL)
                    || (itemStack.getItem() == Items.ENDER_PEARL && itemStack1.getItem() == ModItems.FENDORINE_SHARD)) {
                if (itemStack.getCount() == 1) {
                    int count = itemStack.getCount();
                    ItemStack newStack = new ItemStack(ModItems.FENDORINE_PEARL);
                    newStack.setCount(count);
                    this.setStack(newStack);
                    itemStack1.setCount(itemStack1.getCount() - count);
                    this.addVelocity(0, 0.4,0);
                }
                return;
            }
        }
    }
}
