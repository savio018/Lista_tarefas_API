package br.com.taskdash.model;



import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Locale;

@Entity
@Table(name = "tarefas")
public class ListaTarefas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private LocalDate data;


    @Enumerated(EnumType.STRING)
    private Status status;

public ListaTarefas(String nome,String descricao, LocalDate data) {

    this.nome = nome;
    this.descricao = descricao;
    this.data = data;
    this.status = Status.PENDENTE;
}

public ListaTarefas() {}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
    return nome;
    }

    public void setNome(String nome) {
    this.nome = nome;
    }
    public String getDescricao() {
    return descricao;
    }
    public void setDescricao(String descricao) {
    this.descricao = descricao;
    }
    public LocalDate getData() {
    return data;
    }
    public void setData(LocalDate data) {
    this.data = data;
    }
    public Status getStatus() {
    return status;
    }

    public void setStatus(Status status) {
    this.status = status;
    }
}
