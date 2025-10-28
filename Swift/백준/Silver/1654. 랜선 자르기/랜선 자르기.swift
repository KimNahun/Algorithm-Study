import Foundation



let s = "sdsd"


let input = readLine()!.split(separator: " ")

let n = Int(input[0])!
let k = Int(input[1])!

var start = 1
var end = 0
var result = 0
var mid = 0

var arr = Array(repeating: 0, count: n)
for i in 0..<arr.count {
    let a = Int(readLine()!)!
    arr[i] = a
    if arr[i] >= end {
        end = arr[i]
    }
}

while start <= end {
    var sum = 0
    mid = (start+end)/2
    for i in 0..<arr.count {
        sum += (arr[i]/mid)
    }
    if sum >= k {
        start = mid + 1
  //      end = mid - 1
        result = mid
    } else {
        end = mid - 1
    }
}
print(result)
