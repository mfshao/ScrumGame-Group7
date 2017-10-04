import java.awt.*;
import java.awt.event.*;

public class MainMenuNewGameAction implements ActionListener{

		private boolean hasInitiated = false;
	
		public void actionPerformed(ActionEvent e) {
			
			//dispose and recreate if new game button is again pushed?
			if(hasInitiated) return;
			
			GameBoardModule gameboard = new GameBoardModule();
			CardDeckModule carddeck = new CardDeckModule();
			QuizModule quiz = new QuizModule();
			
			//let modules 'speak' to eachother
			gameboard.addObserver(carddeck);
			gameboard.addObserver(quiz);
			carddeck.addObserver(gameboard);
			carddeck.addObserver(quiz);
			quiz.addObserver(gameboard);
			quiz.addObserver(carddeck);
			
			gameboard.executeModule();
			carddeck.executeModule();
			quiz.executeModule();
			
			hasInitiated = true;
			
		}

}