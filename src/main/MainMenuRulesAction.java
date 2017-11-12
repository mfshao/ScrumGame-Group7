import java.awt.event.*;

public class MainMenuRulesAction implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			if(ConfigurationManager.getConfigurationManager().getConfiguration().isRulesInitialized()) return;

			RulesModule module = new RulesModule();
			module.executeModule();

			ConfigurationManager.getConfigurationManager().getConfiguration().setRulesStatus(true);

		}

}
