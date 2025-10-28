import Foundation


import Foundation

var heap = Heap<Int>()

let n = Int(readLine()!)!
var output = [String]()

for _ in 0..<n {
    let x = Int(readLine()!)!
    if x == 0 {
        if let val = heap.pop() {
            output.append(String(val))
        } else {
            output.append("0")
        }
    } else {
        heap.add(x)
    }
}

print(output.joined(separator: "\n"))

struct Heap<T: Comparable> {
    var node = [T]()
    
    var compare: (T, T) -> Bool = (<=)
    
    mutating func add(_ element: T) {
        var index = node.count
        node.append(element)
        while index > 0, !compare(node[index], node[(index-1)/2]) {
            node.swapAt(index, (index-1)/2)
            index = (index-1)/2
        }
    }
    
    mutating func pop() -> T? {
        if node.count == 0 { return nil }
        else if node.count == 1 { return node.removeFirst() }
        var result = node.first
        node.swapAt(0, node.count - 1)
        _ = node.popLast()
        var index = 0
        

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

