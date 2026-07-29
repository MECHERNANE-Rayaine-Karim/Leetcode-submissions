class TimeMap:

    
    

    def __init__(self ):
        self.values_dict = {}
        self.keys_dict = {}

    def set(self, key: str, value: str, timestamp: int ) -> None:
        timestamps_list = [timestamp]
        if key in self.keys_dict:
            timestamps_list = self.keys_dict[key] 
            timestamps_list.append(timestamp)
        self.keys_dict[key] = timestamps_list
        self.values_dict[timestamp] = value

    def get_timestamp(self,timestamps_list:List[int] ,timestamp: int ) -> int:
        if timestamps_list[-1] < timestamp :
             return timestamps_list[-1]
        left = 0
        right = len(timestamps_list)-1
        found = -1
        while left <= right:
            mid = left + (right-left)//2
            if timestamps_list[mid] == timestamp:
                found = timestamps_list[mid]
                break
            elif timestamps_list[mid] < timestamp:
                found = timestamps_list[mid]
                left = mid+1
            else:
                right = mid-1
        return found


    def get(self, key: str, timestamp: int) -> str:
        
        if key in self.keys_dict :
            timestamps_list = self.keys_dict[key]
            used_time = self.get_timestamp(timestamps_list,timestamp)
            if used_time != -1:
                return self.values_dict[used_time]
        return ""

    


