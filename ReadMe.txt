localhost:8080
	CRUD AirCompany
create /addAirCompany
Example
 {
        "companyName": "wizzair",
        "companyType": "passenger's",
        "foundedAt": 1999
 }
read /allAirCompany
update /updateAirCompany
Example 
 {
        "id":1
        "companyName": "wizzair",
        "companyType": "passenger's",
        "foundedAt": 1999
 }
delete /deleteAirCompany/{id}
example /deleteAirCompany/1

Endpoint to move airplanes between companies /api/changeNewCompany/{airplaneId}/{companyId}
Example /api/changeNewCompany/1/2

Endpoint to find all Air Company Flights by status /api/companyByStatus/{status}
Example /api/companyByStatus/COMPLETED

Endpoint to find all Flights in ACTIVE status and started more than 24 hours ago. /api/before24

Endpoint to add new Flight /addFlightNew
Example 
{
    "aircompany": {"id":8},  
    "airplane": {"id":20},  
    "delayStartedAt": "2021-12-31 11:37:22",  
    "departureCountry": "UA",
    "destinationCountry": "SK",  
    "distance": 1111,  
    "endedAt":"2021-12-31 11:37:22" ,
    "estimatedFlightTime":"01:10:00",
    "flightStatus":"ACTIVE",
    "createAt":"2021-12-31 10:37:22"
}
Endpoint to change Flight status /api/changeStatus/{id}/{status}
Example 
	/api/changeStatus/22/ACTIVE

