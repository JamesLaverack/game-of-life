(ns gol.core
  (:require [clojure.core.matrix :as matrix])
  (:gen-class))

(defn seed
  [width height]
  (matrix/fill (matrix/new-matrix height width) false))



(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
