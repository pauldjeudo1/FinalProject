package org.paul;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@ToString
@Getter
@Setter
public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private List<Integer> scores;

    private static int nextId = 1;

    public Assignment(String assignmentName, double weight) {
        this.assignmentId = String.format("A%02d", nextId++);
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.scores = new ArrayList<>();
    }

    public double calcAssignmentAvg() {
        if (scores.isEmpty()) {
            return 0;
        }

        double sum = 0;
        int count = 0;

        for (Integer score : scores) {
            if (score != null) {
                sum += score;
                count++;
            }
        }

        return count == 0 ? 0 : sum / count;
    }

    public void generateRandomScore() {
        Random random = new Random();

        for (int i = 0; i < scores.size(); i++) {
            int randomNum = random.nextInt(11);
            int score;

            switch (randomNum) {
                case 0 -> score = random.nextInt(60);
                case 1, 2 -> score = random.nextInt(60, 70);
                case 3, 4 -> score = random.nextInt(70, 80);
                case 5, 6, 7, 8 -> score = random.nextInt(80, 90);
                case 9, 10 -> score = random.nextInt(90, 101);
                default -> score = 0;
            }

            scores.set(i, score);
        }
    }

}
