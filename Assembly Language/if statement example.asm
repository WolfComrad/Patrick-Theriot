# if(i == j) {
#    f = g + h;
# }
# else {
#    f = g - h;
# }
# $s0-$s4 => f-j

li $s1, 10 #g
li $s2, 5 #h
li $s3, 1 #i
li $s4, 1 #j

bne $s3, $s4, else # if $s3 != $s4 go to else label
add $s0, $s1, $s2 # $s0=$s1+$s2 -> f=g+h
j exit #need a way to bypass the else
else:
sub $s0, $s1, $s2 # $s0=$s1-$s2 -> f=g-h

exit:
li $v0, 1 #system code to print an intager
move $a0, $s0 #copy f/$s0 int $a0
syscall

li $v0, 10 #system code to close the program
syscall