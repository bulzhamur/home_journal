package zbd.journal.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "water_filter")
public class WaterFilter {
  @Id
  @SequenceGenerator(name = "waterfilterSequence", sequenceName = "aqua_filter_id_seq", allocationSize = 1, initialValue = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "waterfilterSequence")
  private long id;
  @ManyToOne(optional = false, cascade = CascadeType.ALL)
  @JoinColumn(name = "id_action")
  private Action action;
  @Column(updatable = false)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
  private LocalDateTime createdAt;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
  private LocalDateTime updatedAt;
  private String comment;
  @ManyToOne(optional = false, cascade = CascadeType.ALL)
  @JoinColumn(name = "id_user")
  private User user;

  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }

  public Action getAction() {
    return action;
  }
  public void setAction(Action action) {
    this.action = action;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }
  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public String getComment() {
    return comment;
  }
  public void setComment(String comment) {
    this.comment = comment;
  }

  public User getUser() {
    return user;
  }
  public void setUser(User user) {
    this.user = user;
  }
}
