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
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column( name = "password")
    private String password;

    @Column (name = "email")
    private String email;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="role_id",referencedColumnName = "id")
    private Role role;

    @ManyToMany(fetch = FetchType.EAGER,
            targetEntity = Todo.class,
            cascade = {CascadeType.MERGE})
    @JoinTable(name = "users_todo",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "todo_id"))
    private Set<Todo> todo = new HashSet<>(0);
}

