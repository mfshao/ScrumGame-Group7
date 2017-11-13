package category;

import java.util.ArrayList;
import java.util.List;

import question.IQuestion;
import questionSet.IQuestionSet;

public class Category implements ICategory {
	private List<IQuestionSet> questionSetList;
	private String title;
	
	public Category() {
		questionSetList = new ArrayList<IQuestionSet>();
		title = "Default Title";
	}
	
	public Category(List<IQuestionSet> questionSetList, String title)  {
		this.questionSetList = questionSetList;
		this.title = title;	
	}
	
	
	@Override
	public List<IQuestionSet> getQuestionSet() {
		return questionSetList;
	}

	@Override
	public String getTitle() {
		return title;
	}
	
	@Override
	public String toString(){
		String toString = "Title: " + title + "\n";
		
		for (IQuestionSet questionSet : questionSetList) {
			
			toString += "\t" + questionSet.toString() + "\n";
		}
		
		return toString;
	}

}
