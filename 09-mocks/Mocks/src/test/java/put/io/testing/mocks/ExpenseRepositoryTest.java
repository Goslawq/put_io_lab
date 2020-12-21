package put.io.testing.mocks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import put.io.students.fancylibrary.database.IFancyDatabase;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;


public class ExpenseRepositoryTest {
    ExpenseRepository tested = null;
    Expense expense = null;

    @BeforeEach
    private void setUp() {

    }

    @AfterEach
    private void tearDown() {

    }

    @Test
    public void loadExpansesTest() {
        tested = new ExpenseRepository(new MyDatabase());
        tested.loadExpenses();
        assertEquals(Collections.emptyList(), tested.getExpenses());
        tested = null;
    }

    @Test
    void loadExpansesTest2() {
        IFancyDatabase mock = mock(IFancyDatabase.class);
        when(mock.queryAll()).thenReturn(Collections.emptyList());
        tested = new ExpenseRepository(mock);
        tested.loadExpenses();

        InOrder inOrder = inOrder(mock);
        inOrder.verify(mock, atLeastOnce()).connect();
        inOrder.verify(mock, atLeastOnce()).queryAll();
        inOrder.verify(mock, atLeastOnce()).close();

        assertEquals(Collections.emptyList(), tested.getExpenses());
        tested = null;
    }

    @Test
    void saveExpensesTest1() {
        IFancyDatabase mock = mock(IFancyDatabase.class);
        when(mock.queryAll()).thenReturn(Collections.emptyList());
        tested = new ExpenseRepository(mock);
        expense = new Expense();
        tested.loadExpenses();

        tested.addExpense(expense);
        tested.saveExpenses();

        InOrder inOrder = inOrder(mock);
        inOrder.verify(mock).connect();
        inOrder.verify(mock).queryAll();
        inOrder.verify(mock).close();

        verify(mock).persist(expense);
        tested = null;
    }
}
