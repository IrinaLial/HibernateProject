package model;

import lombok.*;
import org.hibernate.annotations.OptimisticLockType;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@org.hibernate.annotations.Entity(optimisticLock = OptimisticLockType.DIRTY, dynamicUpdate = true)
@Table(name ="role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name ="role")
    private String role;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "role", cascade = CascadeType.ALL)
    private User user;
}
