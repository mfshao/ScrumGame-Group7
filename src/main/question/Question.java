package question;

public class Question implements IQuestion {
	private String question;
	private String answer;
	
		
	public Question() {
		question = "Default Question";
		answer = "Default Answer";
	}
	
	public Question(String question, String answer) {
		this.question = question;
		this.answer = answer;
	}
	
	
	@Override
	public String getQuestion() {
		return question;
	}

	@Override
	public String getAnswer() {
		return answer;
	}
	
	@Override
	public String toString(){
		return "Question: " + question + " | Answer: " + answer;
	}
}
