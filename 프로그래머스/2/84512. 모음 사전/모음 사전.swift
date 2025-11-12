import Foundation
let wordList = ["A", "E", "I", "O", "U"]
var l = [String]()
func solution(_ word:String) -> Int {
    dfs(0, "")
    l = l.sorted()

    for i in 0..<l.count {
        if l[i] == word {
            return i + 1
        }
    }

    return 0
}
func dfs(_ depth: Int, _ word: String) {
    if depth == 6 {
        return
    }
    if depth >= 1 {
     //   print(word)
        l.append(word)
    }
    for i in 0..<wordList.count {
        
        dfs(depth+1, "\(word)\(wordList[i])")
    }
}