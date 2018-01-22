(ns gol.core
  (:require [clojure.core.matrix :as matrix])
  (:gen-class))

(defn seed
  [width height]
  (matrix/new-matrix height width))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
