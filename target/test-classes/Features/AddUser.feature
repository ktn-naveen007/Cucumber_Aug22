Feature: Add User 

@Functional 
Scenario Outline: Verify add user functionality

	Given Open browser as "<browser>" 
	And Enter the URL as "<URL>" 
	And Click on Sign Up button 
	Then Enter Details:"<FirstName>","<LastName>","<Email>","<Password>" 
	Then Close the browser 
	
	Examples: 
		| browser 		| URL  								| 	Title    | FirstName 	| LastName           |Email	 	 		|Password   |
		| Chrome  		| http://yp1007034lt/yash-test/ 	|Matrix Admin| Shrey		| Choudhary			 |shrey@gamil.com	|password123|
		| Firefox   		| http://yp1007034lt/yash-test/ 	|Matrix Admin| Shrey		| Choudhary			 |shrey@gamil.com	|password123|
		