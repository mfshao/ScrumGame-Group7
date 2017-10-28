
public class ConfigurationManager {

	/** The configuration manager. */
	private static ConfigurationManager configurationManager = null;

	/** The configuration. */
	private Configuration configuration = null;

	static {
		configurationManager = new ConfigurationManager();
	}

	/**
	 * Instantiates a new configuration manager.
	 */
	private ConfigurationManager() {
		configuration = new Configuration();
	}

	/**
	 * Get the configuration manager.
	 *
	 * @return The configuration manager
	 */
	public final static ConfigurationManager getConfigurationManager() {
		return configurationManager;
	}

	/**
	 * Get current configuration.
	 *
	 * @return The current configuration
	 */
	public final Configuration getConfiguration() {
		return configuration;
	}
}
