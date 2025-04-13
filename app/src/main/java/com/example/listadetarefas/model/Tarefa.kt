package com.example.listadetarefas.model

data class Tarefa(
    val id: String ="",
    val titulo: String ="",
    val descricao: String = "",
    val local: String = "",
    val prioridade: String = ""
)