import Foundation

var array: [Int] = []
var map = [[String]]()
var visited = [[Bool]]()
var sum = 0
let dx = [-1, 1, 0, 0]
let dy = [0, 0, -1, 1]
func solution(_ maps:[String]) -> [Int] {
    map = Array(repeating: Array(repeating: "", count: maps[0].count), count: maps.count)
    visited = Array(repeating: Array(repeating: false, count: maps[0].count), count: maps.count)
    for i in 0..<maps.count {
        let word = maps[i]
        for j in 0..<maps[0].count {
            let index = word.index(word.startIndex, offsetBy: j)
            map[i][j] = String(word[index])
        }
    }
    var result: [Int] = []
    for i in 0..<maps.count {
        for j in 0..<maps[i].count {
            if map[i][j] != "X" && !visited[i][j] {
                sum = 0
                dfs(y: i, x: j)
                result.append(sum)
            }
        }
    }
    
    return result.isEmpty ? [-1] : result.sorted()
}
func dfs(y: Int, x: Int) {
    visited[y][x] = true
    sum += Int(map[y][x])!
    
    for i in 0..<dx.count {
        let nextY = y + dy[i]
        let nextX = x + dx[i]
        if nextY < 0 || nextX < 0 || nextY >= map.count || nextX >= map[0].count {
            continue
        }
        if map[nextY][nextX] == "X" {
            continue
        }
        if visited[nextY][nextX] {
            continue
        }
        dfs(y: nextY, x: nextX)
    }
} 