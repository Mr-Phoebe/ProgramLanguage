package main
import (
        "fmt"

)
func main() {
    /*以下为三重循环*/
    for i := 1; i < 5; i++ {
        for j := 1; j < 5; j++ {
            for k := 1; k < 5; k++ {
                if i != k && i != j && j != k {
                    fmt.Println(i, j, k)
                }
            }
        }
}

