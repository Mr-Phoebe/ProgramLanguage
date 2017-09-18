package main
import (
    "fmt"
)
func main() {
    const max int = 3
    var array [max][max]int
    var sum int
    for i := 0; i < max; i++ {
        for j := 0; j < max; j++ {
            fmt.Printf("array[%d][%d]=", i, j)
            fmt.Scanf("%d\n", &array[i][j])
        }
    }
    for i := 0; i < max; i++ {
        sum += array[i][i]
    }
    for i := 0; i < max; i++ {
        sum += array[i][max-i-1]
    }
    if max%2 == 1 {
        sum -= array[max/2][max/2]
    }
    fmt.Println(sum)
}
