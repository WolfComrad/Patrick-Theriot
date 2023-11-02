# void strepy ( char x[], char y[]) {
#	Int I;
#	I = 0;
#	While ((x[i] = y[i] ) != “\0”)
#		I += 1;
# }
# char[] x = $s0, char[] y = $a1
.data
y: .asciiz "Hello, MIPS"
x: .space 20

.text
Main:

la $a0, x #load x into $a0
la $a1, y #load y into $a1

jal Strepy

li $v0, 4 #printing a string
la $a0, x
syscall

#close the program
li $v0, 10
syscall


Strepy:
addi $sp, $sp, -4 # adjust the stack
sw $s0, 0($sp) #save $s0

move $s0, $zero #i = 0
Loop:
add $t0, $a1, $s0 #finds the address of y[i]
lbu $t1, 0($t0) #loads y[i] into $t1
add $t2, $a0, $s0 #finds the address of x[i]
sb $t1, 0($t2) #store y[i] into x[i]
beq $t1, $zero, End #if we copied the null byte, then exit
addi $s0, $s0, 1 #i+=1
j Loop

End:
lw $s0, 0($sp) #restore $s0
addi $sp, $sp, 4 #restore the stack
jr $ra
