import Foundation
struct Time: Comparable {
    let start: Int
    let end: Int
    
    static func <(lhs: Time, rhs: Time) -> Bool {
        if lhs.end != rhs.end {
            return lhs.end > rhs.end
        }
        return lhs.start > rhs.start
    }
}
struct Heap<T: Comparable> {
    var node = [T]()
    var compare: (T, T) -> Bool = (<=)
    
    var isEmpty: Bool {
        return node.isEmpty
    }
    mutating func peek() -> T? {
        return node.first
    }
    mutating func add(_ element: T) {
        var index = node.count
        node.append(element)
        while index > 0, !compare(node[index], node[(index-1)/2]) {
            node.swapAt(index, (index-1)/2)
            index = (index-1)/2
        }
    }
    mutating func poll() -> T? {
        if node.count == 0 { return nil }
        if node.count == 1 { return node.popLast() }
        let result = node.first
        node.swapAt(0, node.count-1)
        var index = 0
        _ = node.popLast()
        
        while index < node.count {
            let left = index*2+1
            let right = left+1
            if right < node.count {
                if compare(node[left], node[right]), !compare(node[right], node[index]) {
                    node.swapAt(right, index)
                    index = right
                } else if !compare(node[left], node[index]) {
                    node.swapAt(left, index)
                    index = left
                } else {
                    break
                }
            } else if left < node.count {
                if !compare(node[left], node[index]) {
                    node.swapAt(left, index)
                    index = left
                } else {
                    break
                }
            } else {
                break
            }
            
        }
        return result
    }
}
func solution(_ book_time:[[String]]) -> Int {
    var timeArr = [Time]()
    var heap = Heap<Time>()
    for i in 0..<book_time.count {
        let start = book_time[i][0]
        let end = book_time[i][1]
        let p1 = start.split(separator: ":")
        let p2 = end.split(separator: ":")
        let s1 = Int(p1[0])! * 60 + Int(p1[1])!
        let s2 = Int(p2[0])! * 60 + Int(p2[1])! + 10
        timeArr.append(Time(start: s1, end: s2))
    }
    let arr = timeArr.sorted {
        if $0.start != $1.start {
            return $0.start < $1.start
        }
        return $0.end < $1.end
    }
    var cnt = 0
  
    // for i in 0..<arr.count {
    //     heap.add(arr[i])
    // }
    // while !heap.isEmpty {
    //     print(heap.poll())
    // }
    for i in 0..<arr.count {
        
        if heap.isEmpty {
     //       print(1)
            heap.add(arr[i])
        } else if heap.peek()!.end > arr[i].start {
       //     print(2)
            heap.add(arr[i])
        } else {
         //   print(3)
            while !heap.isEmpty, heap.peek()!.end <= arr[i].start {
                _ = heap.poll()
            }
            heap.add(arr[i])
        }
     //   print(heap)
        cnt = max(cnt, heap.node.count)
    }
    
    return cnt
}