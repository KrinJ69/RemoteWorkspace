
package net.mcreator.aggregate.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.aggregate.block.SteelBlockBlock;
import net.mcreator.aggregate.AggregateModElements;

@AggregateModElements.ModElement.Tag
public class AggregateBlocksItemGroup extends AggregateModElements.ModElement {
	public AggregateBlocksItemGroup(AggregateModElements instance) {
		super(instance, 44);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabaggregate_blocks") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(SteelBlockBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
