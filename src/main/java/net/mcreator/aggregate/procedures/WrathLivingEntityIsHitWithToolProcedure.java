package net.mcreator.aggregate.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.aggregate.AggregateModElements;
import net.mcreator.aggregate.AggregateMod;

import java.util.Map;

@AggregateModElements.ModElement.Tag
public class WrathLivingEntityIsHitWithToolProcedure extends AggregateModElements.ModElement {
	public WrathLivingEntityIsHitWithToolProcedure(AggregateModElements instance) {
		super(instance, 57);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AggregateMod.LOGGER.warn("Failed to load dependency entity for procedure WrathLivingEntityIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 80, (int) 2));
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 4);
	}
}
