import Foundation

func solution(_ s:String) -> Int {
    if s.isEmpty { return 0 }

    let n = s.count
    let doubled = s + s
    let arr = Array(doubled)
    var answer = 0

    for i in 0..<n {
        if checkWord(String(Array(arr[i..<i+n]))) {
            answer += 1
        }
    }
    return answer
}
func reverseWord(_ n: String) -> String {
    var reverse = ""
    switch n {
        case "]": reverse = "["
        case "}": reverse = "{"
        case ")": reverse = "("
        default: reverse = ""
    }
    return reverse
}
func checkWord(_ word: String) -> Bool {
    var stack = [String]()
    
    for i in 0..<word.count {
        let idx = word.startIndex
        let k = word.index(idx, offsetBy: i)
        let n = String(word[k])
        
        if n == "[" || n == "{" || n == "(" {
            stack.append(n)
        } else if n == "]" || n == "}" || n == ")" {
            if stack.isEmpty {
                return false
            }
            else if stack[stack.count - 1] == reverseWord(n) {
                stack.popLast()
            } else {
                return false
            }
        } else {
            return false
        }
    }
    
    if !stack.isEmpty {
        return false
    } else {
        return true
    }
}
func makeWord(_ word: String) -> [String] {
    var result = [String]()
    for i in 0..<word.count {
        let idx = word.startIndex
        var now = ""
        for j in 0..<word.count {
            let k = word.index(idx, offsetBy: (i+j)%word.count)
            let n = String(word[k])
            now = "\(now)\(n)"
        }
        result.append(now)
    }
    return result
    
}