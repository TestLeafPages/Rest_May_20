Feature: IncidentManagement

Scenario: Get all incident

Given url 'https://dev79032.service-now.com/api/now/table/incident'
#header => key = value
#param	=> key = value
And header Authorization = 'Basic YWRtaW46VHVuYUAxMjM='
And header accept = 'application/xml'
And param sysparm_fields = 'number,sys_id,short_description,type'
When method get
Then status 200
And match responseType == 'xml'
#And match responseStatus == 200
And print response
