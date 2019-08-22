Feature: Verify Email 


@Functional 
Scenario Outline: Verify valid Email functionality

	Given Open browser as "<browser>" 
	And Enter the URL as "<URL>" 
	Given Enter Username and Password 
		| jasonbob | test123 |
	And Click on login button 
	Given Click on Add User link 
	Given Invalid Email:"<Name>","<Email>","<Date>","<Message>","<Input>" 
	Then Error message should be shown as "<ErrorMessage>" 
	Given Click on Logout button 
	Then Close the browser 
	Examples: 
		| browser 		| URL  						  		| Name 		| Email			     |Date	 	 |Message	  |Input 	  |ErrorMessage|
		| Chrome   	| http://yp1007034lt/yash-test/ 	| Shrey		| shrey.com			 |		     |Test Message|Test Input |Please enter a valid email addres.|
		
		
