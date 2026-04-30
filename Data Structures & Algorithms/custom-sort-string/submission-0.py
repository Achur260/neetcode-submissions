class Solution:
    def customSortString(self, order: str, s: str) -> str:
        dict = {}

        for char in s:
            if (char not in dict): 
                dict[char] = 0
            dict[char]+=1
        

        res = ""

        for char in order:
            if (char in dict):
                for i in range(dict[char]):
                    res += char
        
        for char in dict:
            if (char not in order):
                for i in range(dict[char]):
                    res += char
    
        
        return res
        