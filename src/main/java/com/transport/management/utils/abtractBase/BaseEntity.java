package com.transport.management.utils.abtractBase;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;

  @Column(updatable = false, name = "created_at")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  protected Date creadoEn;

  @Column(name = "updated_at")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  protected Date actualizadoEn;

  @PrePersist
  protected void onCreate() {
    this.creadoEn = new Date();
    this.actualizadoEn = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
    this.actualizadoEn = new Date();
  }
}
