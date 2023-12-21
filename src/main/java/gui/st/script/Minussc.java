package gui.st.script;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import gui.st.GUIOB;
import gui.st.GuiMod;

import java.util.Map;

public class Minussc {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GuiMod.LOGGER.warn("Failed to load dependency world for procedure Min!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				GuiMod.LOGGER.warn("Failed to load dependency x for procedure Min!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				GuiMod.LOGGER.warn("Failed to load dependency y for procedure Min!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				GuiMod.LOGGER.warn("Failed to load dependency z for procedure Min!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GuiMod.LOGGER.warn("Failed to load dependency entity for procedure Min!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		GUIOB.MapVariables.get(world).sc = 0;
		GUIOB.MapVariables.get(world).syncData(world);
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).closeScreen();
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
					Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"command");
		}
	}
}
