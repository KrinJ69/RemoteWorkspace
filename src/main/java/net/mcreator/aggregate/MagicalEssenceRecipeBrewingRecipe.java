
package net.mcreator.aggregate;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;

import net.mcreator.aggregate.item.BottleWithEssenceItem;

@AggregateModElements.ModElement.Tag
public class MagicalEssenceRecipeBrewingRecipe extends AggregateModElements.ModElement {
	public MagicalEssenceRecipeBrewingRecipe(AggregateModElements instance) {
		super(instance, 53);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(new ItemStack(Items.GLASS_BOTTLE, (int) (1))),
				Ingredient.fromStacks(new ItemStack(Items.GOLD_INGOT, (int) (1))), new ItemStack(BottleWithEssenceItem.block, (int) (1)));
	}
}
