package com.codandosimples.repository;

import com.codandosimples.domain.Expense;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {


}
