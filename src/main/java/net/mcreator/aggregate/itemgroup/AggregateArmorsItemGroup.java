
package net.mcreator.aggregate.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.aggregate.item.LivingSwordItem;
import net.mcreator.aggregate.AggregateModElements;

@AggregateModElements.ModElement.Tag
public class AggregateArmorsItemGroup extends AggregateModElements.ModElement {
	public AggregateArmorsItemGroup(AggregateModElements instance) {
		super(instance, 29);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabaggregate_armors") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(LivingSwordItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
