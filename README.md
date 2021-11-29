
<h1 align="center">Log Parser</h1>

<p align="center">

<img src="https://img.shields.io/badge/made%20by-java--058--02-critical">

</p>

---
Log Parser is a command line application that allows to parse Apache log records in various ways.

## Usage

Format of the command:

`lp [file name] --[identifier] --[method]=[argument]`


Parameter                 | Description
------------------------- | ------------------------------------------------------
`[file name]`             | File that will be parsed
`[identifier]`            | Identifier for parsing
`[method]`                | Method for parsing
`[argument] `             | Any positive integer that sets the number of lines to display


### Identifier

Identifier                | Description
------------------------- | ------------------------------------------------------
`-i (--ip)`               | Parsing log by IP-address
`-r (--resource)`         | Parsing log by resource
`-s (--status)`           | Parsing log by response status code

### Method

Method                    | Description                                         
------------------------- | ------------------------------------------------------
`--top`                   | Descending order                                      
`--tail`                  | Ascending order
