package com.rmmcosta.footballleague.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Classification {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull private String team;
    @NonNull private int points;
    @NonNull private int goalsScored;
    @NonNull private int goalsSuffered;
}
