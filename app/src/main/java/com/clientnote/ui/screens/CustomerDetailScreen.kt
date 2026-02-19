package com.clientnote.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.clientnote.data.CopierUi
import com.clientnote.data.CustomerUi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomerDetailScreen(
    customer: CustomerUi,
    copiers: List<CopierUi>,
    onBack: () -> Unit,
    onClickCopier: (CopierUi) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(customer.name) },
                navigationIcon = { Text("←", modifier = Modifier.padding(horizontal = 16.dp).clickable(onClick = onBack)) }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Card(modifier = Modifier.fillMaxWidth().padding(top = innerPadding.calculateTopPadding())) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text("연락처: ${customer.phone}", style = MaterialTheme.typography.bodyMedium)
                        Text("주소: ${customer.address}", style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }

            item {
                Text("등록된 복사기", style = MaterialTheme.typography.titleMedium)
            }

            items(copiers) { copier ->
                Card(modifier = Modifier.fillMaxWidth().clickable { onClickCopier(copier) }) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text("${copier.brand} ${copier.model}", style = MaterialTheme.typography.titleSmall)
                        Text("S/N ${copier.serial}", style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
    }
}
