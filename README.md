Use basic auth for requests, username and password specified in application.properties file

default:
username=username
password=password

resilience mechanism is not implemented at this stage.

*request/response example*:HTTP GET 

http://{host}:{port}/CAD?transform=SEK

response example

{
    "baseCurrency": "SEK",
    "secondaryCurrency": "CAD",
    "date": "2020-10-19",
    "rate": 0.1498677325
}

{port} - default to 8080
