.text
main:
li $a0, 5 # n

jal fact #call fact
move $s0, $v0 #move the return value into $s0

li $v0, 1 #print the result
move $a0, $s0
syscall

li $v0, 10 #close the program
syscall

# fact function location
fact:
addi $sp, $sp, -8 #moving down 8 bytes/2 words/2 items down
sw $ra, 4($sp) # store $ra on the stack, 1 word up
sw $a0, 0($sp) # store $a0 on the stack

slti $t0, $a0, 1 #if $a0 < 1, then $t0 = 1 else 0
beq $t0, $zero, else #move to the recursive call
li $v0, 1 #set up the return value of 1
addi $sp, $sp, 8 #restore the stack
jr $ra #return with $v0 = 1

else: 
sub $a0, $a0, 1 #change n to n-1
jal fact #recursively call fact

lw $a0, 0($sp) # restore $a0 from the stack
lw $ra, 4($sp) # restore $ra from the stack
addi $sp, $sp, 8 # restore the stack

mul $v0, $a0, $v0 # $v0= n*(fact(n-1))
jr $ra # return with $v0 = n*(fact(n-1))