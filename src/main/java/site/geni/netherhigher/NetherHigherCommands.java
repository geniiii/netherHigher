package site.geni.netherhigher;

import com.mojang.brigadier.CommandDispatcher;
import io.github.cottonmc.clientcommands.ArgumentBuilders;
import io.github.cottonmc.clientcommands.ClientCommandPlugin;
import io.github.cottonmc.clientcommands.CottonClientCommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ChatScreen;
import site.geni.netherhigher.gui.CustomizeNetherHigherScreen;

@SuppressWarnings("unused")
public class NetherHigherCommands implements ClientCommandPlugin {
	/**
	 * Registers the "/farlands" command, opens the configuration screen on execution
	 *
	 * @author geni
	 */
	@Override
	public void registerCommands(CommandDispatcher<CottonClientCommandSource> dispatcher) {
		dispatcher.register(ArgumentBuilders.literal("netherhigher").executes(
			source -> {
				CustomizeNetherHigherScreen.createAndOpenConfigScreen(MinecraftClient.getInstance().currentScreen instanceof ChatScreen ? null : MinecraftClient.getInstance().currentScreen);

				return 1;
			})
		);
	}
}
