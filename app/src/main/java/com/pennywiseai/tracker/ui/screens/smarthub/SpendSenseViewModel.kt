package com.pennywiseai.tracker.ui.screens.smarthub

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pennywiseai.tracker.data.repository.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import java.math.BigDecimal
import javax.inject.Inject

@HiltViewModel
class SpendSenseViewModel @Inject constructor(
    private val transactionRepository: TransactionRepository
) : ViewModel() {

    val currentMonth = transactionRepository.getCurrentMonthBreakdown()
    val lastMonth = transactionRepository.getLastMonthBreakdown()

    val uiState = combine(
        currentMonth,
        lastMonth
    ) { current, last ->

        SpendSenseUiState(
            incomeThisMonth = current.income,
            incomeLastMonth = last.income,

            expenseThisMonth = current.expenses,
            expenseLastMonth = last.expenses,

            savingsThisMonth = current.total,
            savingsLastMonth = last.total
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = SpendSenseUiState.EMPTY
    )
}

data class SpendSenseUiState(
    val incomeThisMonth: BigDecimal,
    val incomeLastMonth: BigDecimal,
    val expenseThisMonth: BigDecimal,
    val expenseLastMonth: BigDecimal,
    val savingsThisMonth: BigDecimal,
    val savingsLastMonth: BigDecimal
) {
    companion object {
        val EMPTY = SpendSenseUiState(
            BigDecimal.ZERO,
            BigDecimal.ZERO,
            BigDecimal.ZERO,
            BigDecimal.ZERO,
            BigDecimal.ZERO,
            BigDecimal.ZERO
        )
    }
}