package bob

import (
	"strings"
	"unicode"
)

func Hey(remark string) string {
	remark = strings.TrimRightFunc(remark, unicode.IsSpace)
	switch {
	case isShoutout(remark) && isQuestion(remark):
		return "Calm down, I know what I'm doing!"
	case isShoutout(remark):
		return "Whoa, chill out!"
	case isQuestion(remark):
		return "Sure."
	case isSilence(remark):
		return "Fine. Be that way!"
	}
	return "Whatever."
}

func isSilence(s string) bool {
	s = strings.TrimSpace(s)
	return s == ""
}

func isShoutout(s string) bool {
	s = strings.TrimFunc(s, keepLetters)
	return strings.ToUpper(s) == s && s != ""
}

func isQuestion(s string) bool {
	return strings.HasSuffix(s, "?")
}

func keepLetters(r rune) bool {
	return !unicode.IsLetter(r)
}
