package zbd.journal.domain;

import javax.persistence.*;

@Entity
@Table(name = "action")
public class Action {

  @Id
  @SequenceGenerator(name = "actionSequence", sequenceName = "action_id_seq", allocationSize = 1, initialValue = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actionSequence")
  private long id;

  private String name;
  private String type;

  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

}
