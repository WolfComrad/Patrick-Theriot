# while(i != 10) {
#      i++ 
# } 

move $s3, $zero #i=0

while: #beginning of the loop
beq $s3, 10, exit # $s3==10, or go to exit
addi $s3, $s3, 1 #$s3=$s3+1 -> i++
j while #restart the loop
exit: #location we can exit to

li $v0, 1
move $a0, $s3
syscall