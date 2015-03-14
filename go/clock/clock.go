package clock

import "fmt"

const (
	TestVersion = 2
	HourMinutes = 60
	MinutesADay = 1440
)

// Clock is a int that represent the number of minutes
type Clock int

func Time(hour, minute int) Clock {
	// Number of minutes given
	minutes := (hour * HourMinutes) + minute
	clock := Clock(normalize(minutes))
	return clock
}

func (clock Clock) Add(minute int) Clock {
	minutes := int(clock + Clock(minute))
	clock = Clock(normalize(minutes))
	return clock
}

func (clock Clock) String() string {
	return fmt.Sprintf("%02d:%02d", clock/60, clock%60)
}

func normalize(minutes int) int {
	minute := minutes % MinutesADay
	if (minute < 0) {
		minute += MinutesADay
	}
	return minute
}
