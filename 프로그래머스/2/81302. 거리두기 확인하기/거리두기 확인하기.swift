import Foundation

var result = [Int]()
let dx = [-1,1,0,0]
let dy = [0,0,-1,1]
var map = Array(repeating: Array(repeating: "", count: 5), count: 5)
var visited = Array(repeating: Array(repeating: false, count: 5), count: 5)
var find = false
func solution(_ places:[[String]]) -> [Int] {
    for i in 0..<places.count {
        if bfs(places[i]) {
            result.append(0)
        } else {
            result.append(1)
        }
    }
    return result
}
func bfs(_ arr: [String]) -> Bool {
    
    var queue = Queue<[Int]>()
    for i in 0..<arr.count {
        var index = arr[i].startIndex
        for j in 0..<arr.count {
            let k = arr[i].index(index, offsetBy: j)
            map[i][j] = String(arr[i][k])
        }
    }
    for i in 0..<map.count {
        for j in 0..<map.count {
            if map[i][j] == "P" {
                find = false
                visited = Array(repeating: Array(repeating: false, count: 5), count: 5)
                dfs(i, j, 0)
                if find {
                    return true
                }
            }
        }
    }
    return false
}
func dfs(_ y: Int, _ x: Int, _ depth: Int) {
    if depth > 2 { return }
    visited[y][x] = true
    //print("\(y) \(x) \(depth)")
    if map[y][x] == "P" && depth <= 2 && depth != 0 {
        find = true
        
    }
  
    for i in 0..<dx.count {
        let nextY = y + dy[i]
        let nextX = x + dx[i]
        
        if nextY<0||nextX<0||nextY>=5||nextX>=5 {
            continue
        }
        if visited[nextY][nextX] {
            continue
        }
        if map[nextY][nextX] == "X" {
            continue
        }
        dfs(nextY, nextX, depth+1)
    }
    
}
struct Queue<T> {
    var inputStack = [T]()
    var outputStack = [T]()
    
    var isEmpty: Bool {
        return inputStack.isEmpty && outputStack.isEmpty
    }
    mutating func add(_ element: T) {
        inputStack.append(element)
    }
    mutating func poll() -> T? {
        if outputStack.isEmpty {
            outputStack = inputStack.reversed()
            inputStack.removeAll()
        }
        return outputStack.popLast()
    }
}