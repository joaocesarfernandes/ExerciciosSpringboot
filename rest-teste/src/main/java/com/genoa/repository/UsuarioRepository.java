package com.genoa.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.genoa.model.Usuario;

/**
 * Created by valdisnei on 24/09/16.
 */

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    @Query(value =         "SELECT * FROM USUARIO "
        + "                WHERE id = ?",nativeQuery = true)
    List<Usuario> findById(Integer id);

}
