import Foundation
var numSet = Set<Int>()
func solution(_ x:Int, _ y:Int, _ n:Int) -> Int {
    return bfs(x, y, n, 0)
}
func bfs(_ num: Int, _ y: Int, _ n: Int, _ count: Int) -> Int {
    numSet.insert(num)
    var queue = Queue<(Int, Int, Int, Int)>()
    
    queue.push((num, y, n, count))
    
    while !queue.isEmpty {
        let poll = queue.pop()!
        if poll.0 == y {
            return poll.3
        }
        if poll.0 > y {
            continue
        }
        let x1 = poll.0 + n
        let x2 = poll.0 * 2
        let x3 = poll.0 * 3
    
        if x1 <= 1000000 && !numSet.contains(x1) {
            numSet.insert(x1)
             queue.push((x1, poll.1, poll.2, poll.3 + 1))
        }
         if x2 <= 1000000 && !numSet.contains(x2) {
                 numSet.insert(x2)
                  queue.push((x2, poll.1, poll.2, poll.3 + 1))
         }
        if x3 <= 1000000 && !numSet.contains(x3) {
                  numSet.insert(x3)
              queue.push((x3, poll.1, poll.2, poll.3 + 1))
              }
    }
    return -1
    
    
}


struct Queue<T> {
   var inputStack = [T]()
   var outputStack = [T]()
   
    var isEmpty: Bool {
        return inputStack.isEmpty && outputStack.isEmpty
    }
   mutating func push(_ element: T) {
       inputStack.append(element)
   }
   mutating func pop() -> T? {
       if outputStack.isEmpty {
           outputStack = inputStack.reversed()
           inputStack.removeAll()
       }
       return outputStack.popLast()
   }
   mutating func top() -> T? {
       if outputStack.isEmpty {
           outputStack = inputStack.reversed()
           inputStack.removeAll()
       }
       return outputStack.isEmpty ? nil : outputStack[outputStack.count - 1]
   }
}
