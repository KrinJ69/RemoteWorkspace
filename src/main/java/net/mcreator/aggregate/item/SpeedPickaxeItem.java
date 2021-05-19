
package net.mcreator.aggregate.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.aggregate.itemgroup.AggregateToolsItemGroup;
import net.mcreator.aggregate.AggregateModElements;

@AggregateModElements.ModElement.Tag
public class SpeedPickaxeItem extends AggregateModElements.ModElement {
	@ObjectHolder("aggregate:speed_pickaxe")
	public static final Item block = null;
	public SpeedPickaxeItem(AggregateModElements instance) {
		super(instance, 14);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 4000;
			}

			public float getEfficiency() {
				return 12f;
			}

			public float getAttackDamage() {
				return 1f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(SoulOfSpeedItem.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(AggregateToolsItemGroup.tab)) {
		}.setRegistryName("speed_pickaxe"));
	}
}
