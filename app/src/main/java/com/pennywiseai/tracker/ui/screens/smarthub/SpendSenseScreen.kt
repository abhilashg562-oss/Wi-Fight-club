package com.pennywiseai.tracker.ui.screens.smarthub

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Compare
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.pennywiseai.tracker.ui.components.PennyWiseScaffold

@Composable
fun SpendSenseScreen(
    onNavigateBack: () -> Unit
) {
    PennyWiseScaffold(
        title = "SpendSense",
        navigationIcon = {
            IconButton(onClick = onNavigateBack) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Navigate back"
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
            SpendSenseBlock(
                icon = Icons.Filled.Analytics,
                title = "📊 Spend Analysis",
                description = "Get a detailed overview of your spending habits using AI-generated insights."
            )

            SpendSenseBlock(
                icon = Icons.Filled.Compare,
                title = "🔄 Comparisons",
                description = "Compare your spending across months or categories to identify areas of overspending."
            )

            SpendSenseBlock(
                icon = Icons.Filled.Lightbulb,
                title = "💡 Smart Suggestions",
                description = "AI provides personalized tips to improve your financial decisions and save more."
            )
        }
    }
}

@Composable
fun SpendSenseBlock(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    description: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
             // ❤️ THIS MAKES ALL 3 BLOCKS EQUAL HEIGHT
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(16.dp)
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}