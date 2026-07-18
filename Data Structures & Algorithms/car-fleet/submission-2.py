class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        if len(position) <= 1 : return len(position)
        time_to_target = [0] * len(position)
        fleet = 1 
        carsMap = {}
        for i in range(len(position)):
           time_to_target[i] = float(target - position[i])/speed[i] 
           carsMap[position[i]] = time_to_target[i]
        position = sorted(position, reverse=True)
        cars_time = carsMap[position[0]]
        for i in range(1,len(position)):
           if carsMap[position[i]] > cars_time  :
                cars_time = carsMap[position[i]]
                fleet += 1
        return fleet  

        
         
        