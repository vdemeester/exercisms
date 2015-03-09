package leap

const TestVersion = 1

func IsLeapYear(year int) bool {
	return isYearDivisibleBy4(year) && !isYearDivisibleBy100(year) || isYearDivisibleBy400(year);
}

func isYearDivisibleBy4(year int) bool {
	return year%4 == 0
}

func isYearDivisibleBy100(year int) bool {
	return year%100 == 0
}

func isYearDivisibleBy400(year int) bool {
	return year%400 == 0
}

