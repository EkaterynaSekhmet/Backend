package de.ait.listtasks.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

  public enum Role {
    ADMIN,
    USER,
    MANAGER
  }

  public enum State {
    NOT_CONFIRMED,
    CONFIRMED,
    BANNED,
    DELETED
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String email;
  private String password;

  @Enumerated(value = EnumType.STRING)
  private User.Role role;

  @Enumerated(value = EnumType.STRING)
  private User.State state;

  @OneToMany(mappedBy = "tasks")
  private List<Task> tasks; // задачи пользователя
}
