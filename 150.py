# 本题关键在除法那，可能是题目原因，所有计算结果需要取int

class Solution(object):
    def evalRPN(self, tokens):
        """
        :type tokens: List[str]
        :rtype: int
        """
        stack = []
        
        for each in tokens:
            if each not in ('+','-','*','/'):
                stack.append(int(each))
            else:
                a = stack.pop()
                b = stack.pop()
                if each == '+':
                    stack.append(a+b)
                elif each == '-':
                    stack.append(b-a)
                elif each == '*':
                    stack.append(a*b)
                elif each == '/':
                    stack.append(int(float(b)/a))
            
        return stack[0]