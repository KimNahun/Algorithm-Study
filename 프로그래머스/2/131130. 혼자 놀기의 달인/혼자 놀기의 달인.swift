import Foundation
var maximum = 0
var visited = [Bool]()
var arr = [Int]()
func solution(_ cards:[Int]) -> Int {
    visited = Array(repeating: false, count: cards.count)
    arr = cards
   // visited[0] = true
    for i in 0..<visited.count {
        visited = Array(repeating: false, count: cards.count)
         dfs(i, true, 0, 0)
    }
    return maximum
}

func dfs(_ index: Int, _ first: Bool, _ sum1: Int,_ sum2: Int) {
   // print(index, first, sum1, sum2, visited)
        if visited[index] {
            if first {
                for i in 0..<visited.count {
                    if !visited[i] {
                        dfs(i, false, sum1, sum2)
                    }
                }
            } else {
                maximum = max(maximum, sum1 * sum2)
                return
            }
        } else {
            visited[index] = true
            if first {
                dfs(arr[index]-1, first, sum1+1, sum2)
            } else {
                dfs(arr[index]-1, first, sum1, sum2+1)
            }
            visited[index] = false
        }
}
