package com.desafioMagzineLuiza.BackendDeveloper.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.desafioMagzineLuiza.BackendDeveloper.entity.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem,Long> {
    

    @Query(value ="SELECT * FROM db_mensagem WHERE status = 1",nativeQuery = true)
    List<Mensagem> findByMensagemEspera();

}
