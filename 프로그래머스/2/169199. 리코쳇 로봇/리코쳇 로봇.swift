import Foundation

var map = [[String]]()
var visited = [[Bool]]()
var start = [Int]()
var end = [Int]()
let dy = [-1, 0, 1, 0]
let dx = [0, 1, 0, -1]
var cnt = 5000000
func solution(_ board:[String]) -> Int {
    map = Array(repeating: Array(repeating: "", count: board[0].count), count: board.count)
     visited = Array(repeating: Array(repeating: false, count: board[0].count), count: board.count)
    for i in 0..<board.count {
        for j in 0..<board[i].count {
            let idx = board[i].startIndex
            let k = board[i].index(idx, offsetBy: j)
            map[i][j] = String(board[i][k])
            if map[i][j] == "R" {
                start.append(i)
                start.append(j)
            }
        }
    }
    return bfs(start[0], start[1])
}
// 0 . 아래 .
// 1 . 오른쪽 . 
// 2 . 위 . 
// 3 . 왼쪽 .
// func dfs(_ y: Int,_ x: Int,_ direction: Int, _ count: Int) {
//     if map[y][x] == "G" {
//         cnt = min(cnt, count)
//         return
//     }
//     visited[y][x] = count
//         var nextY = y + dy[direction]
//         var nextX = x + dx[direction]
//         while true {
//             if nextY < 0 || nextX < 0 || nextY >= map.count || nextX >= map[0].count {
//                 break
//             }
//             if map[nextY][nextX] == "D" {
//                 break
//             }
//             nextY = nextY + dy[direction]
//             nextX = nextX + dx[direction]
//        }
//         let prevY = nextY - dy[direction]
//         let prevX = nextX - dx[direction]
//         for j in 0..<dx.count {
//              if visited[prevY][prevX] > count && !(prevY == y && prevX == x) {
//                 dfs(prevY, prevX, j, count + 1)
//             }   
//         }
// }
func bfs(_ y: Int,_ x: Int) -> Int {
    var queue = Queue<[Int]>()
    queue.add([y, x, 0])
    while !queue.isEmpty {
        let poll = queue.poll()!
        
        if map[poll[0]][poll[1]] == "G" {
            return poll[2]
        }
        
        for i in 0..<dx.count {
            let next = getNext(poll[0], poll[1], i)
            if !visited[next[0]][next[1]] {
                queue.add( [next[0] , next[1] , poll[2] + 1 ])
                visited[next[0]][next[1]] = true
            }
        }
        
    }
    return -1
}
func getNext(_ y: Int,_ x: Int,_ direction: Int) -> [Int] {
        var nextY = y + dy[direction]
        var nextX = x + dx[direction]
        while true {
            if nextY < 0 || nextX < 0 || nextY >= map.count || nextX >= map[0].count {
                break
            }
            if map[nextY][nextX] == "D" {
                break
            }
            nextY = nextY + dy[direction]
            nextX = nextX + dx[direction]
       }
        let prevY = nextY - dy[direction]
        let prevX = nextX - dx[direction]
    return [prevY, prevX, direction]
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
