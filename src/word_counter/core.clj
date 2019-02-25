(ns word-counter.core
  (:require [clojure.java.io :as io])
  (:require [clojure.pprint :as pp])
  (:gen-class))

(defn get-frequencies
  [files]
  (pmap (fn [e]
          (->> e
               (slurp)
               (re-seq #"(?m)\w+")
               (frequencies))) files))

(defn merge-map
  [m1 m2]
  (merge-with + m1 m2))

(defn java?
  [file]
  (and (.isFile file) (.endsWith (.getName file) ".java")))

(defn sort-map
  [map]
  (into
   (sorted-map-by (fn [key1 key2]
                    (compare [(get map key2) key2]
                             [(get map key1) key1]))) map))

(defn -main
  [& args]
  (let [f (clojure.java.io/file (first args))
        fs (file-seq f)
        java-files (filter java? fs)]
    (pp/pprint (sort-map (reduce merge-map (get-frequencies java-files))))))