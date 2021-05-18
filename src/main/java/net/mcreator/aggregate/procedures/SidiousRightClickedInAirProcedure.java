package net.mcreator.aggregate.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;

import net.mcreator.aggregate.AggregateModElements;
import net.mcreator.aggregate.AggregateMod;

import java.util.Map;

@AggregateModElements.ModElement.Tag
public class SidiousRightClickedInAirProcedure extends AggregateModElements.ModElement {
	public SidiousRightClickedInAirProcedure(AggregateModElements instance) {
		super(instance, 76);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AggregateMod.LOGGER.warn("Failed to load dependency entity for procedure SidiousRightClickedInAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AggregateMod.LOGGER.warn("Failed to load dependency world for procedure SidiousRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof ServerWorld) {
			LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
			_ent.moveForced(
					Vector3d.copyCenteredHorizontally(
							new BlockPos(
									(int) (entity.world.rayTraceBlocks(
											new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * 200, entity.getLook(1f).y * 200,
															entity.getLook(1f).z * 200),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
											.getPos().getX()),
									(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 200, entity.getLook(1f).y * 200,
													entity.getLook(1f).z * 200),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
									(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 200, entity.getLook(1f).y * 200,
													entity.getLook(1f).z * 200),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()))));
			_ent.setEffectOnly(false);
			((World) world).addEntity(_ent);
		}
		new Object() {
			private int ticks = 0;
			private float waitTicks;
			private IWorld world;
			public void start(IWorld world, int waitTicks) {
				this.waitTicks = waitTicks;
				MinecraftForge.EVENT_BUS.register(this);
				this.world = world;
			}

			@SubscribeEvent
			public void tick(TickEvent.ServerTickEvent event) {
				if (event.phase == TickEvent.Phase.END) {
					this.ticks += 1;
					if (this.ticks >= this.waitTicks)
						run();
				}
			}

			private void run() {
				System.out.println("##.##");
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 40);
	}
}
