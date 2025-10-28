import Foundation

struct Stack<T> {
    var arr = [T]()
    
    var isEmpty: Bool {
        return arr.isEmpty
    }
    var top: T {
        return arr[arr.count - 1]
    }
    mutating func push(_ element: T) {
        arr.append(element)
    }
    mutating func pop() -> T? {
        return arr.isEmpty ? nil : arr.popLast()
    }
}


let n = Int(readLine()!)!

let input = readLine()!.split(separator: " ")

var arr = Array(repeating: -1, count: n)
for i in 0..<arr.count {
    arr[i] = Int(input[i])!
}

var stack = Stack<Int>()

for i in 0..<arr.count {
    
    while !stack.isEmpty && arr[stack.top] < arr[i] {
        let pop = stack.pop()!
        arr[pop] = arr[i]
    }
    
    stack.push(i)
}

while !stack.isEmpty {
    let pop = stack.pop()!
    arr[pop] = -1
}
var result = ""
for i in 0..<arr.count {
    result += String(arr[i])
    result += " "
}
print(result)
