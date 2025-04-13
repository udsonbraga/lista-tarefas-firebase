package com.example.listatarefas.repositorio

import com.example.listadetarefas.model.Tarefa
import com.google.firebase.firestore.FirebaseFirestore

class TarefasRepositorio {
    private val db = FirebaseFirestore.getInstance()

    fun salvarTarefa(tarefa: Tarefa, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        db.collection("tarefas")
            .add(tarefa)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { onFailure(it) }
    }

    fun listarTarefas(onSuccess: (List<Tarefa>) -> Unit) {
        db.collection("tarefas").get().addOnSuccessListener { result ->
            val lista = result.map { it.toObject(Tarefa::class.java).copy(id = it.id) }
            onSuccess(lista)
        }
    }
}