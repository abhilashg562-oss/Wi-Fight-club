package com.pennywiseai.tracker.ui.screens.smarthub

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.Savings
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.pennywiseai.tracker.ui.components.PennyWiseScaffold
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import java.math.BigDecimal
@Composable
fun SpendSenseScreen(
    onNavigateBack: () -> Unit,
    viewModel: SpendSenseViewModel = hiltViewModel()
) {val state by viewModel.uiState.collectAsState()
    PennyWiseScaffold(
        title = "SpendSense",
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
                .padding(16.dp)
        ) {

            // Title
            Text(
                text = "Spend Sense",
                style = MaterialTheme.typography.headlineLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Last Month",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Progress Bar
            LinearProgressIndicator(
                progress = 0.65f,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp),
                color = Color(0xFF2979FF)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // INCOME CARD
            StatCard(
                icon = Icons.Filled.ArrowUpward,
                iconColor = Color(0xFF2979FF),
                title = "Income",
                lastMonth = "₹${state.incomeLastMonth}",
                thisMonth = "₹${state.incomeThisMonth}",
                badgeText = growthText(
                    state.incomeLastMonth,
                    state.incomeThisMonth),
                badgeColor = Color(0xFF2E7D32),
                description = "Income increased significantly — track where the extra amount goes."
            )

            Spacer(modifier = Modifier.height(16.dp))

            // EXPENSE CARD
            StatCard(
                icon = Icons.Filled.ArrowDownward,
                iconColor = Color(0xFFD32F2F),
                title = "Expenses",
                lastMonth = "₹${state.expenseLastMonth}",
                thisMonth = "₹${state.expenseThisMonth}",
                badgeText = growthText(
                    state.expenseLastMonth,
                    state.expenseThisMonth
                ),
                badgeColor = Color(0xFFD32F2F),
                description = "Spending dropped — excellent! Keep reducing non-essential categories."
            )

            Spacer(modifier = Modifier.height(16.dp))

            // SAVINGS CARD
            StatCard(
                icon = Icons.Filled.Savings,
                iconColor = Color(0xFF388E3C),
                title = "Savings",
                lastMonth = "₹${state.savingsLastMonth}",
                thisMonth = "₹${state.savingsThisMonth}",
                badgeText = growthText(
                    state.savingsLastMonth,
                    state.savingsThisMonth
                ),
                badgeColor = Color(0xFF388E3C),
                description = "Amazing improvement — your savings grew a lot."
            )

        }
    }
}

@Composable
fun StatCard(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    iconColor: Color,
    title: String,
    lastMonth: String,
    thisMonth: String,
    badgeText: String,
    badgeColor: Color,
    description: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(icon, contentDescription = null, tint = iconColor)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(title, style = MaterialTheme.typography.titleLarge)
                }

                Box(
                    modifier = Modifier
                        .background(badgeColor.copy(alpha = 0.15f), RoundedCornerShape(50))
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = badgeText,
                        color = badgeColor,
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text("Last Month: $lastMonth", style = MaterialTheme.typography.bodyMedium)
            Text(
                "This Month: $thisMonth",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFF2979FF)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
        }
    }
}
@Composable
fun SummaryCard(
    title: String,
    lastMonth: String,
    thisMonth: String,
    chipText: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1E1E1E)
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge
                )

                AssistChip(
                    onClick = {},
                    label = { Text(chipText) }
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text("Last Month", style = MaterialTheme.typography.labelMedium)
                    Text(lastMonth, style = MaterialTheme.typography.titleMedium)
                }

                Column(horizontalAlignment = Alignment.End) {
                    Text("This Month", style = MaterialTheme.typography.labelMedium)
                    Text(thisMonth, style = MaterialTheme.typography.titleMedium)
                }
            }
        }
    }
}
fun growthText(last: BigDecimal, current: BigDecimal): String {
    if (last == BigDecimal.ZERO) return "New"

    val diff = current - last
    val percent = (diff.toDouble() / last.toDouble()) * 100

    return if (percent >= 0) {
        "+${percent.toInt()}% Growth"
    } else {
        "${percent.toInt()}% Reduced"
    }
}