(ns gol.core
  (:require [clojure.core.matrix :as matrix])
  (:gen-class))

(defn seed
  [width height]
  (matrix/fill (matrix/new-matrix height width) false))

(defn rand-bool [] (= 0 (rand-int 2)))

(defn randomise [world] (matrix/emap (fn [i] (rand-bool)) world))

(def relative-coords (filter #(not (= [0 0] %)) (for [x [-1 0 1] y [-1 0 1]] (list x y))))

(defn width [world] (matrix/column-count world))

(defn height [world] (matrix/row-count world))

(defn wrap-coord
  [width height [x y]]
  (list (mod x width) (mod y height)))

(defn find-neighbors
  [world loc]
  (let [coords (map #(matrix/add loc %) relative-coords)
        wrapped-coords (map (partial wrap-coord (width world) (height world)) coords)]
    (map (fn [[x y]] (matrix/mget world x y)) wrapped-coords)))

(def alive? true?)

(defn step-cell
  [[x y] cell neighbor-cells]
  (let [alive-neighbors (count (filter alive? neighbor-cells))]
    (if (alive? cell)
      (cond
        (< alive-neighbors 2) false
        (> alive-neighbors 3) false
        :else true)
      (= alive-neighbors 3))))

(defn step
  [world]
  (matrix/emap-indexed (fn [loc cell] (step-cell loc cell (find-neighbors world loc))) world))

(defn display [world] (str world))

(defn play-game
  [world iterations]
  (println (display world))
  (if (> iterations 0) (recur (step world) (- iterations 1))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (play-game (randomise (seed 5 5)) 10))
