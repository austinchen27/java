package com.example.safetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.safetravels.models.Expense;
import com.example.safetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	// Returns all the Expenses
	public List<Expense> allExpenses() {
		return expenseRepository.findAll();
	}
	
	// Creates an Expense
	public Expense createExpense(Expense expense) {
		return expenseRepository.save(expense); 
	}
	
	// Update an Expense (edit)
	public Expense updateExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	// Delete an Expense
	public void deleteExpense(Long id) {
		expenseRepository.deleteById(id);
	}
	
	// Retrieves an Expense
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}
	
	
}
