package org.example.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "REVIEW_DATA")
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int score;
    private String comment;


    @ManyToOne(fetch = FetchType.LAZY)
    private Game game;
    private LocalDate created_at;
    private  LocalDate updated_at;
}
