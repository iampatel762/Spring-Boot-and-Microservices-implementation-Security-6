package com.mcqPortal.Modal;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Entity
@Component
@Table(name = "mcqmodal")
public class McqModal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;
    private String difficultyLevel;
    private String category;
}
