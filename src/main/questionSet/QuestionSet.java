package questionSet;

import java.util.List;

import question.IQuestion;

public class QuestionSet implements IQuestionSet {
	
	private List<IQuestion> questionList;
	private int pointValue;
	private double numInMins;
	
	public QuestionSet() {
		
	}
	
	public QuestionSet(List<IQuestion> questions, int points,double numInMins2) {
		questionList = questions;
		pointValue = points;
		this.numInMins = numInMins2;
	}
	
	@Override
	public List<IQuestion> getQuestions() {
		return questionList;
	}

	@Override
	public int getPointValue() {
		return pointValue;
	}
	
	@Override
	public double getNumInMins() {
		return numInMins;
	}
	
	@Override
	public String toString(){
		String toString = "Point Value: "  + pointValue +" | Time: " + numInMins + " Mintues" +  "\n";
		
		for (IQuestion question : questionList) {
			toString += "\t" + question.toString() + "\n";
		}
		
		return toString;
	}



}
