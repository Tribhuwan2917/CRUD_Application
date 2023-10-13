package com.spring_crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "user_details")
public class User {
    @Id
    private Integer userId;
    private String userName;
    private String userEmail;
    private String userAbout;
}
