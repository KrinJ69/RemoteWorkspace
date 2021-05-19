
package net.mcreator.aggregate.item;

@AggregateModElements.ModElement.Tag
public class CleanFlameItem extends AggregateModElements.ModElement {

	@ObjectHolder("aggregate:clean_flame")
	public static final Item block = null;

	public CleanFlameItem(AggregateModElements instance) {
		super(instance, 83);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(AggregateItemsItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("clean_flame");
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
