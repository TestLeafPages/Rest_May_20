Feature: CreateIncident

Background:
Given url 'https://dev79032.service-now.com/api/now/table/incident'
And header Authorization = 'Basic YWRtaW46VHVuYUAxMjM='


Scenario: Create a new incident without body

Given url 'https://dev79032.service-now.com/api/now/table/incident'
And header Authorization = 'Basic YWRtaW46VHVuYUAxMjM='
And header accept = 'application/xml'
And param sysparm_fields = 'number,sys_id,short_description,type'
And request {}
When method post
Then status 201
And match responseType == 'xml'
And print response

Scenario: Create a new incident with body

And header accept = 'application/json'
And param sysparm_fields = 'number,sys_id,short_description,type'
And request { "short_description": "create incident with body json", "category": "hardware"}
When method post
Then status 201
And match responseType == 'json'
And print response

Scenario: Create a new incident with body

* def requestJsonbody = karate.readAsString('data/CreateIncident1.json')

And param sysparm_fields = 'number,sys_id,short_description,type'
And header Content-Type = 'application/json'
And request requestJsonbody
When method post
Then status 201
And match responseType == 'json'
And match response.result.short_description == 'Created incident with body as File 1'
And assert responseTime < 5000
And print response
















