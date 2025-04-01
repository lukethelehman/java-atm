# java-atm
ATM program written in Java for CS-121
**UML**
![Alt text](images/Bank-UML.png)
**algorithm**

*Bank*
```
main()
  create Bank object b
  b.start()
  b.saveCustomers

Bank constructor
  loadCustomers()

menu()
  create Scanner input
  print the Bank Menu options
  ask for user input and store in response
  return response

start()
  create boolean keepGoing gets true
  while keepGoing is true
    call menu and store result in response
    if response equals "0"
      set keepGoing to false
    else if response equals "1"
      if adminLogin() returns true
        print "login successful"
        adminStart()
      else
        print "login unsuccessful"
    else if response equals "2"
      loginAsCustomer()
    else
      print "Error"

saveCustomers()
  try
    create FileOutputStream fo to "customers.dat"
    create ObjectOutputStream obOut for fo
    call obOut.writeObject on customers
    close obOut and fo
  catch 
    print exception message

loadCustomers()
  try
    create FileInputStream fIn for "customers.dat"
    create ObjectInputStream obIn for fIn
    read customers from obIn
    close obn and fIn

  catch 
    print exception message

fullCustomerReport()
  for each customer in customers
    call customer.getReport

addUser()
  create Scanner input
  ask for Name and store in username
  ask for PIN and store in pin
  create new Customer with username and pin
  add new Customer to customer
  saveCustomers()

applyInterest()
  for each customer in customers
    customer.savings.calcInterest()

adminStart()
  create boolean keepGoing gets true
  while keepGoing is true
    store admin.menu() in response
    if response equals "0"
      keepGoing to false
    else if response equals "1"
      fullCustomerReport()
    else if response equals "2"
      addUser()
    else if response equals "3"
      applyInterest()
    else
      print "Error"

loginAsCustomer()
  create Scanner input
  ask for username and store in username
  ask for PIN and store in pin
  create currentCustomer set to null
  create boolean login set to false
  for each customer in customers
    if customer login is successful
      print "login successful"
      set login to true
      set currentCustomer to customer
      currentCustomer.start()
  if login is false
    print "login unsuccessful"
```
*User*
```
login()
  create Scanner input
  ask for username store to username 
  ask for pin store to pin
  if username equals this.username and pin equals this.pin
    return true
  else
    return false

login(String username, String pin)
  if username equals this.username and pin equals this.pin
    return true
  else
    return false
```
*Customer*
```
instantiate checking and savings account

Customer constructor
  set username to "Alice"
  set pin to "1111"

Customer(String username, String pin)
  set this.username to username
  set this.pin to pin

start()
  create boolean keepGoing gets true
  while keepGoing is true
    response = menu()
    if response equals "0"
      set keepGoing to false
    else if response equals "1"
      checking.start()
    else if response equals "2"
      savings.start()
    else if response equals "3"
      changePin()
    else
      print "Error"

menu()
  create Scanner input
  print Customer Menu options (0-3)
  store input to response 
  return response

getReport()
  print username, savings, and checking balances with getBalanceString()

changePin()
  create Scanner input
  get users new input and store to newPin
  if newPin matches "^\\d{4}$" (makes sure newPin is exactly 4 digits 
    set pin to newPin
  else
    print "ERROR: pin must be numeric and 4 digits"
    set pin to "0000"
```
*Admin*
```
Admin constructor
  set username to "admin"
  set pin to "0000"

menu()
  create Scanner input
  print the menu options (0-3)
  store input to response
  return response

start()
  empty method to satisfy User

getReport()
  print "username: " + username
  print "PIN: " + pin
```
*Checking Account* 
```
CheckingAccount constructor
  set balance to 0.00

CheckingAccount(double balance)
  set balance to input balance

menu()
  create Scanner input
  print "Account Menu" and options 0-3
  store user input to response
  return response

start()
  create boolean keepGoing gets true
  while keepGoing is true
    response = menu()
    if response equals "0"
      set keepGoing to false
    else if response equals "1"
      checkBalance()
    else if response equals "2"
      makeDeposit()
    else if response equals "3"
      makeWithdrawal()
    else
      print "erro"

getBalanceString()
  create sBalance as String formatted with balance
  return sBalance

checkBalance()
  print "current balance: $" + getBalanceString()
  
getDouble()
  create Scanner input
  sResult gets users input
  create double result set to 0
  try
    parse sResult into double and store to result
    return result
  catch NumberFormatException e
    print "ERROR: Input must be a number. No letters or symbols allowed."
  return result

makeDeposit()
  deposit = getDouble()
  total = balance + deposit
  setBalance(total)
  print "new balance: $" + getBalanceString()

makeWithdrawal()
  withdrawal = getDouble()
  total = balance - withdrawal
  setBalance(total)
  print "new balance: $" + getBalanceString()
```
*Savings Account*
```
calcInterest()
  double  interest = interestRate * balance
  balance = balance + interest
```
