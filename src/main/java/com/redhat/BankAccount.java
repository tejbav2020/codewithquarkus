/**
 * 
 */
package com.redhat;

import java.math.BigDecimal;

/**
 * @author tebavish - Test WebHook for CI / CD For New Approach
 *
 */
public class BankAccount {

	public BankAccount() {
		
	}
	
	public BankAccount(String name, String accountNumber, String address, BigDecimal currentBalance, String accountType) {
		this.name = name;
		this.accountNumber = accountNumber;
		this.address = address;
		this.currentBalance = currentBalance;
		this.accountType = accountType;
	}
	
	private String name;
	private String accountNumber;
	private String address;
	private BigDecimal currentBalance;
	private String accountType;
	
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
	
		
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "BankAccount [name=" + name + ", accountNumber=" + accountNumber + ", address=" + address
				+ ", currentBalance=" + currentBalance + ", accountType=" + accountType + "]";
	}
	
}
