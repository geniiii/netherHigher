package site.geni.netherhigher;

import io.github.prospector.modmenu.api.ModMenuApi;
import net.minecraft.client.gui.screen.Screen;
import site.geni.netherhigher.gui.CustomizeNetherHigherScreen;

import java.util.function.Function;

@SuppressWarnings("unused")
public class NetherHigherModMenuApiImpl implements ModMenuApi {
	@Override
	public String getModId() {
		return "netherhigher";
	}

	@Override
	public Function<Screen, ? extends Screen> getConfigScreenFactory() {
		return CustomizeNetherHigherScreen::createConfigScreen;
	}
}
