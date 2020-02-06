package site.geni.netherhigher;

import io.github.cottonmc.cotton.logging.ModLogger;
import net.fabricmc.api.ModInitializer;
import site.geni.netherhigher.config.Config;

@SuppressWarnings("unused")
public class NetherHigher implements ModInitializer {
	private static final Config CONFIG = new Config().load();
	private static final ModLogger LOGGER = new ModLogger(NetherHigher.class);

	public static Config getConfig() {
		return CONFIG;
	}

	public static void saveConfig() {
		CONFIG.save();
	}

	public static ModLogger getLogger() {
		return LOGGER;
	}

	@Override
	public void onInitialize() {
		LOGGER.info("[NetherHigher] Initialized");
	}
}
