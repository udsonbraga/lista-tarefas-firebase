// SalvarTarefa.kt
package com.example.listatarefas.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.listadetarefas.model.Tarefa
import com.example.listatarefas.repositorio.TarefasRepositorio

@Composable
fun SalvarTarefaScreen(navController: NavController) {
    var titulo by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }
    var local by remember { mutableStateOf("") }
    var prioridade by remember { mutableStateOf("Baixa") }
    val repo = TarefasRepositorio()

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(value = titulo, onValueChange = { titulo = it }, label = { Text("Título da tarefa") })
        OutlinedTextField(value = descricao, onValueChange = { descricao = it }, label = { Text("Descrição") })
        OutlinedTextField(value = local, onValueChange = { local = it }, label = { Text("Local") })

        Text("Prioridade", style = MaterialTheme.typography.titleMedium)
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(selected = prioridade == "Alta", onClick = { prioridade = "Alta" })
                Text("Alta")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(selected = prioridade == "Média", onClick = { prioridade = "Média" })
                Text("Média")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(selected = prioridade == "Baixa", onClick = { prioridade = "Baixa" })
                Text("Baixa")
            }
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = { navController.popBackStack() }, colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)) {
                Text("Cancelar")
            }
            Button(onClick = {
                val tarefa = Tarefa(titulo = titulo, descricao = descricao, local = local, prioridade = prioridade)
                repo.salvarTarefa(tarefa,
                    onSuccess = {
                        navController.navigate("lista") {
                            popUpTo("salvar") { inclusive = true }
                        }
                    },
                    onFailure = {
                        // Lógica de erro
                    }
                )
            }) {
                Text("Salvar")
            }
        }
    }
}
