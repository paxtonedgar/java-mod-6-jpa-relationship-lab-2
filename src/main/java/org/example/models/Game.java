package org.example.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "GAME_DATA")
@Getter
@Setter
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String genre;
    private String platform;
    private double price;
    private LocalDate create_at;
    private LocalDate updated_at;

    @OneToMany(mappedBy = "id")
    private List<Review> reviewList = new ArrayList<>();

}
