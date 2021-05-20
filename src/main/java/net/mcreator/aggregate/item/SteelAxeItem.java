
package net.mcreator.aggregate.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.mcreator.aggregate.itemgroup.AggregateToolsItemGroup;
import net.mcreator.aggregate.AggregateModElements;

@AggregateModElements.ModElement.Tag
public class SteelAxeItem extends AggregateModElements.ModElement {
	@ObjectHolder("aggregate:steel_axe")
	public static final Item block = null;
	public SteelAxeItem(AggregateModElements instance) {
		super(instance, 10);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 300;
			}

			public float getEfficiency() {
				return 7f;
			}

			public float getAttackDamage() {
				return 5f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(SteelIngotItem.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(AggregateToolsItemGroup.tab)) {
		}.setRegistryName("steel_axe"));
	}
}
