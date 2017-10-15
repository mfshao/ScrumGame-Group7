import java.awt.*;
import java.awt.event.*;

public class MainMenuCreditsAction implements ActionListener{
	
		private boolean hasInitiated = false;
	
		public void actionPerformed(ActionEvent e) {
			
			if(hasInitiated) return;
			
			CreditsModule module = new CreditsModule();
			module.executeModule();
			
			hasInitiated = true;
			
		}

}