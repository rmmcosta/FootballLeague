package com.rmmcosta.footballleague.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Result {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "home_team_id")
    @NonNull
    private Team homeTeamId;
    @ManyToOne
    @JoinColumn(name = "away_team_id")
    @NonNull
    private Team awayTeamId;
    @NonNull
    private int goalsScored;
    @NonNull
    private int goalsSuffered;
}
