Feature: Incident Management


#Background:
#Given Set the endpoint
#And Set the Authorization


#Scenario: Create a new incident
#
#When you send the request as post
#Then verify the status code is 201
#And Print the response 

Scenario: get an incident
And Set the contentType as json
When you send the request as get
Then verify the status code is 200
And Print the response 


Scenario Outline: Create incident
And Set the contentType as json
When you send the request as post with short_description as <description>
Then verify the status code is 201
And Print the response 

Examples:
#Header
|description|
|create incident with body as string 1|
|create incident with body as string 2|

