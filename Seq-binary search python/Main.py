import random
import math
array = []
class Main:
    
    def __init__(self, target, array):
        self.target = target
        self.array = array
        
    def sequentialSearch(self):
        for i in range(5000):
            self.array.append(random.randint(0,5000))
        for i in range(5000):
            if self.array[i] == self.target:
                global tries
                tries += i
                
    def average(self):
        print(tries/5000)

for i in range(5000):
    bruh = Main(5, array)
    bruh.sequentialSearch()
bruh.average()
    
    
        
    