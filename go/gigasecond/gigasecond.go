package gigasecond

import (
	"time"
)

const TestVersion = 2
const gigaSecond = 1e9

func AddGigasecond(thetime time.Time) time.Time {
	return thetime.Add(gigaSecond * time.Second)
}

var myLocation, err = time.LoadLocation("Europe/Paris")
var Birthday = time.Date(1984, 7, 27, 1, 0, 0, 0, myLocation)
