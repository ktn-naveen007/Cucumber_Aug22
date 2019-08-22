Feature: Login 

@Functional1
Scenario Outline: Verify Login functionality

	Given Open browser as "<browser>" 
	And Enter the URL as "<URL>" 
	Given Enter Username and Password 
		| jasonbob | test123 |
	And Click on login button 
	Then Title should be "Yash Admin" 
	Then Close the browser 
	
	Examples: 
		| browser 		| URL  								|
		| Firefox    	| http://yp1007034lt/yash-test/ 	|
		
		
		
		
		
		
