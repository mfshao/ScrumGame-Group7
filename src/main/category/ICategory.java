package category;

import java.util.List;

import questionSet.IQuestionSet;

public interface ICategory {
	List<IQuestionSet> getQuestionSet();
	String getTitle();
	
	String toString();
}
