package com.pennywiseai.tracker.ui.screens.smarthub

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pennywiseai.tracker.ui.components.PennyWiseScaffold

@Composable
fun WalletMapScreen(
    onNavigateBack: () -> Unit
) {
    PennyWiseScaffold(
        title = "Wallet Map",
        navigationIcon = {
            IconButton(onClick = onNavigateBack) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            SummaryCard(
                title = "Monthly Overview",
                lastMonth = "September",
                thisMonth = "₹18,450",
                chipText = "+₹2,300"
            )

            SummaryCard(
                title = "Top Categories",
                lastMonth = "Food, Travel",
                thisMonth = "Shopping",
                chipText = "High Spend"
            )

            SummaryCard(
                title = "Loans & EMI",
                lastMonth = "Education Loan",
                thisMonth = "₹4,500 / month",
                chipText = "Due in 5 days"
            )
        }
    }
}