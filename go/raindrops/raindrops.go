package raindrops

import (
	"strconv"
)

func Convert(number int) string {
	output := ""
	if (isDivisible(number, 3)) {
		output += "Pling"
	}
	if (isDivisible(number, 5)) {
		output += "Plang"
	}
	if (isDivisible(number, 7)) {
		output += "Plong"
	}
	if (output == "") {
		output += strconv.Itoa(number)
	}
	return output
}

func isDivisible(number int, factor int) bool {
	return number%factor == 0
}

