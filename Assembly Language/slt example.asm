li $s0, 10
li $s1, 10

slt $t0, $s0, $s1 # if ($s0 < $s1) then $t0=1
                  # else $t0=0
bne $t0, $zero, GE

li $v0, 1
move $a0, $zero
syscall
j exit

GE:
li $v0, 1
li $a0, 1
syscall

exit:
li $v0, 10
syscall