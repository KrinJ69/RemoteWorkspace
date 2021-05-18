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
		super(instance, 24);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				AggregateMod.LOGGER.warn("Failed to load dependency sourceentity for procedure VampireSwordLifeSteal!");
			return;
		}
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHealth() : -1) < 20)) {
			if (sourceentity instanceof LivingEntity)
				((LivingEntity) sourceentity)
						.setHealth((float) (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHealth() : -1) + 1));
		} else {
			if (sourceentity instanceof LivingEntity)
				((LivingEntity) sourceentity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 100, (int) 2, (false), (false)));
		}
	}
}
