Feature: UpdateIncident

Background:
And header Authorization = 'Basic YWRtaW46VHVuYUAxMjM='

Scenario: Create a new incident with body
* def requestJsonbody = karate.readAsString('data/UpdateIncident.json')

Given url 'https://dev79032.service-now.com/api/now/table/incident'
And header accept = 'application/json'
And param sysparm_fields = 'number,sys_id,short_description,type'
And header Content-Type = 'application/json'
And request requestJsonbody
When method post
And print response
And def sysID = response.result.sys_id 

Given url 'https://dev79032.service-now.com/api/now/table/incident/'+sysID
When method delete
Then status 204
And assert responseTime < 5000
And print response
















