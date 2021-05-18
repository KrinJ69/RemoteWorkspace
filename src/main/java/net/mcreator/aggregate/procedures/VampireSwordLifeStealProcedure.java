package net.mcreator.aggregate.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.aggregate.AggregateModElements;
import net.mcreator.aggregate.AggregateMod;

import java.util.Map;

@AggregateModElements.ModElement.Tag
public class VampireSwordLifeStealProcedure extends AggregateModElements.ModElement {
	public VampireSwordLifeStealProcedure(AggregateModElements instance) {
		super(instance, 21);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AggregateMod.LOGGER.warn("Failed to load dependency entity for procedure VampireSwordLifeSteal!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) < 20)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 1));
		} else {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 100, (int) 2, (false), (false)));
		}
	}
}
