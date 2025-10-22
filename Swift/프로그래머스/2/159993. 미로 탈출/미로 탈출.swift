import Foundation

var map = [[String]]()
var visited = [[Bool]]()
var point: (Int, Int, Int, Int, Int, Int) = (0,0,0,0,0,0)
let dx = [-1, 1, 0, 0]
let dy = [0, 0, -1, 1]
var result = 0
var find = false

func solution(_ maps:[String]) -> Int {
    
    map = Array(repeating: Array(repeating: "", count: maps[0].count), count: maps.count)
    visited = Array(repeating: Array(repeating: false, count: maps[0].count), count: maps.count)
    for i in 0..<map.count {
        var word = maps[i]
        for j in 0..<maps[0].count {
            var index = word.startIndex
            var k = word.index(index, offsetBy: j)
            map[i][j] = String(word[k])
            if map[i][j] == "S" {
                point.0 = i
                point.1 = j
            } else if map[i][j] == "L" {
                point.2 = i
                point.3 = j
            } 
        }
    }
    var sum = 0
    bfs(y: point.0, x: point.1, purpose: "L", count: 0)
    if !find { return -1 }
    find = false
    sum += result
visited = Array(repeating: Array(repeating: false, count: maps[0].count), count: maps.count)
    
    
    bfs(y: point.2, x: point.3, purpose: "E", count: 0)
    if !find { return -1 }
    sum += result
    
    return sum
}
func bfs(y: Int, x: Int, purpose: String, count: Int) {
    var queue = [(Int, Int, String, Int)]()
    queue.append((y, x, purpose, count))
    visited[y][x] = true
    while !queue.isEmpty {
        let poll = queue.removeFirst()
         if map[poll.0][poll.1] == purpose && !find {
              result = poll.3
                  find = true
         }
         if find {
                  return
        }
        
            for i in 0..<dx.count {
       let nextY = poll.0 + dy[i]
        let nextX = poll.1 + dx[i]
       if nextY<0 || nextX<0 || nextY >= map.count || nextX>=map[0].count {
                continue
        }
        if map[nextY][nextX] == "X" {
            continue
        }
        if visited[nextY][nextX] {
            continue
        }
        queue.append((nextY, nextX, purpose, poll.3+1))
        visited[nextY][nextX] = true
    }
    }


    
}