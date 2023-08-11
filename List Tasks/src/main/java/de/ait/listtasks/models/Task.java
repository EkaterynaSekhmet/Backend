package de.ait.listtasks.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title; // название задачи
  private String description; // описание задачи

  private LocalDate startDate; // дата начала выполнения
  private LocalDate finishDate; // дата окончания выполнения

  @ManyToOne
  @JoinColumn(name = "executor")
  private User executor; // исполнитель задачи


}


