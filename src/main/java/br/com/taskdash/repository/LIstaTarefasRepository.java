package br.com.taskdash.repository;

import br.com.taskdash.model.ListaTarefas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LIstaTarefasRepository  extends JpaRepository<ListaTarefas, Long> {

    java.util.List<ListaTarefas> findByStatus(br.com.taskdash.model.Status status);

}
