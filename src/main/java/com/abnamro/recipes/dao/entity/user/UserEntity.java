package com.abnamro.recipes.dao.entity.user;

import jakarta.persistence.*;
//import javax.persistence.*;
import lombok.*;

@Table(name = "Users")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String password;

}
