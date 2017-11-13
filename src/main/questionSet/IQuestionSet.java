package questionSet;

import java.util.List;

import question.IQuestion;

public interface IQuestionSet {
	List<IQuestion> getQuestions();
	int getPointValue();
	double getNumInMins();
	
	String toString();
}
