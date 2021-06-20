Feature: UpdateIncident

Background:
And header Authorization = 'Basic YWRtaW46VHVuYUAxMjM='

Scenario: Create a new incident without body
* def requestJsonbody = karate.readAsString('data/UpdateIncident.json')

Given url 'https://dev79032.service-now.com/api/now/table/incident'
And header accept = 'application/json'
And param sysparm_fields = 'number,sys_id,short_description,type'
And request {}
When method post
And def sysID = response.result.sys_id 
And print response

Given url 'https://dev79032.service-now.com/api/now/table/incident/'+sysID
And param sysparm_fields = 'number,sys_id,short_description,type'
And header Content-Type = 'application/json'
And request requestJsonbody
When method put
Then status 200
And match responseType == 'json'
And match response.result.short_description == 'Update incident with body as File 1'
And match response.result.short_description contains 'Update incident with body as File 1'
And assert responseTime < 5000
And print response
















