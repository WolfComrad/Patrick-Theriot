.data
First: .asciiz "Enter the first value: "
Second: .asciiz "Enter the second value: "
Value: .asciiz "The sum of the values is: "
String: .asciiz "Enter a String here: "
Stringcop: .asciiz "The string you entered is: "
Array: .word 0, 1, 2, 3
Input: .space 20

.text
li $v0, 4 #syscall code to print a string
la $a0, First
syscall

li $v0, 5
syscall
move $t0, $v0

li $v0, 4 #syscall code to print a string
la $a0, Second
syscall

li $v0, 5
syscall
move $t1, $v0

#adding and printing
add $s1, $t0, $t1

li $v0, 4 #syscall code to print a string
la $a0, Value
syscall

li $v0, 1
move $a0, $s1
syscall

li $v0, 11
li $a0, '\n'
syscall

#Read in a String
li $v0, 4 #syscall code to print a string
la $a0, String
syscall

li $v0, 8
la $a0, Input
li $a1, 16
syscall

#Read in a String
li $v0, 4 #syscall code to print a string
la $a0, Stringcop
syscall

#Print the read string
li $v0, 4
la $a0, Input
syscall

#Ending the program
li $v0, 10
syscall