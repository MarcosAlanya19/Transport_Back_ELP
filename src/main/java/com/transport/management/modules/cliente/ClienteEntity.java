package com.transport.management.modules.cliente;

import com.transport.management.modules.usuario.UsuarioEntity;
import com.transport.management.utils.abtractBase.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
public class ClienteEntity extends BaseEntity {

  @Column(nullable = false, length = 8)
  private String dni;

  @Column(nullable = false, length = 100)
  private String nombres;

  @Column(nullable = false, length = 100)
  private String apellidos;

  @Column(unique = true, length = 100)
  private String email;

  @Column(length = 15)
  private String telefono;

  @Column(length = 255)
  private String direccion;

  @ManyToOne
  @JoinColumn(name = "creado_por")
  private UsuarioEntity creadoPor;
}
