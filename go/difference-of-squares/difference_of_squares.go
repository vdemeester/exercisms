package diffsquares

func SquareOfSums(number int) int {
	sum := 0
	for i := 1; i <= number; i++ {
		sum += i
	}
	return square(sum)
}

func SumOfSquares(number int) int {
	sum := 0
	for i := 1; i <= number; i++ {
		sum += square(i)
	}
	return sum
}

func Difference(number int) int {
	return SquareOfSums(number) - SumOfSquares(number)
}

func square(number int) int {
	return number * number
}
