package com.example.listadetarefas.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
//import com.example.listatarefas.model.Tarefa
import com.example.listatarefas.repositorio.TarefasRepositorio


@Composable
fun ListaTarefasScreen() {
    val repo = remember { TarefasRepositorio() }
    var tarefas by remember { mutableStateOf(listOf<Tarefa>()) }

    LaunchedEffect(Unit) {
        repo.listarTarefas { tarefas = it }
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Lista de tarefas", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(tarefas.size) { index ->
                val tarefa = tarefas[index]
                Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text("${tarefa.titulo} - Prioridade: ${tarefa.prioridade}")
                        Text(tarefa.descricao)
                    }
                }
            }
        }
    }
}


