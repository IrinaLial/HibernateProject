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
@Table(name = "priority")
public class Priority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @Column(name = "detail")
    private String detail;

    @ManyToMany(fetch = FetchType.EAGER,
            targetEntity = Todo.class,
            cascade = {CascadeType.MERGE})
    @JoinTable(name = "todo_priority",
            joinColumns = @JoinColumn(name = "priority_id"),
            inverseJoinColumns = @JoinColumn(name = "todo_id"))
    private Set<Todo> todo = new HashSet<>(1);

}
