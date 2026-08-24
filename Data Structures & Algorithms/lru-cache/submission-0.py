class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None

class LRUCache:
    
    def __init__(self, capacity: int):
        self.cache_capacity = capacity
        self.cache_dict = {}
        self.current_loading = 0
        self.head = None
        self.tail = None
        
    def get(self, key: int) -> int:
        if key in self.cache_dict:
            node = self.cache_dict[key]
            value = node.value
            if node == self.head:
                return self.head.value
            elif node == self.tail:
                self.tail = self.tail.prev
                self.tail.next = None
            else:
                node.prev.next = node.next
                node.next.prev = node.prev
            node.next = None
            node.prev = None
            self.head.prev = node
            node.next = self.head
            self.head = node                 
            return self.head.value
        return -1

    def put(self, key: int, value: int) -> None:
        if key in self.cache_dict:
            node = self.cache_dict[key]
            if node == self.head:
                self.head.value = value
                return
            elif node == self.tail:
                self.tail = self.tail.prev
                self.tail.next = None
            else:
                node.prev.next = node.next
                node.next.prev = node.prev
            self.current_loading -= 1
        elif self.current_loading >= self.cache_capacity:
            evict_key = self.tail.key
            self.tail = self.tail.prev
            if self.tail:
                self.tail.next = None
            self.cache_dict.pop(evict_key)
            self.current_loading -= 1
        if self.current_loading == 0:
            self.head = Node(key,value)
            self.tail = self.head
        else:
            new = Node(key,value)
            self.head.prev = new
            new.next = self.head
            self.head = new                    
        self.cache_dict[key] = self.head
        self.current_loading += 1




# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)