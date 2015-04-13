package gigasecond

import (
	"time"
)

const TestVersion = 2
const gigaSecond time.Duration = 1e9 * time.Second

func AddGigasecond(thetime time.Time) time.Time {
	return thetime.Add(gigaSecond)
}

var myLocation, err = time.LoadLocation("Europe/Paris")
var Birthday = time.Date(1984, 7, 27, 1, 0, 0, 0, myLocation)
