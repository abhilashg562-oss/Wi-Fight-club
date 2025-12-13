package com.pennywiseai.tracker.ui.screens.smarthub

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pennywiseai.tracker.ui.components.PennyWiseScaffold

@Composable
fun MoneyBuddyScreen(
    onNavigateBack: () -> Unit
) {
    PennyWiseScaffold(
        title = "Money Buddy",
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
                title = "Leak Summary",
                lastMonth = "₹20,000",
                thisMonth = "₹18,000",
                chipText = "-37.5% Reduced"
            )

            SummaryCard(
                title = "Savings Simulation",
                lastMonth = "Save 25%",
                thisMonth = "₹1,250",
                chipText = "Potential Savings"
            )

            SummaryCard(
                title = "Smart Tips",
                lastMonth = "Auto detect leaks",
                thisMonth = "SMS based insights",
                chipText = "AI Powered"
            )
        }
    }
}