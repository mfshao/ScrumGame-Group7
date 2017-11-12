import java.awt.event.*;

public class MainMenuAboutUsAction implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			if(ConfigurationManager.getConfigurationManager().getConfiguration().isAboutUsInitialized()) return;

			AboutUsModule module = new AboutUsModule();
			module.executeModule();

		ConfigurationManager.getConfigurationManager().getConfiguration().setAboutUsStatus(true);

		}

}
