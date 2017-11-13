import javax.swing.*;
import java.awt.*;
import java.util.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import actionListeners.QuestionSetSelectActionListener;
import category.Category;
import category.ICategory;
import question.IQuestion;
import question.Question;
import questionSet.IQuestionSet;
import questionSet.QuestionSet;

public class QuizModule extends Observable implements Observer{

	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 600;


	public QuizModule(){

		//constructor
		//
	}

	public void executeModule(){


		JFrame frame = init();
		//begin!
		//observer example.
		setChanged();
		notifyObservers("Hi. I am quiz module. I am sending a message to all of my observers.");

	}

	private JFrame init(){

			List<IQuestion> questionList1 = new ArrayList<IQuestion>() {{
			add(new Question("Most agile approaches emphasize ____ as the primary means of\r\n" + 
					"capturing requirements.\r\n\n" + 
					"A.Personas\r\n" + 
					"B.Jobs\r\n" + 
					"C.Epics\r\n" + 
					"D.User Stories","D.User Stories"));
			add(new Question("Which of the following elements are not included in a user story?\r\n\n" + 
					"A. Written description of the story including the role(s) that participate\r\n" + 
					"in the story.\r\n" + 
					"B. A detailed UI design.\r\n" + 
					"C. Conversations about the story that help capture the details.\r\n" + 
					"D. Acceptance tests that are used to verify that a story is done", "B. A detailed UI design."));
			add(new Question("We often think of user stories as the functional requirements of a system,\r\n" + 
					"but they can also illustrate:\r\n\n" + 
					"A. Stakeholder interests\r\n" + 
					"B. Intended Market\r\n" + 
					"C. Developer Roles\r\n" + 
					"D. Technical Constraints\n\n", "D. Technical Constraints"));
			add(new Question("True or false:\r\n\n" + 
					"When creating stories make them depend on each other so there\r\n"+
					"is more a sense of connectedness.\n\n", "FALSE"));
			add(new Question("____ describes how one story relates to another.\r\n\n" + 
					"A. Cohesiveness\r\n" + 
					"B. Communication\r\n" + 
					"C. Flow\r\n" + 
					"D. Connectedness\n\n", "A. Cohesiveness"));
		}};	
		
		int pointValue1 = 3;
		double numInMins1 =2.0;
		
		QuestionSet  questionSet1 = new QuestionSet(questionList1, pointValue1, numInMins1);
				
		List<IQuestion> questionList2 = new ArrayList<IQuestion>() {{
			add(new Question("Question 6", "Answer 6"));
			add(new Question("Question 7", "Answer 7"));
			add(new Question("Question 8", "Answer 8"));
			add(new Question("Question 9", "Answer 9"));
			add(new Question("Question 10", "Answer 10"));
		}};
		
		int pointValue2 = 5;
		double numInMins2 = 2.0;
		
		QuestionSet  questionSet2 = new QuestionSet(questionList2, pointValue2, numInMins2);
		
		List<IQuestion> questionList3 = new ArrayList<IQuestion>() {{
			add(new Question("Question 11", "Answer 11"));
			add(new Question("Question 12", "Answer 12"));
			add(new Question("Question 13", "Answer 13"));
			add(new Question("Question 14", "Answer 14"));
			add(new Question("Question 15", "Answer 15"));
		}};
		
		int pointValue3 = 10;
		double numInMins3 = 2.0;
		
		QuestionSet  questionSet3 = new QuestionSet(questionList3, pointValue3, numInMins3);
		
		List<IQuestion> questionList4 = new ArrayList<IQuestion>() {{
			add(new Question("Question 11", "Answer 11"));
			add(new Question("Question 12", "Answer 12"));
			add(new Question("Question 13", "Answer 13"));
			add(new Question("Question 14", "Answer 14"));
			add(new Question("Question 15", "Answer 15"));
		}};
		
		int pointValue4 = 3;
		double numInMins4 = 2.0;
		
		QuestionSet  questionSet4 = new QuestionSet(questionList4, pointValue4, numInMins4);
		
		List<IQuestion> questionList5 = new ArrayList<IQuestion>() {{
			add(new Question("True or false: \r\n\n" + 
					"In cross-fertilization learning, team members are encouraged to gain\r\n" + 
					"knowledge and experience in areas that are not their primary are expertise.\r\n", "FALSE"));
			add(new Question("In the Scrum process who creates the prioritized wish\n" + 
					"list of stories called a product backlog?\r\n\n" + 
					"A. Product Owner\r\n" + 
					"B. Scrum Master\r\n" + 
					"C. Developers\r\n" + 
					"D. Client\r\n" + 
					"", "A. Product Owner"));
			add(new Question("Which is not apart of the 3 main roles in Scrum?\r\\n\n" + 
					"A. Product Owner\r\n" + 
					"B. Scrum Master\r\n" + 
					"C. Project Team\r\n" + 
					"D. Stakeholder\r\n\n", "D. Stakeholder"));
			add(new Question("Which is not an attribute of a Sprint?\r\n\n" + 
					"A. Timeboxed to a fixed length, typically 2-4 weeks.\r\n" + 
					"B. Immutable\r\n" + 
					"C. Managed only by the development team.\r\n" + 
					"D. Preceded by a planning meeting to develop the sprint backlog.\r\n\n", "B. Immutable"));
			add(new Question("Which is not a ceremony commonly performed during Scrum?\r\n\n" + 
					"A. Daily Scrum\r\n" + 
					"B. Backlog Grooming\r\n" + 
					"C. Retrospective\r\n" + 
					"D. Code cleanup\r\n", "D. Code cleanup"));
		}};
		
		int pointValue5 = 5;
		double numInMins5 = 2.0;
		
		QuestionSet  questionSet5 = new QuestionSet(questionList5, pointValue5, numInMins5);
		
		List<IQuestion> questionList6 = new ArrayList<IQuestion>() {{
			add(new Question("Question", "Answer"));
			add(new Question("Question 12", "Answer 12"));
			add(new Question("Question 13", "Answer 13"));
			add(new Question("Question 14", "Answer 14"));
			add(new Question("Question 15", "Answer 15"));
		}};
		
		int pointValue6 = 10;
		double numInMins6 = 2.0;
		
		QuestionSet  questionSet6 = new QuestionSet(questionList6, pointValue6, numInMins6);

		List<IQuestion> questionList7 = new ArrayList<IQuestion>() {{
			add(new Question("Question", "Answer"));
			add(new Question("Question 12", "Answer 12"));
			add(new Question("Question 13", "Answer 13"));
			add(new Question("Question 14", "Answer 14"));
			add(new Question("Question 15", "Answer 15"));
		}};
		
		int pointValue7 = 3;
		double numInMins7 = 2.0;
		
		
		QuestionSet  questionSet7 = new QuestionSet(questionList7, pointValue7, numInMins7);
		
		List<IQuestion> questionList8 = new ArrayList<IQuestion>() {{
			add(new Question("Question", "Answer"));
			add(new Question("Question 12", "Answer 12"));
			add(new Question("Question 13", "Answer 13"));
			add(new Question("Question 14", "Answer 14"));
			add(new Question("Question 15", "Answer 15"));
		}};
		
		int pointValue8 = 5;
		double numInMins8 = 2.0;
		
		QuestionSet  questionSet8 = new QuestionSet(questionList8, pointValue8, numInMins8);
		
		List<IQuestion> questionList9 = new ArrayList<IQuestion>() {{
			add(new Question("True or false:\r\n\n" + 
					"In centralized source code control, most actions occur on the developer\r\n" + 
					"machine.\r\n\n", "FALSE"));
			add(new Question("True or false:\r\n\n" + 
					"Traditional source code management systems track the deltas or changes of\r\n" + 
					"a file over time.\r\n" + 
					"", "TRUE"));
			add(new Question("The files and folders that you retrieve from Git during a clone make up your…\r\n\n" + 
					"A. Repository\r\n" + 
					"B. Branch\r\n" + 
					"C. Workspace\r\n" + 
					"D. Tree\r\n" + 
					"", "C. Workspace"));
			add(new Question("Which is not a git command?\r\n\n" + 
					"A. git remote\r\n" + 
					"B. git commit\r\n" + 
					"C. git branch\r\n" + 
					"D. git repo\r\n" + 
					"", "D. git repo"));
			add(new Question("True or false:\r\n\n" + 
					"Fast-forward merges allow the pointer of the branch being merged into to\r\n" + 
					"just be re-pointed to the commit of the branch that was merged in.\r\n", "TRUE"));
		}};
		
		int pointValue9 = 10;
		double numInMins9 = 2.0;
		
		QuestionSet  questionSet9 = new QuestionSet(questionList9, pointValue9, numInMins9);
		
		List<IQuestionSet> questionSetList1  =new ArrayList<IQuestionSet>() {{
			add(questionSet3);
			add(questionSet2);
			add(questionSet1);
		}};
		
		
		List<IQuestionSet> questionSetList2  =new ArrayList<IQuestionSet>() {{
			add(questionSet6);
			add(questionSet5);
			add(questionSet4);
		}};
		
		List<IQuestionSet> questionSetList3  =new ArrayList<IQuestionSet>() {{
			add(questionSet9);
			add(questionSet8);
			add(questionSet7);
		}};
		
		
		Category category1 = new Category (questionSetList1,"EPICS/STORIES");
		Category category2 = new Category (questionSetList2,"SCRUM");
		Category category3 = new Category (questionSetList3,"GIT");
		
	
		List<ICategory> categoryList = new ArrayList<ICategory>() {{
			add(category1);
			add(category2);
			add(category3);
		}};
		
		System.out.println(category1.toString());
		
		
		JFrame frame = new JFrame("Quiz Module");
        JPanel panel = new JPanel();
		//change layout as needed

  		panel.setLayout(new GridBagLayout());
  		
  		GridBagConstraints c = new GridBagConstraints();
  		
  		int xPos = 0;
  		int yPos = 0;
  		
    
  		for (ICategory category: categoryList) {
  			
  			c.gridx = xPos;
  	        c.gridy = yPos;
  	         
  		    c.gridheight = 1;
  		    c.gridwidth = 1;
  		    
  		    c.ipadx = 0;
  		    c.ipady = 0;
  		     
  		    c.weightx = 1;
  		    c.weighty = 1;
  		    
  		  c.insets = new Insets(5,10,5,10);
  		     
  		    c.anchor = GridBagConstraints.NORTHWEST;
  		    c.fill = GridBagConstraints.BOTH;
  			
  			panel.add(new JLabel(category.getTitle(), SwingConstants.CENTER),c);
  			
  			yPos++;
  			
  			for (IQuestionSet questionSet:category.getQuestionSet()) {
  				
  				c.gridx = xPos;
  	  	        c.gridy = yPos;
  	  	         
  	  		    c.gridheight = 1;
  	  		    c.gridwidth = 1;
  	  		    
  	  		    c.ipadx = 0;
  	  		    c.ipady = 0;
  	  		     
  	  		    c.weightx = 1;
  	  		    c.weighty = 1;
  	  		    
  	  		    c.insets = new Insets(5,10,5,10);
  	  		     
  	  		    c.anchor = GridBagConstraints.NORTHWEST;
  	  		    c.fill = GridBagConstraints.BOTH;
  	  			
  	  		    JButton button = new JButton(String.valueOf(questionSet.getPointValue()));
  	  		    
  	  		    button.addActionListener(new QuestionSetSelectActionListener(questionSet));
  				
  				panel.add(button,c);
  				
  				yPos++;
  			}
  			
  			yPos = 0;
  			xPos++;
  			
  		}
  		
        frame.getContentPane().add(panel);
        frame.setSize(600, 300);
        frame.setLocation(0,700);
        
        //might be messy coding show/hiding these windows(?)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

		return frame;

	}

	public void update(Observable o, Object arg) {
		//check for type of o to know what module sent message
		System.out.println("Quiz received message: " + arg.toString());
	}

}
