
package net.mcreator.aggregate.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.ActionResult;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;

import net.mcreator.aggregate.procedures.SidiousRightClickedInAirProcedure;
import net.mcreator.aggregate.procedures.SidiousLivingEntityIsHitWithToolProcedure;
import net.mcreator.aggregate.itemgroup.AggregateArmorsItemGroup;
import net.mcreator.aggregate.AggregateModElements;

import java.util.Map;
import java.util.HashMap;

@AggregateModElements.ModElement.Tag
public class SidiousItem extends AggregateModElements.ModElement {
	@ObjectHolder("aggregate:sidious")
	public static final Item block = null;
	public SidiousItem(AggregateModElements instance) {
		super(instance, 23);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1031;
			}

			public float getEfficiency() {
				return 9f;
			}

			public float getAttackDamage() {
				return 4.5f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 12;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -3.2f, new Item.Properties().group(AggregateArmorsItemGroup.tab)) {
			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = retval.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("world", world);
					SidiousRightClickedInAirProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}

			@Override
			public ActionResultType onItemUse(ItemUseContext context) {
				ActionResultType retval = super.onItemUse(context);
				World world = context.getWorld();
				BlockPos pos = context.getPos();
				PlayerEntity entity = context.getPlayer();
				Direction direction = context.getFace();
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				ItemStack itemstack = context.getItem();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("world", world);
					SidiousRightClickedInAirProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}

			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					SidiousLivingEntityIsHitWithToolProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("sidious"));
	}
}
