package com.github.pedroluiznogueira.producer.domain;

import lombok.Data;
import lombok.Value;




public class FoodOrder {
	
    String item;
    Double amount;
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
    
    
}
