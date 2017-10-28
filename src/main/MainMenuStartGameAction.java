import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainMenuStartGameAction implements ActionListener{
	
		private boolean hasInitiated = false;
		private JFrame mainJF;
		
		MainMenuStartGameAction(JFrame mainJF) {
			this.mainJF = mainJF;
		}
	
		public void actionPerformed(ActionEvent e) {
			
			if(hasInitiated) {
				JOptionPane.showMessageDialog(mainJF, "Game already started!", "Game Info", JOptionPane.INFORMATION_MESSAGE);	
				return;
			}
			
			if (!ConfigurationManager.getConfigurationManager().getConfiguration().getBoardLenght().isEmpty() && ConfigurationManager.getConfigurationManager().getConfiguration().getNumberOfTeams() != 0) {
				System.out.println("Setup completed, start game");
				GameBoardModule gbModule = new GameBoardModule();
				gbModule.executeModule();
				CardDeckModule cdModule = new CardDeckModule();
				cdModule.executeModule();
				QuizModule qModule = new QuizModule();
				qModule.executeModule();
				hasInitiated = true;
			} else {
				if (ConfigurationManager.getConfigurationManager().getConfiguration().getNumberOfTeams() == 0) {
					JOptionPane.showMessageDialog(mainJF, "Please select the Number of Teams!", "Setup Error", JOptionPane.ERROR_MESSAGE);	
				} else {
					JOptionPane.showMessageDialog(mainJF, "Please select a Board Length!", "Setup Error", JOptionPane.ERROR_MESSAGE);
				}
			}			
		}

}