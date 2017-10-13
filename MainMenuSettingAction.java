import java.awt.*;
import java.awt.event.*;

public class MainMenuSettingAction implements ActionListener{
	
		private boolean hasInitiated = false;
	
		public void actionPerformed(ActionEvent e) {
			
			if(hasInitiated) return;
			
			SettingModule module = new SettingModule();
			module.executeModule();
			
			hasInitiated = true;
			
		}

}