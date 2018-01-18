package main
import (
    "bufio"
    "fmt"
    "os"
)
func main() {
    var i, j, k, l int = 0, 0, 0, 0, 0
    reader := bufio.NewReader(os.Stdin)
    input, _ := reader.ReadString('\n')
    for _, rune := range input {
        switch {
        case (rune >= 'A' && rune <= 'Z'):
            i++
        case (rune >= 'a' && rune <= 'z'):
            i++
        case rune == ' ' || rune == '\t':
            j++
        case (rune >= '0' && rune <= '9'):
            k++
        default:
            l++
        }
    }
    fmt.Printf("all in all:char=%d space=%d digit=%d others=%d\n", i, j, k, l)
}
