package crudApp.Models;

import crudApp.DAO.UserInfoDao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "user")
    private String name;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;


}
