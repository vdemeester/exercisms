;;; bob.el --- Bob exercise (exercism)

;;; Commentary:

;;; Code:
(defun response-for (message)
  "Answer bob in weird ways 👼"
  (cond
   ((isShout message) "Whoa, chill out!")
   ((string-suffix-p "?" message) "Sure.")
   ((string-blank-p message) "Fine. Be that way!")
   (t "Whatever."))
  )

(defun isShout (message)
  "Returns true if the message is a SHOUT, i.e. all caps"
  (and (string-match "[A-Z]" message)
       (string= (upcase message) message)))

(provide 'bob)
;;; bob.el ends here
