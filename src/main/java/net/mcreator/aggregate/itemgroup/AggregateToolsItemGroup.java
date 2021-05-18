
package net.mcreator.aggregate.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.aggregate.item.SteelAxeItem;
import net.mcreator.aggregate.AggregateModElements;

@AggregateModElements.ModElement.Tag
public class AggregateToolsItemGroup extends AggregateModElements.ModElement {
	public AggregateToolsItemGroup(AggregateModElements instance) {
		super(instance, 28);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabaggregate_tools") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(SteelAxeItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
