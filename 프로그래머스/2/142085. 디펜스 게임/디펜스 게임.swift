import Foundation

func solution(_ n:Int, _ k:Int, _ enemy:[Int]) -> Int {
    var heap = Heap<Int>()
    var minion = n
    var shield = k
    var cnt = 0
    for i in 0..<enemy.count {
          heap.add(enemy[i])
        if minion - enemy[i] >= 0 {
            minion -= enemy[i]
        } else {
            if shield == 0 {
                return cnt
            }
            else {
                var poll = heap.poll()!
                shield -= 1
                minion += poll
                minion -= enemy[i]
            }
        }
      // print("\(shield) \(minion)")
        cnt += 1
    }
    return cnt
}

struct Heap<T: Comparable> {
    let compare: (T, T) -> Bool = (<=)
    var node = [T]()
    
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
        node.swapAt(0, node.count - 1)
        var index = 0
        _ = node.popLast()
        
        while index < node.count {
            let left = index*2+1
            let right = left+1
            if right < node.count {
                if compare(node[left], node[right]), !compare(node[right], node[index]) {
                     node.swapAt(right, index)
                     index = right
                }
                else if !compare(node[left], node[index]) {
                    node.swapAt(left, index)
                    index = left
                } else {
                    break
                }
            }
            else if left < node.count {
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