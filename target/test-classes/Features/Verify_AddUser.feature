Feature: Add New User 

@Functional1 
Scenario Outline: Verify Add new user functionality

	Given Open browser as "<browser>" 
	And Enter the URL as "<URL>" 
	Given Enter Username and Password 
		| jasonbob@gmail.com | test123 |
	And Click on login button 
	When Click on Add User link 
	And Enter Name:"<Name>","<Email>","<Date>","<Message>","<Input>" 
	Given Click on Logout button 
	Then Close the browser 
	
	Examples: 
		| browser 		| URL  						   | Name 		| Email			     |Date	 	 |Message	  |Input 	  |
		| Chrome	| http://yp1007034lt/yash-test/| Naveen		| Naveen43@gmail.com  |		     |Test Message|Test Input |
		