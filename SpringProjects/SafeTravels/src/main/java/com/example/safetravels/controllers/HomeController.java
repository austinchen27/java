package com.example.safetravels.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.safetravels.models.Expense;
import com.example.safetravels.services.ExpenseService;

@Controller
public class HomeController {
	
	@Autowired
	private ExpenseService expenseService;
	
	@RequestMapping("/expenses") // Creating the box
	public String index(Model model) {
		Expense newExpense = new Expense();
		model.addAttribute("newExpense", newExpense); // Adding in parameters +
		model.addAttribute("allExpenses", expenseService.allExpenses()); // + Displaying JSP
		return "index.jsp";
		}
	
	@PostMapping("/expenses/create") // Post Method from JSP form
	public String create(@Valid @ModelAttribute("newExpense") Expense expense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("allExpenses", expenseService.allExpenses()); // + Display JSP if errors
			return "index.jsp";
		}
		expenseService.createExpense(expense);  // Calling function to create
		
		return "redirect:/expenses";
	}
	
	@RequestMapping("/expenses/edit/{id}") // Edit Expense
	public String edit(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}
	
	@PutMapping("expenses/edit/{id}") // Update Expense (use PUT for edit/update, POST creates new)
	public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			expenseService.updateExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	@DeleteMapping("expenses/delete/{id}") // Delete Expense (emphasis on security)
	public String deleteExpense(@PathVariable("id") Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/expenses";
	}
	
	@RequestMapping("/expenses/show/{id}") // Show Expense
	public String showOneExpense(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "showone.jsp";
	}


	}
