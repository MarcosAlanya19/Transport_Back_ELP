package com.transport.management.modules.usuario;

import com.transport.management.utils.abtractBase.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends BaseRepository<UsuarioEntity> {
    Optional<UsuarioEntity> findByEmail(String email);
}
