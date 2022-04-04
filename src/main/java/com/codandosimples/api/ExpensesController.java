package com.codandosimples.api;

import com.codandosimples.domain.Expense;
import com.codandosimples.repository.ExpenseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class ExpensesController {

	private ExpenseRepository expenseRepository;

	public ExpensesController(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}

	@GetMapping("/expenses")
	public List<Expense> findAll() {
		return StreamSupport.stream(expenseRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}

	@GetMapping("/expenses/{id}")
	public Expense findById(@PathVariable("id") Long id) {
		return expenseRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/expenses")
	public Expense save(@Valid @RequestBody Expense expense) {
		return expenseRepository.save(expense);
	}

	@PutMapping("/expenses/{id}")
	public Expense update(@Valid @RequestBody Expense expense, @PathVariable("id") Long id) {
		findById(id);
		expense.setId(id);

		return expenseRepository.save(expense);
	}
}
