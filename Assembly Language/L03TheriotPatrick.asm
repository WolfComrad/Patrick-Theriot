.data
Discribe: .asciiz "This program reads in a String from the user and then allows the user to make changes to it until they want to stop."
Discribe2: .asciiz "\n\nWARNING! this program is case sensitive. Please enter your string now. (maximum of 40 characters):\n\n"
Current: .asciiz "\nYour current string is:\n\n"
Promt1: .asciiz "\nDo you want to make any changes to the string? (Y/N):"
Promt2: .asciiz "\n\nEnter the character in the string would you like replaced:"
Promt3: .asciiz "\n\nEnter what you would like to change the character to:"
Final: .asciiz "\n\nYour final string is:\n\n"
String: .space 41

.text
li $v0, 4
la $a0, Discribe
syscall

li $v0, 4
la $a0, Discribe2
syscall

li $v0, 8
la $a0, String
li $a1, 40
syscall

move $s0, $a0

move $s2, $zero #i = 0
Loop:
add $t0, $s0, $s2 #finds the address of y[i]
lbu $t1, 0($t0) #loads y[i] into $t1
beq $t1, $zero, Next #if we copied the null byte, then exit
addi $s2, $s2, 1 #i+=1
j Loop

Next:
li $v0, 4
la $a0, Current
syscall

li $v0, 4
move $a0, $s0
syscall

Changeloop:
li $v0, 4
la $a0, Promt1
syscall

li $v0, 12
syscall
move $t3, $v0

beq $t3, 'Y', Yloop
j End

Yloop:

li $v0, 4
la $a0, Promt2
syscall

li $v0, 12
syscall
move $t4, $v0

li $v0, 4
la $a0, Promt3
syscall

li $v0, 12
syscall
move $t2, $v0

move $s2, $zero #i = 0
Loop2:
add $t0, $s0, $s2 #finds the address of y[i]
lbu $t1, 0($t0) #loads y[i] into $t1
addi $s2, $s2, 1 #i+=1

beq $t1, $zero, Jump
beq $t1, $t4, ChangeChar
j Loop2

ChangeChar:
sb $t2, 0($t0)
j Loop2

Jump:
li $v0, 4
la $a0, Current
syscall

li $v0, 4
move $a0, $s0
syscall
j Changeloop

End:
li $v0, 4
la $a0, Final
syscall

li $v0, 4
move $a0, $s0
syscall

li $v0, 10
syscall
