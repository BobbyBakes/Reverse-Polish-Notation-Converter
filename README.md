# Reverse-Polish-Notation-Converter (RPN Converter)

Assuming that infix and RPN equations are given in the format outlined in the RPN exercise, 
conversion is processed through string manipulation in combination of the usage of stacks. 

Language: Java 
Build: Gradle

Assuming that infix and RPN equations are given in the format outlined in the RPN exercise, 
conversion is processed through string manipulation in combination of the usage of stacks. 

**Infix to RPN Strategy:** 
Each character in the equation is read. Operands are written to a string representing the result. In the instance of an operator, operators are pushed to a stack. In the case that the next operator being pushed to the stack has lower precedence than the operator at the top of the stack, then the stack is emptied until the operator remaining in the stack has lower precedence. The operator in question is then pushed to the stack. 

Once the end of the equation is reached, the remaining stack is written to the end of the resulting string, representing an equation in RPN. 

**RPN to Infix Strategy:** 
Each character in the equation is read. Operands are pushed to a stack. Once a operator is read, the top two objects in the stack are popped. The operator is then placed between those two string objects and surrounded by parenthesis. 
The resulting string is then pushed back to the stack and the next character is read. 
Once another operator is read, the top two are popped off the stack and the operator is placed between the two objects and surrounded by parenthesis. 

This is repeated until the end of the equation.
The remaining string left in the stack is returned in a peek, representing a string an equation in RPN. 

Infix to RPN Strategy: 
Each character in the equation is read. Operands are written to a string representing the result. In the instance of an operator, operators are pushed to a stack. In the case that the next operator being pushed to the stack has lower precedence than the operator at the top of the stack, then the stack is emptied until the operator remaining in the stack has lower precedence. The operator in question is then pushed to the stack. 

Once the end of the equation is reached, the remaining stack is written to the end of the resulting string, representing an equation in RPN. 

RPN to Infix Strategy: 
Each character in the equation is read. Operands are pushed to a stack. Once an operator is read, the top two objects in the stack are popped. The operator is then placed between those two string objects and surrounded by parenthesis. 
The resulting string is then pushed back to the stack and the next character is read. 
Once another operator is read, the top two are popped off the stack and the operator is placed between the two string objects and surrounded by parenthesis. 

This is repeated until the end of the equation.
The raining string left in the stack is returned in a peek, representing a string an equation in RPN




