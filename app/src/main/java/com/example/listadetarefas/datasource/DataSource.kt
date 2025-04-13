package com.example.listadetarefas.datasource

class DataSource{

    private val db = FirebaseFirestore.getInstance()
    fun salvarTarefa(tarefa: String, descricao: String, prioridade: Int){

        val tarefaMap = hashMapOf(
            "tarefa" to tarefa,
            "descricao" to descricao,
            "prioridade" to prioridade

        )
        db.collection("tarefas").documento(tarefa).set(tarefaMap).addOnCompleteListener{

        }.addOnFailureListener{

        }

    }
}