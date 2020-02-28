package cl.desafiolatam.preguntadinamica.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {
    private String category;
    private String type;
    private String difficulty;
    @SerializedName("question")
    private String pregunta;

    public void setCategory(String category) {
        this.category = category;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setIncorrectAnswer(List<String> incorrectAnswer) {
        this.incorrectAnswer = incorrectAnswer;
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getIncorrectAnswer() {
        return incorrectAnswer;
    }

    @SerializedName("correct_answer")
    private String correctAnswer;
    @SerializedName("incorrect_answers")
    private List<String> incorrectAnswer;
}
