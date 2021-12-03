<h1 align="center">Log Parser</h1>

<p align="center">

<img src="https://img.shields.io/badge/made%20by-java--058--02-critical">

</p>

---
Log Parser is a command line application that allows to parse Apache log records in various ways.

## Usage

Format of the command:

`lp -[key=value]... [file]...`

Parameter                 | Description
------------------------- | ------------------------------------------------------
`[file names]`            | File that will be parsed
`[key=value]`             | Special key and optional value

### Keys

Key                       | Description
------------------------- | ------------------------------------------------------
`-ip`                     | Displays the number of requests from IP
`-res`                    | Displays the number of requests to the site(s)
`-sc`                     | TODO
`-size`                   | Displays the correspondence of sites with the amount of data loaded from them
`-from`                   | Sets the start date
`-to`                     | Sets the final date
`-l`                      | Sets the maximum lines to show
`-a`                      | Sets an ascending order for output
`-d`                      | Sets a descending order for output





Usage example:    
`-ip -l=10 -a apache_logs_1.txt apache_logs_2.txt`    
`-size -l=30 -from=2016-02-14T18:00:00 apache_logs_1.txt`    
`-sc=4xx -d apache_logs_1.txt`
