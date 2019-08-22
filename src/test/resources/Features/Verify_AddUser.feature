Feature: Add New User 

@Functional 
Scenario Outline: Verify Add new user functionality

	Given Open browser as "<browser>" 
	And Enter the URL as "<URL>" 
	Given Enter Username and Password 
		| jasonbob | test123 |
	And Click on login button 
	Given Click on Add User link 
	And Enter Name:"<Name>","<Email>","<Date>","<Message>","<Input>" 
	Given Click on Logout button 
	Then Close the browser 
	
	Examples: 
		| browser 		| URL  						   | Name 		| Email			     |Date	 	 |Message	  |Input 	  |
		| Firefox 	| http://yp1007034lt/yash-test/| Naveen		| Naveen43@gmail.com  |		     |Test Message|Test Input |
		