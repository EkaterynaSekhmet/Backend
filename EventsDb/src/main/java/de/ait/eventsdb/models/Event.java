package de.ait.eventsdb.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {


   private Long id;

   private String description; // описание евента

   private String title; // название евента
  }

