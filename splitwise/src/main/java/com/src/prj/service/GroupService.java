package com.src.prj.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.src.prj.model.Amount;
import com.src.prj.model.BalanceMap;
import com.src.prj.model.Currency;
import com.src.prj.model.Expense;
import com.src.prj.model.Group;
import com.src.prj.model.PaymentGraph;

public class GroupService {
	public static final Amount NIL = new Amount(Currency.INR, 0);
	private final ExpenseService expenseService;
	private final Map<String, Group> groups;
	
	public GroupService(ExpenseService expenseService, Map<String, Group> groups) {
		// TODO Auto-generated constructor stub
		this.expenseService = expenseService;
		this.groups = groups;
	}
	
	public PaymentGraph getGroupPaymentGraph(final String groupId, final String userId) throws IllegalAccessException {
		return expenseService.getPaymentGraph(getBalances(groupId, userId));
	}

	private BalanceMap getBalances(String groupId, String userId) throws IllegalAccessException {
		// TODO Auto-generated method stub
		if (!groups.get(groupId).getUsers().contains(userId)) {
			throw new IllegalAccessException();
		}
		return sumExpenses(expenseService.getGroupExpense(groupId));
	}

	private BalanceMap sumExpenses(List<Expense> groupExpense) {
		// TODO Auto-generated method stub
		final Map<String, Amount> resultBalances = new HashMap<String, Amount>();
		for (Expense expense : groupExpense) {
			for (Map.Entry<String, Amount> balance : expense.getUserBalances().getBalances().entrySet()) {
				final String user = balance.getKey();
				final Amount amount = balance.getValue();
				resultBalances.put(user, resultBalances.getOrDefault(user, NIL).add(amount));
			}
		}
		return  new BalanceMap(resultBalances);
	}
	
}
