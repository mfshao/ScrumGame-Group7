import java.awt.event.*;

public class MainMenuAboutUsAction implements ActionListener{
	
		private boolean hasInitiated = false;
	
		public void actionPerformed(ActionEvent e) {
			
			if(hasInitiated) return;
			
			AboutUsModule module = new AboutUsModule();
			module.executeModule();
			
			hasInitiated = true;
			
		}

}