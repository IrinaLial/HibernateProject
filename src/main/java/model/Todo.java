package model;

import lombok.*;
import org.hibernate.annotations.OptimisticLockType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@org.hibernate.annotations.Entity(optimisticLock = OptimisticLockType.DIRTY, dynamicUpdate = true)
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    @Column(name = "creationDate")
    private String creationDate;

    @ManyToMany(fetch = FetchType.EAGER,
            targetEntity = User.class,
            cascade = {CascadeType.MERGE})
    @JoinTable(name = "users_todo",
            joinColumns = @JoinColumn(name = "todo_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id"))
    private Set<User> users = new HashSet<>(0);

    @ManyToMany(fetch = FetchType.EAGER,
            targetEntity = Priority.class,
            cascade = {CascadeType.MERGE})
    @JoinTable(name = "todo_priority",
            joinColumns = @JoinColumn(name = "todo_id"),
            inverseJoinColumns = @JoinColumn(name = "priority_id"))
    private Set<Priority> priorities = new HashSet<>(0);


}
