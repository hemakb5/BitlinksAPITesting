Feature: Test Bitlink API's

@createBitLink
Scenario Outline: Create a Bitlink
	Given I send createBitlink Payload
	When user calls "<Resources>" with "<HTTPMethod>" http request
	Then the API call got success with status code <StatusCode>
Examples:
|Resources|HTTPMethod|StatusCode|
|AddBitLinkAPI|POST|200|
|AddBitLinkAPI|GET|400|


@getAGroup
Scenario Outline: Retrieve a Group
	Given I send retrive A group request
	When user calls "<Resources>" with "GET" http request
	Then the API call got success with status code <StatusCode>
Examples:
|Resources|StatusCode|
|RetrieveGroupAPI|200|
|RetrieveGroupAPINeg|403|

@getSortedBitlinksForGroup
Scenario Outline: Retrieve Sorted Bitlinks for Group
	Given I send Retrieve Sorted Bitlinks for Group request with unit as "day"
	When user calls "<Resources>" with "GET" http request
	Then the API call got success with status code <StatusCode>
Examples:
|Resources|StatusCode|
|RetrieveSortedBitlinksForGroup|200|
|RetrieveSortedBitlinksForGroupNeg|403|

	
	
	
	
	
	

	
	
	