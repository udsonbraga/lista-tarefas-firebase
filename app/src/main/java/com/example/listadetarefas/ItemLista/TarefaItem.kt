package com.example.listadetarefas.ItemLista

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.listadetarefas.ui.theme.White
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.listadetarefas.R
import com.example.listadetarefas.ui.theme.Radio_Button_Green_Selected
import com.example.listadetarefas.ui.theme.Radio_Button_Red_Selected
import com.example.listadetarefas.ui.theme.Radio_Button_Yellow_Selected
import com.example.listadetarefas.ui.theme.ShapeCardPrioridade
import com.example.listadetarefas.view.ListaTarefas

fun Card(colors: Color, modifier: Modifier, content: @Composable ColumnScope.() -> Unit) {

}

@Composable
fun TarefaItem(
    position:Int,
    listaTarefas: MutableList<Tarefa>
){
    val tituloTarefa = listaTarefas[position].tarefa
    val descricaoTarefa = listaTarefas[position].descricao
    val prioridade = listaTarefas[position].prioridade

    val nivelDePrioridade:String = when(prioridade){
        0 -> {
             "sem prioridade"
    }
        1 ->{
            "Prioridade Baixa"}
        2 ->{
            "Prioridade Media" }
        else -> {
            "Prioridade Alta" }

    }

    val color = when(prioridade){
        0 -> {
            Color.Black
        }
        1 -> {
            Radio_Button_Green_Selected
        }
        2 ->{
            Radio_Button_Yellow_Selected
        }
        else ->{
            Radio_Button_Red_Selected
        }
    }
    Card(
        colors = White,
        modifier = Modifier.fillMaxWidth().padding(10.dp)
    ){
        ConstraintLayout (
            modifier = Modifier.padding(20.dp)
        ){
            val (txtTitulo, txtDescricao,cardPrioridade,txtPrioridade,btDeletar) = createRefs()

            Text(
                text = tituloTarefa.toString(),
                modifier = Modifier.constrainAs(txtTitulo){
                    top.linkTo(parent.top, margin =10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )
            if (descricaoTarefa != null) { //modificado
                Text(
                    text = descricaoTarefa,
                    modifier = Modifier.constrainAs(txtDescricao){
                        top.linkTo(txtTitulo.bottom, margin =10.dp)
                        start.linkTo(parent.start, margin = 10.dp)
                    }
                )
            }
            Text(
                text = nivelDePrioridade,
                modifier = Modifier.constrainAs(txtPrioridade){
                    top.linkTo(txtDescricao.bottom, margin =10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                }
            )


            Card(backgroundColor = color
                        .size (30.dp)
                    .constrainAS(cardPrioridade) {
                        top.linkTo(txtDescricao.bottom, margin = 10.dp)
                        start.linkTo(txtPrioridade, margin = 10.dp)
                        bottom.linkTo(parent.botton, margin = 10.dp)
                    }, shape = ShapeCardPrioridade.large) {

            }
            IconButton(
                onClick = {

                },
                modifier = Modifier.constrainAs(btDeletar){
                    top.linkTo(txtDescricao.bottom, margin = 10.dp)
                    start.linkTo(cardPrioridade.end, margin = 10.dp)
                    top.linkTo(txtDescricao.bottom, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)

                }
            ){
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_delete) ,
                    contentDescription = null)
            }
        }

    }
}