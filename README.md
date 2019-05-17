# Pico y Placa
Sample java code with Unit Tests.
## What does it do?
This application verifies if a certain Ecuadorian License Plate is restricted to enter Quito's Downtown. This restriction is called "Pico y Placa" and it is based on the last number of the license plate (Placa) and the current day.

Currently, Quito's Municipality mandates that license plates which finishes with 1 or 2, can't enter the city on Mondays.  If it finishes with 3 or 4, restriction is applied on Tuesdays; 5 and 6 on Wednesday, 7 and 8 on Thursday and 9 and 10 on Friday.

Also, Pico y Placa only works from 7:00 to 9:30 and 16:00 to 19:30.

## Input Parameters
This applications has a Executable Class called "Program".  Is will accept parameters as a command line application, for example:

$java Program.class GSF-9368 16-05-2019 07:40
