
package net.mcreator.aggregate.item;

@AggregateModElements.ModElement.Tag
public class RapidPickaxeItem extends AggregateModElements.ModElement {

	@ObjectHolder("aggregate:rapid_pickaxe")
	public static final Item block = null;

	public RapidPickaxeItem(AggregateModElements instance) {
		super(instance, 81);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 4251;
			}

			public float getEfficiency() {
				return 16f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 5;
			}

			public int getEnchantability() {
				return 13;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -3f, new Item.Properties().group(AggregateToolsItemGroup.tab)) {

		}.setRegistryName("rapid_pickaxe"));
	}

}
