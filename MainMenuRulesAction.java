import java.awt.*;
import java.awt.event.*;

public class MainMenuRulesAction implements ActionListener{
	
		private boolean hasInitiated = false;
	
		public void actionPerformed(ActionEvent e) {
			
			if(hasInitiated) return;
			
			RulesModule module = new RulesModule();
			module.executeModule();
			
			hasInitiated = true;
			
		}

}