package gwg.bankapplication.module;
import java.util.*;
import java.util.Date;
import java.text.*;
import java.util.regex.Pattern;
public class BankApp{
public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    Bank myBank = new Bank();
    boolean flag = false;
    int user_choice = 2;
    boolean val_flag=false;
    int d=0;

    do {
        //display menu to user
        System.out.println();
        System.out.println("PLease Select An Item:");
        System.out.println("1) Personal Customer");
        System.out.println("2) Commercial Customer");
        System.out.println("3) Deposit to a bank account");
        System.out.println("4) Withdraw from bank account");
        System.out.println("5) Display Customer with Transaction");
        System.out.println("6) Display total amount in bank");
        System.out.println("7) Exit");
        System.out.println();
        System.out.print("Enter choice [1-7]: ");
        
                try 
                {        
                	user_choice = s.nextInt();
                }
                catch (Exception e){
                System.out.println("Invalid option. Please try again.");
                s.next();
                continue;
                }
        switch (user_choice){
            case 1: System.out.println("Enter a customer name");
                    s.skip("[\r\n]+");
                    String cn = s.nextLine();
                    if(Pattern.matches("[a-zA-Z]+", cn)==false || cn.length()<=2)
                    {
                    	do{
                    			System.out.println("Enter a Valid customer name");
                    			cn = s.nextLine();
                    			if(Pattern.matches("[a-zA-Z]+", cn)==true && cn.length()>2)
                    				flag = true;
                        }while(flag==false);
                    }
                            
                    System.out.println("Enter address");
                    String Ad = s.nextLine();
                    flag=false;
                    if(Ad.isEmpty())
                     	{
                            	  
                    		do{
                    				System.out.println("Enter a Valid address");
                                    Ad = s.nextLine();
                                    if(!(Ad.isEmpty()))  
                                    	 flag=true;
                                     continue ;
                              }while(flag==false);
                     	}
                     System.out.println("Enter gender (M/F)");
                     String gen = s.next(); 
                     flag=false;
                     if(!(gen.equalsIgnoreCase("M") || gen.equalsIgnoreCase("F")))
                     {
                             do{
                                     System.out.println("Enter gender (M/F)");
                                     gen = s.next(); 
                                     if(gen.equalsIgnoreCase("M") || gen.equalsIgnoreCase("F"))
                                     flag = true;
                                     continue;
                             }while(flag==false);
                     }
                     System.out.println("Enter Phone Number");
                     String phno = s.next();
                     flag=false;
                     if(!phno.matches("\\d{10}" ))
                     {

                             do{
	                             System.out.println("Enter valid Phone Number");
	                             phno = s.next();
	                             if(phno.matches("\\d{10}"))
	                                     flag=true;
	                                continue;
                              	}while(flag==false);
                     }
                     flag=false;
                     System.out.println("Enter Work phone number");
                     String wph = s.next();
                     if(!wph.matches("\\d{10}" ))
                     {
                             do{
		                             System.out.println("Enter valid Phone Number");
		                             wph = s.next();
		                             if(wph.matches("\\d{10}"))
		                                     flag=true;
		                                continue;
                              	}while(flag==false);
                     }
                     System.out.println("Enter opening balance");
                     flag=false;
                     do{
                    	 try{
			                    d=s.nextInt();
			                    if(d<0)
			                    {
			                    	System.out.println("Should be positive");
			                    	do{
			                    		System.out.println("Enter valid balance");
			                    		d = s.nextInt();
			                    			if(d>0)
			                    				flag=true;                        
			                    		continue;
			                          }while(flag==false);
                	
			                    }
                    	 }catch(Exception e)
                    	 {
                    		 System.out.println("valid balance");
                    		 s.next();
                    		 continue;
                    	 }
                    	 PersonalCustomer p1=new PersonalCustomer(cn,Ad,gen,phno,wph,d);
                         String t1= "Personal";
                         System.out.println("Account was created and it has the following number: " + myBank.openNewAccount(cn, d,t1));
                         p1.pcdisplay();
                         val_flag=true;
                         continue;
                     }while(val_flag==false);
                     
                     break;
             
            case 2:  System.out.println("Enter a customer name");
                     s.skip("[\r\n]+");
                     cn = s.nextLine();
                     flag=false;
                     if(Pattern.matches("[a-zA-Z]+", cn)==false || cn.length()<=2)
                     	{
                    	 	do{
                    	 			System.out.println("Enter a Valid customer name");
							      	cn = s.nextLine();
							      	if(Pattern.matches("[a-zA-Z]+", cn)==true && cn.length()>2)
							             flag = true;
                    	 	   }while(flag==false);
                     	}
                     System.out.println("Enter address");
                     Ad = s.nextLine();
                     flag=false;
                     if(Ad.isEmpty())
                     {
                    	 do{
                    		 	System.out.println("Enter a Valid address");
                                Ad = s.nextLine();
                                if(!(Ad.isEmpty()))  
                                	flag=true;
                                continue ;
                           }while(flag==false);
                     }
                     System.out.println("Enter gender M/F");
                     gen = s.next();
                     if (!(gen.equalsIgnoreCase("M") || gen.equalsIgnoreCase("F")))                     {
                             do{
                                     System.out.println("Enter gender (M/F)");
                                     gen = s.next(); 
                                     if(gen.equalsIgnoreCase("M") || gen.equalsIgnoreCase("F"))
                                     flag = true;
                                     continue;
                             }while(flag==false);
                     }
                     System.out.println("Enter Phone Number");
                     phno = s.next();
                     flag=false;
                     if(!phno.matches("\\d{10}" ))
                     {

                             do{
                             System.out.println("Enter valid Phone Number");
                             phno = s.next();
                             if(phno.matches("\\d{10}"))
                                     flag=true;
                             continue;
                             }while(flag==false);
                     }
                     System.out.println("Enter a contact person name");
                     String cntpname = s.next();
                     flag=false;
                     if(Pattern.matches("[a-zA-Z]+", cntpname)==false || cntpname.length()<=2)
                             {
                                     do{
		                                     System.out.println("Enter a Valid customer name");
		                                     cntpname = s.next();
		                                     if(Pattern.matches("[a-zA-Z]+", cntpname)==true && cntpname.length()>2)
		                                             flag = true;
                                     }while(flag==false);
                             }
                     System.out.println("Contact person phone number");
                     String cntpNo = s.next();
                     flag=false;
                     if(!cntpNo.matches("\\d{10}" ))
                     {
                             do{
		                             System.out.println("Enter valid Phone Number");
		                             cntpNo = s.next();
		                             if(cntpNo.matches("\\d{10}"))
		                                     flag=true;
		                             continue;
                               }while(flag==false);
                     }
                        System.out.println("Enter opening balance");
                       
                        flag=false;
                        do{
	                       	 try{
				                       d=s.nextInt();
				                       if(d<0)
				                       {
				                       	System.out.println("Should be positive");
				                       		do{
						                           System.out.println("Enter valid balance");
						                           d = s.nextInt();
						                           if(d>0)
						                                   flag=true;                        
						                                   continue;
						                           }while(flag==false);
				                   	  }
	                       	 }catch(Exception e)
	                       	 {
	                       		 System.out.println("enter valid balance");
	                       		 s.next();
	                       		 continue;
	                       	 }
	                       	CommercialCustomer c1=new CommercialCustomer(cn,Ad,gen,phno,cntpname,cntpNo,d);
	                        String t2= "Commercial";
	                        System.out.println("Account was created and it has the following number: " + myBank.openNewAccount(cn, d,t2));
	                        c1.ccdisplay();                        
	                        val_flag=true;
	                            continue;
                        }while(val_flag==false);
                    break;        
            case 3: 
					int an=0;
					flag=false;
					do{
						try{
								System.out.println("Enter valid Customer ID");
								an = s.nextInt();
								if(an>0)
								{
									flag=true;
									continue;
								}
							}
							catch (Exception e){
								s.next();
								continue;
							}
					}while(flag==false);
						double da;flag=false;
						do{
							try{
									System.out.println("Enter valid amount");
									da =s.nextDouble();
										if(da<0)
										{	
											continue;
										}
										else
										{
											flag=true;
											myBank.depositTo(an, da);
											
										}
								}
							catch (Exception e){
								s.next();
								continue;
							}
						}while(flag==false);
		
		        		break;
            case 4: 
            		int acn=0;
					flag=false;
					do{
	            		try{	
		            			System.out.println("Enter valid Customer ID");
		            			acn = s.nextInt();
		            			if(acn>0)
								{
									flag=true;
									continue;
								}
							}
						catch (Exception e){
							s.next();
							continue;
						}
					}while(flag==false);
            		double wa;flag=false;
            		do{
            			try{
	            				System.out.println("Enter valid withdraw amount");
	            				wa =s.nextDouble();
								if(wa<0)
								{
									continue;
								}
								else
								{
									flag=true;
									myBank.withdrawFrom(acn, wa);
								}
            			}
            			catch (Exception e){
            				s.next();
            				continue;
            			}
            		}while(flag==false);
            		break;
           
            case 5: System.out.println("Enter a Customer ID");
            		int anum;
            		try{
						anum = s.nextInt();
						myBank.printAccountInfo(anum);
						System.out.println("Transaction Summary");
	                    BankAccount.Display(anum);
					}
					catch (Exception e){
						System.out.println("Invalid Customer ID.");
						s.next();
					continue;
					}
                    break;
           case 6: Bank.display();
                   break;
                                        
           case 7: System.exit(0);                
          default: System.out.println("Invalid option. Please try again.");

        }
}
while (user_choice != '7');
}
static class CommercialCustomer {
        String cn, Ad, gen,phno, cntpname,cntpNo; 
        int d;
        CommercialCustomer(String cn,String Ad, String gen,String phno, String cntpname,String cntpNo,int d)
        {
                this.cn=cn;
                this.Ad=Ad;
                this.gen=gen;
                this.phno=phno;
                this.cntpname=cntpname;
                this.d=d;
                this.cntpNo=cntpNo;
        }
        public void ccdisplay()
        {
                System.out.println("Name: \t"+cn);
                System.out.println("address: \t"+Ad);
                System.out.println("gender: \t"+gen);
                System.out.println("phone number: \t"+phno);
                System.out.println("contact person name: \t"+cntpname);
                System.out.println("contact person phone number: \t"+cntpNo);
                System.out.println("balance: \t"+d);
                
        }
}
static class PersonalCustomer {
        String cn, Ad, gen,phno, wph; 
        int d;
         PersonalCustomer(String cn,String Ad, String gen,String phno, String wph,int d)
        {
                this.cn=cn;
                this.Ad=Ad;
                this.gen=gen;
                this.phno=phno;
                this.wph=wph;
                this.d=d;
        }
        public void pcdisplay()
        {
                System.out.println("Name: \t"+cn);
                System.out.println("address: \t"+Ad);
                System.out.println("gender: \t"+gen);
                System.out.println("phone number: \t"+phno);
                System.out.println("work phone number: \t"+wph);
                System.out.println("balance: \t"+d);
        }
}

static class Bank {
		private BankAccount[] accounts;     
		public static ArrayList<BankAccount> BankArr=new ArrayList<BankAccount>();
		private int numOfAccounts;     
		public Bank() {
		    accounts = new BankAccount[100];
		    numOfAccounts = 0;
		    }
		public int openNewAccount(String customerName, double openingBalance, String accountType) {
		
		    BankAccount b = new BankAccount(customerName, openingBalance,accountType);
		    accounts[numOfAccounts] = b;
		        BankArr.add(b);
		    numOfAccounts++;
		    return b.getAccountNum();
		}
		public void withdrawFrom(int accountNum, double amount) {
		    for (int i =0; i<numOfAccounts; i++) {
		        if (accountNum == accounts[i].getAccountNum()  ) {
		            accounts[i].withdraw(amount,accountNum);
		            
		            return;
		        }
		    }
		    System.out.println("Customer ID not found.");
		    }
		public void depositTo(int accountNum, double amount) {
		    for (int i =0; i<numOfAccounts; i++) {
		        if (accountNum == accounts[i].getAccountNum()  ) {
		            accounts[i].deposit(amount,accountNum);
		           
		            return;
		        }
		    }
		    System.out.println("Customer ID not found.");
		}
		public void printAccountInfo(int accountNum) {
			
		    for (int i =0; i<numOfAccounts; i++) {
		                if (accountNum == accounts[i].getAccountNum()  ) {
		                    System.out.println(accounts[i].getAccountInfo());
		                    return;
		                }
		            }
		    System.out.println("Customer ID not found.");
		}
		
		public void printTransactionInfo(int accountNum) {
		    for (int i =0; i<numOfAccounts; i++) {
		                if (accountNum == accounts[i].getAccountNum()  ) {
		                    System.out.println(accounts[i].getAccountInfo());
		                    System.out.println("Last transaction: " + accounts[i].getTransactionInfo(accounts[i].getNumberOfTransactions()-1));
		                    return;
		                }
		            }
		    System.out.println("Customer ID not found.");
		}
		public void printAccountInfo(int accountNum, int n) {
		    for (int i =0; i<numOfAccounts; i++) {
		                        if (accountNum == accounts[i].getAccountNum()  ) {
		                            System.out.println(accounts[i].getAccountInfo());
		                            System.out.println(accounts[i].getTransactionInfo(n));
		                            return;
		                        }
		                    }
		    System.out.println("Customer ID not found.");
		    }
		public static void display(){
		                double sum=0.00;
		                for(BankAccount itr:BankArr){
		                                sum+=itr.balance;
		                }
		                System.out.println("The Total Amount in Bank The is: "+sum);
		}

}
static class BankAccount{

    private int accountNum;
    private String customerName;
    private double balance;
    public String accountType;
    private double[] transactions;
    private static String[] transactionsSummary;
    private static int numOfTransactions;
    private  static int noOfAccounts=0;
    Date date;
    DateFormat dateFormat;

    public String getAccountInfo(){
    	 return  "\nCustomer Name: " + customerName + "\nCustomer ID:" +accountNum + "Account Type: " +accountType+ "\nAccount number: SB510" + accountNum +"\nIFSC code: SBIN0016541 "+"\nBalance:" + balance +"\n";
    }

    public String getTransactionInfo(int n)
    {
         String transaction = transactionsSummary[n];
         if (transaction == null) {
             return "No transaction exists with that number.";
         }
         else {
             return transaction;
         }
     }
   // static String detailT="";
    public BankAccount(String abc, double xyz,String lmn){
      customerName = abc;
      balance = xyz;
      accountType= lmn;
      noOfAccounts ++;
      accountNum = noOfAccounts;
      transactions = new double[100];
      transactionsSummary = new String[100];
      transactions[0] = balance;
      dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   //get current date time with Date()
	    date = new Date();
     transactionsSummary[this.accountNum] = "Account is created with balance  " + "$" + Double.toString(balance) + " on " + "  " + dateFormat.format(date);
      numOfTransactions = 1;
    }

 public int getAccountNum(){
     return accountNum;
 }

 public int getNumberOfTransactions() {
     return numOfTransactions;
 }

 public void deposit(double amount,int accountNum){
     if (amount<0) {
         System.out.println("Amount to be deposited should be positive");
     } else {
         balance = balance + amount;
         transactions[numOfTransactions] = amount;
         transactionsSummary[accountNum]= transactionsSummary[accountNum] + "\n\t$" + Double.toString(amount) + " was deposited.\t";
			//TransactionArr.add("deposit");
         numOfTransactions++;
         System.out.println("Amount deposited successfully");
     }
 }
 public void withdraw(double amount,int accountNum)
 {
     if (amount<0){
          System.out.println("Amount to be withdrawn should be positive");
      }
     else
     {
         if (balance < amount) {
             System.out.println("Insufficient balance");
         } else {
             balance = balance - amount;
             transactions[numOfTransactions] = amount;
             transactionsSummary[accountNum] =  transactionsSummary[accountNum] + "\n\t$" + Double.toString(amount) + " was withdrawn." ;
				//TransactionArr.add("withdraw");
             numOfTransactions++;
             System.out.println("Amount withdrawn successfully");
         }
     }
 }
	public static void Display(int accountNum){
				System.out.println(accountNum + "\t"+ transactionsSummary[accountNum]);
		}
	  }
}

