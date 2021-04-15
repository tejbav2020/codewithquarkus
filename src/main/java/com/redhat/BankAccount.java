/**
 * 
 */
package com.redhat;

import java.math.BigDecimal;

/**
 * @author tebavish
 *
 */
public class BankAccount {

	public BankAccount() {
		
	}
	
	public BankAccount(String name, String accountNumber, String address, BigDecimal currentBalance) {
		this.name = name;
		this.accountNumber = accountNumber;
		this.address = address;
		this.currentBalance = currentBalance;
	}
	
	private String name;
	private String accountNumber;
	private String address;
	private BigDecimal currentBalance;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(BigDecimal currentBalance) {
		this.currentBalance = currentBalance;
	}
	
	@Override
	public String toString() {
		return "BankAccount [name=" + name + ", accountNumber=" + accountNumber + ", address=" + address
				+ ", currentBalance=" + currentBalance + "]";
	}
	
	
	
}
