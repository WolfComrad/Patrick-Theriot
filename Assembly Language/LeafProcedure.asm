.text
main:
li $s0, 99
li $a0, 10
li $a1, 5
li $a2, 5
li $a3, 5

li $v0, 1
move $a0, $s0
syscall

li $v0, 11
li $a0, '\n'
syscall

jal leaf_example

move $s1, $v0

li $v0, 1
move $a0, $s1
syscall

li $v0, 11
li $a0, '\n'
syscall

li $v0, 1
move $a0, $s0
syscall

li $v0, 10
syscall


#procedure location
leaf_example:
addi $sp, $sp, -4 #making room to add 1 new item.
sw $s0, 0($sp) #store $s0 onto the stack.

add $t0, $a0, $a1 #add g+h
add $t1, $a2, $a3 #add i+j
sub $s0, $t0, $t1 #sub the results into f

move $v0, $s0 #move $s0 into $v0 to return f.

lw $s0, 0($sp) #restore $s0 from the stack.
addi $sp, $sp, 4 #restore the $sp.

jr $ra #jump to our return address.