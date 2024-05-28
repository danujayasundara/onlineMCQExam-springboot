package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuesDto {
	
	private int questionId;
	private String question;
	//private List<AnswerDto> answers; 
    private AnswerDto answer1;
    private AnswerDto answer2;
    private AnswerDto answer3;
    private AnswerDto answer4;
   
    public QuesDto(@JsonProperty("questionId") int questionId, @JsonProperty("question") String question,
            @JsonProperty("answers") List<AnswerDto> answers) {
		 super();
		 this.questionId = questionId;
		 this.question = question;
		 this.answer1 = answers.size() > 0 ? answers.get(0) : null;
		 this.answer2 = answers.size() > 1 ? answers.get(1) : null;
		 this.answer3 = answers.size() > 2 ? answers.get(2) : null;
		 this.answer4 = answers.size() > 3 ? answers.get(3) : null;
	}
		
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public AnswerDto getAnswer1() {
		return answer1;
	}
	public void setAnswer1(AnswerDto answer1) {
		this.answer1 = answer1;
	}
	public AnswerDto getAnswer2() {
		return answer2;
	}
	public void setAnswer2(AnswerDto answer2) {
		this.answer2 = answer2;
	}
	public AnswerDto getAnswer3() {
		return answer3;
	}
	public void setAnswer3(AnswerDto answer3) {
		this.answer3 = answer3;
	}
	public AnswerDto getAnswer4() {
		return answer4;
	}
	public void setAnswer4(AnswerDto answer4) {
		this.answer4 = answer4;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	/*public List<AnswerDto> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDto> answers) {
        this.answers = answers;
    }*/

}
