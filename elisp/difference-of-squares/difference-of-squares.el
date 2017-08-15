;;; difference-of-squares.el --- Difference of Squares (exercism)
;; -*- firestarter: ert-run-tests-interactively -*-

;;; Commentary:

;;; Code:
(defun square-of-sums (number)
  "Compute the square of sums"
  (square (apply '+ (number-sequence 1 number))))

(defun sum-of-squares (number)
  "Compute the sum of squares"
  (apply '+ (seq-map 'square (number-sequence 1 number)))
  )

(defun difference (number)
  "Compute the difference of sums"
  (- (square-of-sums number) (sum-of-squares number)))

(defun square (number)
  "Compute the square of a number"
  (* number number))

(provide 'difference-of-squares)
;;; difference-of-squares.el ends here
