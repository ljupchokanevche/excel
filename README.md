# Coding Challenge

In this coding challenge I used different libraries to cut corners a bit.

## Libraries used

For development ease
* Lombok (for generation POJOs, getters, setters and builders)
* Jackson (for conversion of a POJO to a json)
* Apache POI (for handling of the Excel file)

For testing purposes
* AssertJ
* Junit5

Created services for handling the Excel file, the JSON conversion and for making the request.
Also created domain models for better storing the row data, and for the body of the POST request.