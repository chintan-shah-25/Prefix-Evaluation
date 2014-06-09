Prefix-Evaluation
=================

Prefix expression is passed as an argument. There are different ways to evaluate it but I have used Stack as it is both simple and efficient. Consider the following example

− * / 15 − 7 + 1 1 3 + 2 + 1 1

The above expression is delimited by space. We split the string into individual tokens.We scan the expression from right to left. If we encounter operand we push it to stack. so we push both 1. we encounter "+", now we pop the last two operands which is 1 and 1 and apply the operator. so result is 2 and we push 2 to stack. This is the easiest way to evaluate prefix expressions. I have handled some exceptions and implemented this in java. Please see the java file for source code.
