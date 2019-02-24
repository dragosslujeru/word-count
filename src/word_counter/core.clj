(ns word-counter.core
  (:require [clojure.java.io :as io])
  (:require [clojure.pprint :as pp])
  (:gen-class))

(defn get-frequencies
  [arg]
  (map #(frequencies (re-seq #"(?m)\w+" (slurp (.getAbsolutePath %)))) arg)
)

(defn merge-map
  [arg1 arg2]
  (merge-with + arg1 arg2))

(defn -main
  [& args]
  (def f (clojure.java.io/file "resources"))
  (def fs (file-seq f))
  (def only-files (filter #(.isFile %) fs))
  (println (reduce merge-map (get-frequencies only-files))))