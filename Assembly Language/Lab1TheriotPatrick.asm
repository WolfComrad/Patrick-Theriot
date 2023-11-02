#f=g+(h-i)+j
#g=20, h=14, i=6, j=22
li $s0, 20 # $s0 = 20 = g
li $s1, 14 # $s1 = 14 = h
li $s2, 6 # $s2 = 6 = i
li $s3, 22 # $s3 = 22 = j

sub $t0, $s1, $s2 # $t0=14-6
add $t1, $s0, $t0 # $t1=20+8
add $t2, $t1, $s3 # $t2=28+22

li $v0, 1 # $v0 = 1
move $a0, $t2 # $a0 = 50
syscall

li $v0, 11
li $a0, 10
syscall

li $s0, 20 # $s0 = 20 = g

li $v0, 5 # user input = h
syscall
move $s1, $v0 # $s1 = #v0
 
li $s2, 6 # $s2 = 6 = i

li $v0, 5 # user input = j
syscall
move $s3, $v0 # $s3 = $v0

sub $t0, $s1, $s2 # $t0=14-6
add $t1, $s0, $t0 # $t1=20+8
add $t2, $t1, $s3 # $t2=28+22

li $v0, 1 # $v0 = 1
move $a0, $t2 # $a0 = 50
syscall

li $v0, 10
syscall
