package com.bma.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Player1")
    private Player player1;

    @ManyToOne
    @JoinColumn(name = "Player2")
    private Player player2;

    @ManyToOne
    @JoinColumn(name = "Winner")
    private Player winner;
}
