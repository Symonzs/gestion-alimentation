package fr.but3.gestion_alimentation.model;


import java.sql.*;
import java.util.List;

import org.springframework.boot.context.properties.bind.DefaultValue;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class Users {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "uid", nullable = false)
  private Integer uid;
  
  @Column(name = "login", nullable = false)
  private String login;
  
  @Column(name = "mot_de_passe", nullable = false)
  private String motDePasse;
  
  @Column(name = "administrateur", nullable = false)
  private boolean administrateur;

  

}
