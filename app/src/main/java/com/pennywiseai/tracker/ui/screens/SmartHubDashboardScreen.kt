


package com.pennywiseai.tracker.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.QueryStats
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pennywiseai.tracker.navigation.MoneyBuddy
import com.pennywiseai.tracker.navigation.SpendSense
import com.pennywiseai.tracker.navigation.WalletMap


@Composable
fun SmartHubDashboardScreen(
    navController: NavController,
    rootNavController: NavController? = null
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp, bottom = 80.dp), // Extra padding to avoid bottom navigation
        verticalArrangement = Arrangement.spacedBy(12.dp), // 12dp spacing between blocks
        horizontalAlignment = Alignment.Start
    ) {

        // Spend Sense Block - Equal height with weight
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f) // Equal height distribution
                .clickable { rootNavController?.navigate(SpendSense) }
                .shadow(
                    elevation = 8.dp,
                    spotColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
                    ambientColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.05f)
                ),
            shape = MaterialTheme.shapes.large,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                // Large dominant icon
                Icon(
                    imageVector = Icons.Default.QueryStats,
                    contentDescription = null,
                    modifier = Modifier.size(56.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
                
                Spacer(modifier = Modifier.width(20.dp))
                
                // Content area
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "SpendSense",
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Compare this month vs last month income, expenses and savings in one view. See trends and get simple messages about your money flow.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        // Money Buddy Block - Equal height with weight
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f) // Equal height distribution
                .clickable { rootNavController?.navigate(MoneyBuddy) }
                .shadow(
                    elevation = 8.dp,
                    spotColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
                    ambientColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.05f)
                ),
            shape = MaterialTheme.shapes.large,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                // Large dominant icon
                Icon(
                    imageVector = Icons.Default.AccountBalanceWallet,
                    contentDescription = null,
                    modifier = Modifier.size(56.dp),
                    tint = MaterialTheme.colorScheme.secondary
                )
                
                Spacer(modifier = Modifier.width(20.dp))
                
                // Content area
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "MoneyBuddy",
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Find small daily money leaks and see how much you can save by reducing them.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        // Wallet Map Block - Equal height with weight
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f) // Equal height distribution
                .clickable { rootNavController?.navigate(WalletMap) }
                .shadow(
                    elevation = 8.dp,
                    spotColor = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.1f),
                    ambientColor = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.05f)
                ),
            shape = MaterialTheme.shapes.large,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                // Large dominant icon
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null,
                    modifier = Modifier.size(56.dp),
                    tint = MaterialTheme.colorScheme.tertiary
                )
                
                Spacer(modifier = Modifier.width(20.dp))
                
                // Content area
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "WalletMap",
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "View monthly spending split into categories like bills, food, travel, recharge and subscriptions.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}
