.data
Prompt1: .asciiz "This program will take in a number of integer values between 1 and 10 and then take in a value to search for in the list.\n\nThe program will then report if the value was found in the list or not.\n\nHow many items will the list contain?"
EnterValue: .asciiz "\nTo chose the amount of integers in the list, enter a number between 1 and 10: "
FirstVal: .asciiz "\nEnter the first value of the list: "
NextVal: .asciiz "\nEnter the next value: "
FindVal: .asciiz "\nEnter the value we are searching the list for (does not have to be a number previously entered): "
Found: .asciiz "\nValue found in the list.\n\n"
NotFound: .asciiz "\nValue not found in the list.\n\n"
.align 2
Values: .space 40

.text
li $v0, 4
la $a0, Prompt1
syscall

li $v0, 4
la $a0, EnterValue
syscall

li $v0, 5
syscall

move $s3, $v0

li $v0, 4
la $a0, FirstVal
syscall
li $v0, 5
syscall

la $s0, Values

li $s4, 1
li $s1, 0
ValueLoop:
add $t0, $s0, $s1
sw $v0, 0($t0)
beq $s4, $s3, Find
li $v0, 4
la $a0, NextVal
syscall
li $v0, 5
syscall
addi $s1, $s1, 4
addi $s4, $s4, 1
j ValueLoop

Find:
li $v0, 4
la $a0, FindVal
syscall
li $v0, 5
syscall

move $s5, $v0

li $s1, 0
li $t3, 0
Search:
beq $t3, $s3 OhNO
addi $t3, $t3, 1

add $t0, $s0, $s1
lw $t1, 0($t0)

beq $s5, $t1 WeDidIt
addi $s1, $s1, 4
j Search

WeDidIt:
li $v0, 4
la $a0, Found
syscall

j End

OhNO:
li $v0, 4
la $a0, NotFound
syscall

End:
li $v0, 10
syscall
