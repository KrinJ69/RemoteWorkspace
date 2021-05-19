
package net.mcreator.aggregate.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.LivingEntity;

import net.mcreator.aggregate.procedures.WrathLivingEntityIsHitWithToolProcedure;
import net.mcreator.aggregate.itemgroup.AggregateArmorsItemGroup;
import net.mcreator.aggregate.AggregateModElements;

import java.util.Map;
import java.util.HashMap;

@AggregateModElements.ModElement.Tag
public class WrathItem extends AggregateModElements.ModElement {
	@ObjectHolder("aggregate:wrath")
	public static final Item block = null;
	public WrathItem(AggregateModElements instance) {
		super(instance, 24);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 3671;
			}

			public float getEfficiency() {
				return 12f;
			}

			public float getAttackDamage() {
				return 5.5f;
			}

			public int getHarvestLevel() {
				return 12;
			}

			public int getEnchantability() {
				return 12;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(SoulOfDarknessItem.block, (int) (1)));
			}
		}, 3, -2f, new Item.Properties().group(AggregateArmorsItemGroup.tab)) {
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
					WrathLivingEntityIsHitWithToolProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("wrath"));
	}
}
