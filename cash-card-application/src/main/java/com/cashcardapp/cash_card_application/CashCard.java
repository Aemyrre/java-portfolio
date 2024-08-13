package com.cashcardapp.cash_card_application;

import org.springframework.data.annotation.Id;

public record CashCard(@Id Long id, Double amount, String owner) {
}
