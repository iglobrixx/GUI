package gui.st.script;

import net.minecraft.world.IWorld;

import gui.st.GUIOB;
import gui.st.GuiMod;

import java.util.Map;

public class powiglosc {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GuiMod.LOGGER.warn("Failed to load dependency world for procedure Pow!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		GUIOB.MapVariables.get(world).sc = 1;
		GUIOB.MapVariables.get(world).syncData(world);
	}
}
