Feature: Invoke Application

@Smoke
Scenario Outline: Verify invoking the application

	Given Open browser as "<browser>" 
	And Enter the URL as "<URL>" 
	Then Close the browser 
	
	Examples: 
		| browser 		| URL  								|
		| Firefox   		| https://www.amazon.in/|