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
                dict[char] = 0
        
        for char in dict:
            for i in range(dict[char]):
                res += char
    
        
        return res
        