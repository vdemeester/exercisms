;;; gigasecond.el --- Gigasecond exercise (exercism)

;;; Commentary:
;; Calculate the date one gigasecond (10^9 seconds) from the
;; given date.
;;
;; NB: Pay attention to  Emacs' handling of time zones and dst
;; in the encode-time and decode-time functions.

;;; Code:

(defun from (s mi h d mo y)
  (set-time-zone-rule t)
  (let* ((time (encode-time s mi h d mo y))
	 (giga (seconds-to-time 1000000000))
	 (time-plus-giga (time-add time giga)))
    (subseq (decode-time time-plus-giga) 0 6)))

(provide 'gigasecond)
;;; gigasecond.el ends here
