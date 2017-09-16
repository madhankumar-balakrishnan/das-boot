Feature: Ship wreck GET request

  Scenario: client makes call to GET /shipwrecks
  	Given the client has logged in
    When the client calls /shipwrecks
    Then the client receives status code of 200
    
  Scenario Outline: client makes call to GET /shipwrecks and check the response
  	Given the client has logged in
    When the client calls /shipwrecks
    Then the client receives status code of 200
    And response contains single message <message>
    Examples:
    	|message    |
    	|"name":"h" |

  Scenario Outline: client makes call to GET /shipwrecks/{id} and check the response
  	Given the client has logged in
    When the client calls /shipwrecks/<id>
    Then the client receives status code of <status>
    And response contains message <message> and <result>
    Examples:
    	|	id	|	status 	|	message											|result		|
    	|	33	|	200		|	"name":"h"										|true		|
    	|	1	|	500		|	"exception":"java.util.NoSuchElementException"	|true  	    |   