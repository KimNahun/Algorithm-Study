import Foundation

var map = [[String]]()
var setMap = Set<[[String]]>()
var tempMap = [[String]]()
var visited = [[Bool]]()
func solution(_ board:[String]) -> Int {
    map = Array(repeating: Array(repeating: "", count: 3), count: 3)
    visited = Array(repeating: Array(repeating: false, count: 3), count: 3)
    tempMap = Array(repeating: Array(repeating: ".", count: 3), count: 3)
    for i in 0..<board.count {
        let index = board[i].startIndex
        for j in 0..<board[i].count {
            let k = board[i].index(index, offsetBy: j)
            let n = String(board[i][k])
            map[i][j] = n
        }
    }
    
    if !checkCount() {
        return 0
    }
    dfs("O")
 //   print(setMap)
  //  setMap.contains(map) 
    return setMap.contains(map) ? 1 : 0
}
func dfs(_ word: String) {
    
    setMap.insert(tempMap)
    
    if checkWin() {
        return
    }
    
    for i in 0..<map.count {
        for j in 0..<map.count {
            
            if tempMap[i][j] == "." {
                tempMap[i][j] = word
                let nextWord = word == "O" ? "X" : "O"
                dfs(nextWord)
                tempMap[i][j] = "."
            }
            
        }
    }
    
}

func checkWin() -> Bool {
    let x = ["O", "X"]
    for v in x {
        if tempMap[0][0] == v && tempMap[0][1] == v && tempMap[0][2] == v { return true }
        if tempMap[1][0] == v && tempMap[1][1] == v && tempMap[1][2] == v { return true }
        if tempMap[2][0] == v && tempMap[2][1] == v && tempMap[2][2] == v { return true }
        
        if tempMap[0][0] == v && tempMap[1][0] == v && tempMap[2][0] == v { return true }
        if tempMap[0][1] == v && tempMap[1][1] == v && tempMap[2][1] == v { return true }
        if tempMap[0][2] == v && tempMap[1][2] == v && tempMap[2][2] == v { return true }
        
        if tempMap[0][0] == v && tempMap[1][1] == v && tempMap[2][2] == v { return true }
        if tempMap[0][2] == v && tempMap[1][1] == v && tempMap[2][0] == v { return true }
    }
    return false
}
func checkCount() -> Bool {
    var countO = 0
    var countX = 0
    for i in 0..<map.count {
        for j in 0..<map.count {
            if map[i][j] == "O" {
                countO += 1
            } else if map[i][j] == "X" {
                countX += 1
            }
        }
    }
    if countX > countO {
        return false
    }
    if countO - countX >= 2 {
        return false
    }
    
    return true
}