
package net.mcreator.aggregate.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.aggregate.itemgroup.AggregateItemsItemGroup;
import net.mcreator.aggregate.AggregateModElements;

@AggregateModElements.ModElement.Tag
public class SoulOfEternityItem extends AggregateModElements.ModElement {
	@ObjectHolder("aggregate:soul_of_eternity")
	public static final Item block = null;
	public SoulOfEternityItem(AggregateModElements instance) {
		super(instance, 48);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(AggregateItemsItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("soul_of_eternity");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
