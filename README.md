**Introduction**

This is an application, which takes user input for the start time and end time and checks if it was inputted in the correct format. The goal of the application is to let the user know how many hours from the timeframe were during the day and how many during the night.

**Functionality**
The application is designed to work on a while loop, where it asks the user to enter start time and end time. The acceptable time formats are based on the 24h clock and 15-minute intervals (HH:00, HH:15, HH:30, HH:45). If the time is entered incorrectly, the program gives the user feedback and exits. With the correct user input, the time is calculated into minutes and checked against day (06:00 - 22:00) and night (22:00 - 06:00) time. After the program has determined how many minutes are during the day and night, it is converted back to hours and displayed to the user. After successfully presenting the user with the hours per day and night, the user is prompted with an option to repeat the process or exit the application.

**Edge cases**  
In the 24h clock, several exception can occur.
To start with, it's possible to use either 00:00 or 24:00, this program is only allowing 00:00, which is set up by regex input validation.
Furthermore, 24h clock can include times that have a single hour digit, for instance 9:00. These are not allowed in this case, all times need to be entered in HH:MM format.
It is possible that the start time and end time are the same, the solution for this is that the program is adding 24h and treating it as the next day, rather than returning no duration.

**Testing**
Testing was completed with JUnit. A separate test for each function was written to verify the input, time calculation and string parsing.

**Weaknesses**
There could be more feedback for the user surrounding what exactly went wrong with the input. In addition, a feature where user could re-enter the input after an incorrect one, rather than the program exiting would be a good addition, however, to reduce the repetition of printing out the required format, the choice to exit the program was made.   
