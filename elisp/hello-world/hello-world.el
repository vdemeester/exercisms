;;; hello-world.el --- Hello World Exercise (exercism)

;;; Commentary:

;;; Code:
(defun hello (&optional name)
  "Hello world, first exercism"
  (or name (setq name "World"))
  (format "Hello, %s!" name)
  )

(provide 'hello-world)
;;; hello-world.el ends here
