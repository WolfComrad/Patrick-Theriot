.data
Hello: .asciiz "Hello, world!\n"
Array: .word 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
Input: .space 20

.text
li $v0, 4 #syscall code to print a string
la $a0, Hello #load address, puts the address Hell in $a0
syscall

#g=h+Array[8];
move $s2, $zero # h = 0
la $s3, Array #base address of Array in $s3
lw $t0, 32($s3) #$t0 = 32 offset from $s3 = Array[8]
add $s1, $s2, $t0 #$s1 = $s2 + $t0 = h + Array[8]

li $v0, 1
move $a0, $s1
syscall

li $v0, 11
li $a0, '\n'
syscall

#Array[5] = h + Array[8];
lw $t0, 32($s3)
add $t0, $s2, $t0
sw $t0, 20($s3)

lw $a0, 20($s3) #load into $a0 the value at Array[5]
li $v0, 1
syscall

li $v0, 11
li $a0, '\n'
syscall

#Read in a String
li $v0, 8
la $a0, Input
li $a1, 16
syscall

#Print the read string
li $v0, 4
la $a0, Input
syscall

li $v0, 10
syscall