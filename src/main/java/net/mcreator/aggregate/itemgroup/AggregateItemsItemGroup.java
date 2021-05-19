
package net.mcreator.aggregate.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.aggregate.item.SteelIngotItem;
import net.mcreator.aggregate.AggregateModElements;

@AggregateModElements.ModElement.Tag
public class AggregateItemsItemGroup extends AggregateModElements.ModElement {
	public AggregateItemsItemGroup(AggregateModElements instance) {
		super(instance, 45);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabaggregate_items") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(SteelIngotItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
