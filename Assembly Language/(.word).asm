.data
Array: .word 0, 1, 2, 3, 4

.text

la $s0, Array
li $s1, 0
Loop:
beq $s1, 20, End
add $t0, $s0, $s1
lw $a0, 0($t0)
li $v0, 1
syscall

#addi $s0, $s0, 4
addi $s1, $s1, 4
j Loop

End:
li $v0, 10
syscall

#lw $a0, 4($s0)
#li $v0, 1
#syscall

#lw $a0, 12($s0)
#li $v0, 1
#syscall

#lw $a0, 8($s0)
#li $v0, 1
#syscall
