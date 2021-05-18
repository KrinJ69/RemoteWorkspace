
package net.mcreator.aggregate.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.aggregate.AggregateModElements;

@AggregateModElements.ModElement.Tag
public class HardenedIronSwordItem extends AggregateModElements.ModElement {
	@ObjectHolder("aggregate:hardened_iron_sword")
	public static final Item block = null;
	public HardenedIronSwordItem(AggregateModElements instance) {
		super(instance, 25);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 500;
			}

			public float getEfficiency() {
				return 7f;
			}

			public float getAttackDamage() {
				return 6.5f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 15;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(HardnedIronItem.block, (int) (1)));
			}
		}, 3, -2.9f, new Item.Properties().group(ItemGroup.COMBAT)) {
		}.setRegistryName("hardened_iron_sword"));
	}
}
