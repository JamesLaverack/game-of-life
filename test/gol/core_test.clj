(ns gol.core-test
  (:require [clojure.test :refer :all]
            [clojure.core.matrix :as matrix]
            [gol.core :refer :all]))

(defn all-matrix-true
  [m]
  (matrix/ereduce (fn [a b] (and a b)) m))

(deftest test-seed
  (let [width 100
        height 50
        world (seed width height)]
    (testing "world created in the correct size"
      (is (= height (matrix/row-count world)))
      (is (= width (matrix/column-count world))))
    (testing "world created empty"
      (is (all-matrix-true (matrix/emap false? world))))))
