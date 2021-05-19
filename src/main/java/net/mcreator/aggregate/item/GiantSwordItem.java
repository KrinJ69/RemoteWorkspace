
package net.mcreator.aggregate.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.aggregate.itemgroup.AggregateArmorsItemGroup;
import net.mcreator.aggregate.AggregateModElements;

@AggregateModElements.ModElement.Tag
public class GiantSwordItem extends AggregateModElements.ModElement {
	@ObjectHolder("aggregate:giant_sword")
	public static final Item block = null;
	public GiantSwordItem(AggregateModElements instance) {
		super(instance, 22);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 2431;
			}

			public float getEfficiency() {
				return 12f;
			}

			public float getAttackDamage() {
				return 14f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(SoulOfLightItem.block, (int) (1)));
			}
		}, 3, -3.5f, new Item.Properties().group(AggregateArmorsItemGroup.tab)) {
		}.setRegistryName("giant_sword"));
	}
}
