package com.src.prj.service;

import java.util.*;
import java.util.Map.Entry;

import com.src.prj.model.Amount;
import com.src.prj.model.BalanceMap;
import com.src.prj.model.Expense;
import com.src.prj.model.PaymentGraph;
import static com.src.prj.model.Currency.*;

public class ExpenseService {
	
	private final Map<String, List<Expense>> groupExpense;
	
	public ExpenseService() {
		this.groupExpense = new HashMap<String, List<Expense>>();
	}
	
	public void addExpense(Expense expense) {
		final String groupId = expense.getGroupId();
		if(groupId != null) {
			groupExpense.putIfAbsent(groupId, new ArrayList<Expense>());
			groupExpense.get(groupId).add(expense);
		}
	}
	
	public List<Expense> getGroupExpense(String groupId) {
		return groupExpense.get(groupId);
	}
	
	public PaymentGraph getPaymentGraph(BalanceMap groupBalances) {
		final Comparator <Map.Entry<String, Amount>> ascending = Comparator.comparingDouble(balance -> balance.getValue().getAmount());
		final PriorityQueue<Map.Entry<String, Amount>> 
			positiveAmounts = new PriorityQueue<Map.Entry<String,Amount>>(ascending.reversed()),
			negativeAmounts = new PriorityQueue<Map.Entry<String,Amount>>(ascending);
		for (Map.Entry<String, Amount> balance : groupBalances.getBalances().entrySet()) {
			if(balance.getValue().getAmount() > 0) {
				positiveAmounts.add(balance);
			} else {
				negativeAmounts.add(balance);
			}
		}
		
		final Map<String, BalanceMap> graph = new HashMap<String, BalanceMap>();
		while(!positiveAmounts.isEmpty()) {
			final Entry<String, Amount> largestPositive = positiveAmounts.poll();
			final Entry<String, Amount> largestNegative = negativeAmounts.poll();
			final double positiveAmount = largestPositive.getValue().getAmount();
			final double negativeAmount = largestNegative.getValue().getAmount();
			graph.putIfAbsent(largestPositive.getKey(), new BalanceMap());
			graph.get(largestPositive.getKey()).getBalances().put(largestNegative.getKey(), new Amount(INR, Math.min(positiveAmount, negativeAmount)));
			double remaining = positiveAmount - negativeAmount;
			final Amount remainingAmount = new Amount(INR, remaining);
			if (remaining > 0) {
                positiveAmounts.add(new AbstractMap.SimpleEntry<>(largestPositive.getKey(), remainingAmount));
            } else if (remaining < 0) {
                negativeAmounts.add(new AbstractMap.SimpleEntry<>(largestNegative.getKey(), remainingAmount));
            }
        }
        return new PaymentGraph(graph);
    }
	
}
