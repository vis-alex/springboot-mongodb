package alex.vis.springbootmongodb.service;

import alex.vis.springbootmongodb.model.Expense;
import alex.vis.springbootmongodb.repository.ExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public void addExpense(Expense expense){
        //Метод для вставки сущности документ в монго дб
        expenseRepository.insert(expense);
    }

    public void updateExpense(Expense expense){
        Expense savedExpense = expenseRepository.findById(expense.getId()).orElseThrow(
                () -> new RuntimeException(String.format("Cannot find expense by ID %s", expense.getId()))
        );

        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());
        savedExpense.setExpenseAmount(expense.getExpenseAmount());

        expenseRepository.save(savedExpense);
    }

    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    }

    public Expense getExpenseByName(String name){
        return expenseRepository.findByName(name).orElseThrow(
                () -> new RuntimeException(String.format("Cannot find expense by name %s", name))
        );
    }

    public void deleteExpense(String id){
        expenseRepository.deleteById(id);
    }
}
