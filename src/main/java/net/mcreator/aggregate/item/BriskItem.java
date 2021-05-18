
package net.mcreator.aggregate.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.aggregate.itemgroup.AggregateArmorsItemGroup;
import net.mcreator.aggregate.AggregateModElements;

@AggregateModElements.ModElement.Tag
public class BriskItem extends AggregateModElements.ModElement {
	@ObjectHolder("aggregate:brisk")
	public static final Item block = null;
	public BriskItem(AggregateModElements instance) {
		super(instance, 25);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 2561;
			}

			public float getEfficiency() {
				return 9f;
			}

			public float getAttackDamage() {
				return 2.5f;
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
		}, 3, -0.5f, new Item.Properties().group(AggregateArmorsItemGroup.tab)) {
		}.setRegistryName("brisk"));
	}
}
