#sll and srl example

li $s0, 9

sll $s0, $s0, 4 #shift left by 4 places

#print the result
li $v0, 1
move $a0, $s0
syscall

#print space
li $v0, 11
li $a0, 10
syscall

srl $s0, $s0, 4

#print the result
li $v0, 1
move $a0, $s0
syscall

#close the program
li $v0, 10
syscall