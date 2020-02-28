# Fibonacci: recursion vs iteration.

The purpose of this exercise is not to determine what method of calculating a Fibonacci sequence would be more efficient in computational terms. 

## What does this program do?

The program calculates the Fibonacci sequence, both recursively and iteratively, for a specific number of passes, while
calculating the time it takes to perform the calculations for each pass. The time is calculated in nanoseconds.

It is expected that for the smaller number of passes, the calculation times will be smaller. As the number of passes
grows, so will the time to perform each calculation.

The program will run all 35 passes twenty times, so as to get a large data set to graph and compare results. Each time 
35 passes are run, the program will output the timing data into a CSV (comma separated values) file, 
which can then be used to graph the results and determine what calculation is more computationally efficient.

## Code design.

The code for this program has been divided into two parts. First, a class FibonacciFunctions that contains the two 
calculation methods. Second, a class FibonacciImplementation that calls the FibonacciFunctions, calculates the time of
the calculations and finally outputs the CSV file for graphing the results.

## Test plans and standards.

For the sake of speed and simplicity, the code was not test driven. In other words, no unit tests were used to test the
code or the outputs. Testing was done in two stages. First, to test that the Fibonacci sequence was properly generated
in each pass, by outputting each of the numbers of the sequence that corresponded to each pass. Since output to the
console during the calculations would add an unnecessary overhead thereto, the numbers will not be output to the console
once testing is concluded.

## System requirements.

The code is not dependent on any specific JDK. However, the code was compiled and tested using version Amazon's
distribution of the Open Java Development Kit (OpenJDK) [Corretto 11](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/what-is-corretto-11.html).

## How to use this program.

The program requires no user interaction other than compilation and execution. User may, however, decide to test the
program with increased or reduced number of passes. To do so, the value assigned to the static variable `iterations` can 
be changed. Be careful, though. It is expected that a high number of passes will take much longer to execute the 
`recursive` method, which theoretically makes heavy use of stack memory, and may hang your system.

## Installation.

To install the program, simply clone the repo and open it in your favorite IDE. As stated in system requirements above, 
it is not JDK dependent, and should work out-of-the-box with any current JDK.

## Known Issues

After the program outputs the results to CSV files, the task of compiling the results is tedious. There is too much
transposing involved before the charts can be generated. This will require additional coding to properly output the
results to two CSV files instead of several files for later processing. 

