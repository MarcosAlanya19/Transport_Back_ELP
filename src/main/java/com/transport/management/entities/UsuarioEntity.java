package com.transport.management.entities;

import com.transport.management.enums.RoleEnum;
import com.transport.management.utils.abtractBase.BaseEntity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class UsuarioEntity implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;

  @Column(updatable = false, name = "created_at")
  @CreatedDate
  protected Date creadoEn;

  @Column(name = "updated_at")
  @LastModifiedDate
  protected Date actualizadoEn;

  @Column(nullable = false, length = 100)
  private String nombre;

  @Column(nullable = false, unique = true, length = 100)
  private String email;

  @Column(nullable = false, length = 255)
  private String password;

  @Column(nullable = false, length = 50)
  @Enumerated(EnumType.STRING)
  private RoleEnum rol;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    if (rol == null) {
      return List.of();
    }
    return List.of(new SimpleGrantedAuthority(rol.name()));
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}
