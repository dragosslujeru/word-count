(ns word-counter.core
  (:gen-class))

(defn foo
  [a b]
  (if a 
    (println a)
    (println b)))

(defn -main
  [& args]
  (foo nil "bbbb"))
