package site.geni.netherhigher.config;

import me.zeroeightsix.fiber.JanksonSettings;
import me.zeroeightsix.fiber.exception.FiberException;
import me.zeroeightsix.fiber.tree.ConfigNode;
import me.zeroeightsix.fiber.tree.ConfigValue;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Config {
	private static final File CONFIG_FILE = new File(FabricLoader.getInstance().getConfigDirectory(), "netherHigher.json5");

	private ConfigNode root = new ConfigNode();

	// General
	public ConfigValue<Boolean> raiseNetherHeightLimit = ConfigValue.builder(Boolean.class)
		.withParent(root)
		.withDefaultValue(true)
		.withComment("Raises the Nether height limit to 256.")
		.withName("raiseNetherHeightLimit")
		.build();
	public ConfigValue<Boolean> raiseEndHeightLimit = ConfigValue.builder(Boolean.class)
		.withParent(root)
		.withDefaultValue(true)
		.withComment("Raises the End height limit to 256.")
		.withName("raiseEndHeightLimit")
		.build();

	public Config() {
	}

	public void save() {
		try {
			new JanksonSettings().serialize(this.root, Files.newOutputStream(Config.CONFIG_FILE.toPath()), false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Config load() {
		if (!CONFIG_FILE.exists()) {
			this.save();
		}

		try {
			new JanksonSettings().deserialize(this.root, Files.newInputStream(Config.CONFIG_FILE.toPath()));
		} catch (IOException | FiberException e) {
			e.printStackTrace();
		}
		return this;
	}
}