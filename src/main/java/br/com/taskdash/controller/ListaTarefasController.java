package br.com.taskdash.controller;

import br.com.taskdash.model.ListaTarefas;
import br.com.taskdash.service.ListatarefasService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
@CrossOrigin(
        origins = "https://savio018.github.io",      // libera só seu frontend
        allowedHeaders = "*",
        methods = {
                RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.OPTIONS
        }
)
public class ListaTarefasController {

    private final ListatarefasService service;

    public ListaTarefasController(ListatarefasService service) {
        this.service = service;
    }

    @GetMapping
    public List<ListaTarefas> listarTodas() {
        return service.listarTodas();
    }

    @PostMapping
    public ListaTarefas criarTarefa(@RequestBody ListaTarefas tarefa) {
        return service.criarTarefa(tarefa);
    }

    @PutMapping("/{id}/concluir")
    public ListaTarefas concluirTarefa(@PathVariable Long id) {
        return service.concluirTarefa(id);
    }

    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable Long id) {
        service.excluirTarefa(id);
    }
}



