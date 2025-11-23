package br.com.taskdash.service;


import br.com.taskdash.model.ListaTarefas;
import br.com.taskdash.model.Status;
import br.com.taskdash.repository.LIstaTarefasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListatarefasService {

    private final LIstaTarefasRepository repository;


    public ListatarefasService(LIstaTarefasRepository repository) {
        this.repository = repository;
    }

    public ListaTarefas criarTarefa(ListaTarefas tarefa) {

        tarefa.setStatus(Status.PENDENTE);
        return repository.save(tarefa);
    }

    public List<ListaTarefas> listarTodas() {
        return repository.findAll();
    }
    public List<ListaTarefas> listarTodasPorStatus(Status status) {
        return repository.findByStatus(status);
    }

    public void excluirTarefa(Long id) {
        repository.deleteById(id);
    }

    public ListaTarefas concluirTarefa(Long id) {
        return repository.findById(id).map(tarefa -> {
            tarefa.setStatus(Status.CONCLUIDAS);
            return repository.save(tarefa);
        }).orElse(null);
    }
}
