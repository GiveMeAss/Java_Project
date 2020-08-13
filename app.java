package Project2;

/*Automated Teller Machine */

import java.util.*;

public class app {
	public static void main(String[] args) 
	{		
		Scanner s = new Scanner(System.in);
		
		HashMap<Integer, Integer> customer = new HashMap<>();
		HashMap<Integer, Float> each_customer = new HashMap<>();
		
		while(true) 
		{
			System.out.println("----------------------------------------------\n");
			System.out.println("Press 1 to login");
			System.out.println("Press 2 to generate Pin");
			System.out.println("Press 3 to Change Pin");
			System.out.println("Press 4 to exit\n");
			System.out.println("----------------------------------------------");
		
			int x = s.nextInt();
			
			switch(x) 
			{
				case 1:
				{
					System.out.println("Enter Account Number: ");
					int Acc_number = s.nextInt();
					if(customer.containsKey(Acc_number))
					{
						int pin = customer.get(Acc_number);
						System.out.println("Enter pin: ");
						int getpin = s.nextInt(); 
						if(pin == getpin) 
						{
							while(true) 
							{
								System.out.println("----------------------------------------------\n");
								System.out.println("Press 5 to Deposit Money");
								System.out.println("Press 6 to Withdraw Money");
								System.out.println("Press 7 to Check Balance");
								System.out.println("Press 9 to exit\n");
								System.out.println("----------------------------------------------");
								
								int y = s.nextInt();
								
								switch(y) 
								{
									case 5:
									{
										System.out.println("how much money you want to deposit? ");
										float depmoney = s.nextInt();
										float totalmoney = each_customer.get(Acc_number) + depmoney;
										each_customer.replace(Acc_number, totalmoney);
										System.out.println("money added!");
										break;
									}
									case 6:
									{
										if(each_customer.get(Acc_number) == 0)
											{
												System.out.println("Nothing to withdraw");
												break;
											}
											else 
											{
												System.out.println("How much you want to withdraw?");
												float withdrawmoney = s.nextInt();
												if(withdrawmoney < each_customer.get(Acc_number)) 
												{
													float totalmoney = each_customer.get(Acc_number) - withdrawmoney;
													each_customer.replace(Acc_number, totalmoney); 
													System.out.println("Cash withdrawned!");
													break;
												}
												else
												{
													System.out.println("Not enough cash");
													break;
												}
											}
									}
									case 7:
									{
										System.out.println("Total balance in your account number("+Acc_number+") is: " + each_customer.get(Acc_number));
										break;	
									}
								}
								if(y == 9)
									break;
							}
							break;
						}
						else 
						{
							System.out.println("Wrong pin entered!");
							break;
						}
					}
					else 
					{
						System.out.println("Account Number not registered");
						break;
					}
				}
				case 2:
				{
					System.out.println("Enter Account Number: ");
					int Acc_number = s.nextInt();
					if(customer.containsKey(Acc_number))
					{
						System.out.println("Account already registered");
						break;
					}
					else 
					{
						System.out.println("Enter pin: ");
						int pin = s.nextInt();
						customer.put(Acc_number, pin);
						each_customer.put(Acc_number, (float) 0.0);
						System.out.println("Pin generation successful!");
						System.out.println("before login change your pin, it is adviced.");
						break;
					}
				}
				case 3:
				{
					System.out.println("Enter Account Number: ");
					int Acc_number = s.nextInt();
					if(customer.containsKey(Acc_number))
					{
						int pin = customer.get(Acc_number);
						System.out.println("Enter old pin: ");
						int getpin = s.nextInt(); 
						if(pin == getpin) 
						{
							System.out.println("Enter new pin: ");
							int newpin = s.nextInt();
							customer.replace(Acc_number, newpin);
							System.out.println("pin changed!");
							break;
						}
						else 
						{
							System.out.println("Wrong pin entered!");
							break;
						}
					}
					else 
					{
						System.out.println("Account Number not registered");
						break;
					}
				}
			}
			if(x == 4)
				break;
		}
	} 
}
