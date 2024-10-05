package com.sercan.yigit.pokemonlist.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sercan.yigit.common.utils.ColorBackground
import com.sercan.yigit.common.utils.ColorTextFieldContainerDefault
import com.sercan.yigit.common.utils.ColorTextFieldText
import com.sercan.yigit.common.utils.ColorTextTitle
import com.sercan.yigit.pokemonlist.presentation.screen.PokemonViewModel

@Composable
fun TopBarComponent(viewModel: PokemonViewModel, query: State<String>){
    Column(
        modifier = Modifier
            .background(color = ColorBackground)
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp)
    ) {
        Text(
            text = "Pokédex",
            color = ColorTextTitle,
            modifier = Modifier
                .padding(top = 20.dp),
            fontWeight = FontWeight.Bold,
            style = typography.headlineMedium
        )
        Row(
            modifier = Modifier
                .height(IntrinsicSize.Min)
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
        ) {
            TextField(
                modifier = Modifier.weight(4f),
                value = query.value,
                onValueChange = {
                    viewModel.setQuery(it)
                },
                colors = TextFieldDefaults.colors(
                    unfocusedTextColor = ColorTextFieldText,
                    focusedContainerColor = ColorTextFieldContainerDefault,
                    unfocusedContainerColor = ColorTextFieldContainerDefault,
                    disabledContainerColor = ColorTextFieldContainerDefault,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                ),
                shape = RoundedCornerShape(12.dp),
                singleLine = true,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                },
                placeholder = { Text(text = "Arama yap...") }
            )
        }
    }
}