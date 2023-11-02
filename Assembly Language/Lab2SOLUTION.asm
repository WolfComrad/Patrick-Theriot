#lab 2 solution file
.data
Info1: .asciiz "This part of the program reads in two numbers, adds them, and then prints the result. \n"
Info2: .asciiz "\nThis part of the program reads in a string and says it back.\n"
Prompt1: .asciiz "Place your first number here: "
Prompt2: .asciiz "Place your second number here: "
Result1: .asciiz "The sum is: "
Prompt3: .asciiz "Plug your sting in: "
Result2: .asciiz "Your string was: \n\t"
Input: .space 20

.text
#print a string
li $v0, 4
la $a0, Info1
syscall

li $v0, 4
la $a0, Prompt1
syscall

#read the first integer
li $v0, 5
syscall
move $t0, $v0

li $v0, 4
la $a0, Prompt2
syscall

#read the second integer
li $v0, 5
syscall
move $t1, $v0

add $t0, $t0, $t1

li $v0, 4
la $a0, Result1
syscall

li $v0, 1
move $a0, $t0
syscall

#start part 2

li $v0, 4
la $a0, Info2
syscall

li $v0, 4
la $a0, Prompt3
syscall

li $v0, 8
la $a0, Input
li $a1, 16
syscall

li $v0, 4
la $a0, Result2
syscall

li $v0, 4
la $a0, Input
syscall

li $v0, 10
syscall