;;; bob.el --- Bob exercise (exercism)

;;; Commentary:

;;; Code:
(defun response-for (message)
  "Answer bob in weird ways 👼"
  (cond
   ((isShout (my-chomp message)) "Whoa, chill out!")
   ((isQuestion (my-chomp message)) "Sure.")
   ((isEmpty (my-chomp message)) "Fine. Be that way!")
   (t "Whatever."))
  )

(defun isQuestion (message)
  "Returns true if the message is a question, i.e containst a ?"
  (string-suffix-p "?" message))

(defun isShout (message)
  "Returns true if the message is a SHOUT, i.e. all caps"
  (and (string-match "[A-Z]" message)
       (string= (upcase message) message)))

(defun isEmpty (message)
  "Returns true if the message is empty"
  (= (length message) 0))

(defun my-chomp (str)
  "Trim leading and trailing whitespace from STR."
  (replace-regexp-in-string "\\(\\`[[:space:]\n]*\\|[[:space:]\n]*\\'\\)" "" str))

(provide 'bob)
;;; bob.el ends here
