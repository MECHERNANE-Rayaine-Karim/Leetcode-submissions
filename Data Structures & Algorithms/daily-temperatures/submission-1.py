class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = deque()
        stack.append(0)
        answer = [0] * len(temperatures)
        for i in range(1,len(temperatures)):
            while( stack and temperatures[stack[-1]] < temperatures[i]):
                answer[stack[-1]] = i-stack[-1]
                stack.pop()
            stack.append(i)
        return answer