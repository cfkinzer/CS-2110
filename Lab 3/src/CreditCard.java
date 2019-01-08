//Defines a credit card
//NEEDS MODIFICATION

public class CreditCard
{
	private Money balance;		//the current balance
	private Money creditLimit;	//the approved credit limit
	private Person owner;		//the owner of the credit card

	//Constructor creates a credit card for the Person parameter
	//with an approved credit limit of the Money parameter
	//and sets the balance to a Money amount of zero 
	public CreditCard(Person newCardholder, Money limit) 
	{
		owner = newCardholder;
		creditLimit = limit;
		balance = new Money(0);
	}

	//Accessor method returns the balance
	public Money getBalance()
	{
		Money m = new Money(balance);
		return m;
	}

	//Accessor method returns the credit limit
	public Money getCreditLimit()
	{
		Money c = new Money(creditLimit);
		return creditLimit;
	}

	//Accessor method returns information about the owner
	public String getPersonals()
	{
		return owner.toString();
	}
	
	//Method to make a charge to the credit card (but only if
	//the credit limit will not be exceeded)
	public void charge(Money amount)
	{
		if(creditLimit.compareTo(amount) == -1) {
			System.out.println("Error: charge exceeds credit limit.");
		}
		if(creditLimit.compareTo(amount) > -1) {
			balance = balance.add(amount);
			creditLimit = creditLimit.subtract(amount);
		}
	}

	//Method to make a payment to the credit card
	public void payment(Money amount)
	{
		balance = balance.subtract(amount);
	}		
}