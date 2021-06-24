Feature: Create new jira issue

Scenario: Create and view the newly created issue
Given url 'https://api-may2020.atlassian.net/rest/api/2/issue/'
And header Authorization = 'Basic aGFyaS5yYWRoYWtyaXNobmFuQHRlc3RsZWFmLmNvbTozS3lVTnFmRklqQTBhenZhaVVnbjI5M0M='
And def BodyOfRequest = read('CreateIssue.json')
And request BodyOfRequest
#Given request {'fields': {'project':{'key': 'RA' },'summary': 'create issue in RA project','description': 'Creating of an issue using project keys and issue type names using the REST API','issuetype': {'name': 'Story'}}}
When method post
Then status 201
When def endPoint = response.self 
Given print response
Given url endPoint
And header Authorization = 'Basic aGFyaS5yYWRoYWtyaXNobmFuQHRlc3RsZWFmLmNvbTozS3lVTnFmRklqQTBhenZhaVVnbjI5M0M='
When method delete
Then status 204



