li $s0, 15

# this is a while loop that finds and prints the positions
positions: 
li $v0, 1
move $a0, $s0
syscall

beq $s0, 0, print

li $v0, 11
li $a0, 9
syscall

sub $s0, $s0, 1
j positions

# this is just printing out my new line
print:
li $v0, 11
li $a0, 10
syscall

li $s1, 32768

# this is a while loop that calculates and prints out the positions values
values:
li $s2, 2

beq $s1, 0, endprogram

li $v0, 1
move $a0, $s1
syscall

div $s1, $s2
mflo $s1

li $v0, 11
li $a0, 09
syscall

j values

# this ends the program
endprogram:
li $v0, 10
syscall
