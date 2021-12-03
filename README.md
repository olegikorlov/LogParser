<h1 align="center">Log Parser</h1>

<p align="center">

<img src="https://img.shields.io/badge/made%20by-java--058--02-critical">

</p>

---
Log Parser is a command-line application that allows parsing log files containing extended log records and getting some
statistic data. For that, you can use specified keys.

## Usage

### Format of the command:

`logparser [option]... [file]...`

Parameter                 | Description
------------------------- | ------------------------------------------------------
`[option]...`             | It can be as the key itself as a key with the value argument
`[file]...`               | File that will be parsed (It can be as one file as a many)

### Options

Option                    | Description
------------------------- | ------------------------------------------------------
`--help`                  | Show the list of options
`--limit`                 | Limit answer with a number
`--from`                  | Sets the start date
`--to`                    | Sets the end date
`--asc`                   | Sets ascending order
`--desc`                  | Sets descending order (used by default)
`--ip`                    | Displays the number of requests from IP
`--sc`                    | Displays the number of requests from status code
`--res`                   | Displays the number of requests from the resources
`--ref`                   | Displays statistics by referrers
`--size`                  | Displays the amount of downloaded data

## Usage examples

````
logparser --help
logparser 0.log
logparser 0.log 1.log (by default count statistics by ip-addresses)
logparser --limit=5 0.log 1.log
logparser --limit=7 --from=2015-05-17T10:05:30 0.log 1.log
logparser --limit=7 --from=2015-05-17T10:05:30 --to=2015-05-17T10:06:31 0.log 1.log
logparser --limit=3 --res 0.log 1.log
logparser --limit=3 --ref 0.log 1.log
logparser --limit=4 --size 0.log 1.log
logparser --ip 0.log 1.log
logparser --ip --asc 0.log 1.log
````

## Example of records that parser can pars

````
83.149.9.216 - - [17/May/2015:10:05:43 +0000] "GET /presentations/logstash-monitorama-2013/images/kibana-dashboard3.png HTTP/1.1" 200 171717 "http://semicomplete.com/presentations/logstash-monitorama-2013/" "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1700.77 Safari/537.36"
````