import Foundation

func solution(_ order:[Int]) -> Int {
    var stack = Stack<Int>()
    var queue = Queue<Int>()
    for i in 0..<order.count {
        queue.enqueue(i+1)
    }

    var idx = 0
    while true {
        if !stack.isEmpty, stack.peek() == order[idx] {
            _ = stack.pop()
            idx += 1
         //   print(1)
        } else {
            if !queue.isEmpty, queue.peek() == order[idx] {
                _ = queue.dequeue()
                idx += 1
            //    print(queue.peek())
         //       print(2)
            } else if !queue.isEmpty, queue.peek() != order[idx] {
                stack.push(queue.dequeue()!)
           //     print(3)
            } else {
                break
            }
        }
      //  print(queue.inputStack, queue.outputStack, stack.node)
    } 
    
    return idx
}

struct Queue<T> {
    var inputStack = [T]()
    var outputStack = [T]()
    var isEmpty: Bool {
        return inputStack.isEmpty && outputStack.isEmpty
    }
    mutating func enqueue(_ element: T) {
        inputStack.append(element)
    }
    mutating func dequeue() -> T? {
        if outputStack.isEmpty {
            outputStack = inputStack.reversed()
            inputStack.removeAll()
        }
        return outputStack.popLast()
    }
    mutating func peek() -> T? {
         if outputStack.isEmpty {
            outputStack = inputStack.reversed()
            inputStack.removeAll()
        }
        return outputStack.isEmpty ? nil : outputStack[outputStack.count - 1]
    }
}
struct Stack<T> {
    var node = [T]()
    var isEmpty: Bool {
        return node.isEmpty
    }
    
    mutating func push(_ element: T) {
        node.append(element)
    }
    mutating func pop() -> T {
        return node.popLast()!
    }
    mutating func peek() -> T {
        return node[node.count - 1]
    }
}
