package net.mcreator.aggregate.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;

import net.mcreator.aggregate.AggregateModElements;
import net.mcreator.aggregate.AggregateMod;

import java.util.Map;

@AggregateModElements.ModElement.Tag
public class ReaperLivingEntityIsHitWithToolProcedure extends AggregateModElements.ModElement {
	public ReaperLivingEntityIsHitWithToolProcedure(AggregateModElements instance) {
		super(instance, 66);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AggregateMod.LOGGER.warn("Failed to load dependency entity for procedure ReaperLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AggregateMod.LOGGER.warn("Failed to load dependency x for procedure ReaperLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AggregateMod.LOGGER.warn("Failed to load dependency y for procedure ReaperLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AggregateMod.LOGGER.warn("Failed to load dependency z for procedure ReaperLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AggregateMod.LOGGER.warn("Failed to load dependency world for procedure ReaperLivingEntityIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof ServerWorld) {
			LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
			_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) z)));
			_ent.setEffectOnly(true);
			((World) world).addEntity(_ent);
		}
		entity.attackEntityFrom(DamageSource.LIGHTNING_BOLT, (float) 4);
	}
}
